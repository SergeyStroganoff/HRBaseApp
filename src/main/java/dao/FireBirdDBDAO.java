package dao;

import config.MainConfig;
import entities.Department;
import entities.Employee;
import entities.Position;
import exception.DaoException;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FireBirdDBDAO implements ActionDAO {

    private static final Logger logger = Logger.getLogger(FireBirdDBDAO.class);
    private Connection connection;
    private Statement statement;

    public FireBirdDBDAO() {

        try {
            Class.forName(MainConfig.getProperty("FIREBIRD.driver")).getDeclaredConstructor().newInstance();

        } catch (InstantiationException e) {
            logger.error("Error instantiation driver" + e.toString());
        } catch (InvocationTargetException e) {
            logger.error("Error invocation driver" + e.toString());
        } catch (NoSuchMethodException e) {
            logger.error(e.toString());
        } catch (IllegalAccessException e) {
            logger.error(e.toString());
        } catch (ClassNotFoundException e) {
            logger.error(e.toString());
        }

        try {
            this.connection = getConnection();
            this.statement = connection.createStatement();
            logger.info("Подключение к БД прошло успешно");
        } catch (SQLException th) {
            logger.error("Error sql" + th.toString());
            th.printStackTrace();
        } catch (IOException e) {
            logger.error("Error IO" + e.toString());
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException, IOException {

        String url = MainConfig.getProperty("url");
        System.out.println(url);
        String username = MainConfig.getProperty("username");
        String password = MainConfig.getProperty("password");
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public int addEntity(Employee employee) throws DaoException {
        int result = 0;

        final String INSERT = "INSERT into employee (surname, fname, sname, birthdate, position_id, departament_id, access_secrets)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(INSERT, new String[]{"ID"})) {


            stmt.setString(1, employee.getSurname());
            stmt.setString(2, employee.getFirstName());
            stmt.setString(3, employee.getSecondName());
            stmt.setDate(4, java.sql.Date.valueOf(employee.getBirthDate()));
            stmt.setInt(5, employee.getPosition().getID());
            stmt.setInt(6, employee.getDepartment().getID());
            stmt.setBoolean(7, employee.getAccessSecret());

            result = stmt.executeUpdate();

            ResultSet gk = stmt.getGeneratedKeys();
            if (gk.next()) {
                result = gk.getInt("ID");
            }
            gk.close();

        } catch (SQLException e) {
            logger.error("Ошибка добавления записи в базу данных");
            throw new DaoException("Ошибка добавления записи в базу данных", e);

        }
        return result;
    }

    @Override
    public void updateEntity(Employee employee) throws DaoException {

        final String UPDATE = "UPDATE employee SET surname=?, fname=?, sname=?, birthdate=?, position_id=?, departament_id=?, access_secrets=? WHERE id=?";

        try (PreparedStatement stmt = connection.prepareStatement(UPDATE)) {

            stmt.setString(1, employee.getSurname());
            stmt.setString(2, employee.getFirstName());
            stmt.setString(3, employee.getSecondName());
            stmt.setDate(4, java.sql.Date.valueOf(employee.getBirthDate()));
            stmt.setInt(5, employee.getPosition().getID());
            stmt.setInt(6, employee.getDepartment().getID());
            stmt.setBoolean(7, employee.getAccessSecret());
            stmt.setInt(8, employee.getID());

            int result = stmt.executeUpdate();
            System.out.println(result);

        } catch (Exception e) {

            logger.error("Ошибка добавления записи в базу данных");
            throw new DaoException(e);
        }
    }

    @Override
    public void deleteEntity(int employeeId) throws DaoException {

        final String DELETE = "DELETE FROM employee WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(DELETE)) {
            stmt.setInt(1, employeeId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Ошибка SQL запроса при удалении записи " + e.toString());
            throw new DaoException(e.toString());
        }
    }

    @Override
    public Employee getEntity(int employeeId) throws DaoException {
        ParamRequest paramRequest = new ParamRequest(employeeId);
        List<Employee> employeeList = findEntity(paramRequest);
        return employeeList.get(0);
    }

    @Override
    public List<Employee> findEntity(ParamRequest paramRequest) throws DaoException {

        List<Employee> employeeList = null;
        ResultSet resultSet = null;

        try {
            resultSet = doRequest(paramRequest);
            employeeList = new ArrayList<>();

            while (resultSet.next()) {

                Position position = new Position(
                        resultSet.getInt(16),
                        resultSet.getString(17),
                        resultSet.getFloat(18));

                Department department = new Department(resultSet.getInt(9),
                        resultSet.getString(15),
                        resultSet.getInt(10),
                        resultSet.getString(11),
                        resultSet.getString(12));

                Employee employee = new Employee(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5).toLocalDate(),
                        position, department,
                        resultSet.getBoolean(8));

                employeeList.add(employee);

                employee.toString();
            }

        } catch (SQLException throwables) {
            logger.error("Ошибка SQL запроса" + throwables.toString());
            throw new DaoException(throwables.toString());
        }

        return employeeList;
    }

    private ResultSet doRequest(ParamRequest parameters) throws SQLException {

        String whereSQL = ";";

        if (parameters.getID() != null) {
            whereSQL = String.format("WHERE e.id = %d order by e.id;", parameters.getID());
        }
        if (parameters.getSurname() != null && parameters.getFirstName() != null) {
            whereSQL = String.format("WHERE e.surname like '%%%s%%' and e.fname like '%%%s%%'   order by e.surname;", parameters.getSurname(), parameters.getFirstName());
        } else if (parameters.getSurname() != null) {
            whereSQL = String.format("WHERE e.surname like '%%%s%%' order by e.surname;", parameters.getSurname());
        }

        return statement.executeQuery
                ("SELECT * from employee e " +
                        "join departments d on e.departament_id = d.id " +
                        "join departnames n on d.departnameid = n.id " +
                        "join positions p on e.position_id = p.id " + whereSQL);
    }
}
