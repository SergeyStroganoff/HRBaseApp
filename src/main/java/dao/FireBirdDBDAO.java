package dao;

import config.MainConfig;
import entities.BaseEntity;
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

    private Connection connection;
    private Statement statement;
    private static final Logger logger = Logger.getLogger(FireBirdDBDAO.class);

    public FireBirdDBDAO() {

        try {
            Class.forName(MainConfig.getProperty("url")).getDeclaredConstructor().newInstance();

        } catch (InstantiationException e) {
            logger.error("Error инициализации driver" + e.toString());
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

    public Connection getConnection() throws SQLException, IOException {

        String url = MainConfig.getProperty("url");
        System.out.println(url);
        String username = MainConfig.getProperty("username");
        String password = MainConfig.getProperty("password");
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public Long addEntity(BaseEntity entity) throws DaoException {
        return null;
    }

    @Override
    public void updateEntity(BaseEntity entity) throws DaoException {

    }

    @Override
    public void deleteEntity(Long entityId) throws DaoException {

    }

    @Override
    public BaseEntity getEntity(Long entityId) throws DaoException {
        return null;
    }

    @Override
    public List<BaseEntity> findEntity(String surname) throws DaoException {

        List<BaseEntity> baseEntityList = null;
        ResultSet resultSet = null;

        ParamRequest paramRequest = new ParamRequest(2);

        try {
            resultSet = doRequest(paramRequest);

            baseEntityList = new ArrayList<>();

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

                baseEntityList.add(employee);

                employee.toString();
            }

        } catch (SQLException throwables) {
            logger.error("Ошибка SQL запроса"+ throwables.toString());
            throw new DaoException(throwables.toString());
        }

        return baseEntityList;
    }

    private ResultSet doRequest(ParamRequest parameters) throws SQLException {

        String whereSQL = ";";

        if (parameters.getID() != null) {
            whereSQL = String.format("WHERE e.id = %d order by e.id;", parameters.getID());
        }
        if (parameters.getSurname() != null && parameters.getFirstName() != null) {
            whereSQL = String.format("WHERE e.surname like '%%%s%%' and e.fname like '%%%s%%'   order by e.surname;", parameters.getSurname(), parameters.getFirstName());
        }
        if (parameters.getSurname() != null) {

            whereSQL = String.format("WHERE e.surname like '%%%s%%' order by e.surname;", parameters.getSurname());
        }
        ResultSet resultSet = null;
        resultSet = statement.executeQuery
                ("SELECT * from employee e " +
                        "join departments d on e.departament_id = d.id " +
                        "join departnames n on d.departnameid = n.id " +
                        "join positions p on e.position_id = p.id " + whereSQL);

        return resultSet;
    }
}
