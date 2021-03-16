package dao;

import config.MainConfig;
import entities.BaseEntity;
import entities.Department;
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
        try {
            resultSet = statement.executeQuery
                    ("SELECT * from employee e " +
                            "join departments d on e.departament_id = d.id " +
                            "join departnames n on d.departnameid = n.id " +
                            "join positions p on e.position_id = p.id " +
                            "WHERE e.surname like  '%Родионов%' and e.fname='Михаил'  order by e.surname;");

            //  ("SELECT e.id, e.surname,e.fname,e.sname,e.birthdate, p.namepos, p.salary, n.departname, d.phone, d.email, e.access_secrets " +

            baseEntityList = new ArrayList<>();
            while (resultSet.next()) {

                Position position = new Position(
                        resultSet.getInt(16),
                        resultSet.getString(17),
                        resultSet.getFloat(18));

             resultSet.getInt(2);

                Department department = new Department(resultSet.getInt(9), resultSet.getString(15),resultSet.getInt(10),resultSet.getString(11), resultSet.getString(12));


                // baseEntityList.add(new Employee(
                //         resultSet.getString("Ticker"),
                //         resultSet.getInt("Per"),
                //         resultSet.getDate("Date").toLocalDate(),
                //         resultSet.getTime("Time").toLocalTime(),
                //         resultSet.getFloat(6),
                //         resultSet.getFloat(7),
                //         resultSet.getFloat(8),
                //         resultSet.getFloat(9),
                //         resultSet.getFloat(10)));


            }

        } catch (SQLException throwables) {
            throw new DaoException(throwables.toString());
        }

        return null;
    }
}
