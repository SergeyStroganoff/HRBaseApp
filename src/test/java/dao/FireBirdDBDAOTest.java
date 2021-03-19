package dao;

import config.MainConfig;
import entities.Department;
import entities.Employee;
import entities.Position;
import exception.DaoException;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class FireBirdDBDAOTest {

    private static final Logger logger = Logger.getLogger(FireBirdDBDAO.class);
    FireBirdDBDAO fireBirdDBDAO;

    @Before
    public void setUp() {

        try {
            MainConfig.initConfig();
        } catch (IOException e) {
            logger.error("Зафиксирована ошибка инициализации параметров конфигурации -" +
                    "проверьте содержание и расположение файла конфигурации", e);
        }
        fireBirdDBDAO = new FireBirdDBDAO();
    }


    @Test
    public void testFindEntity() {

        ParamRequest paramRequest = new ParamRequest(2);
        List<Employee> employeesList = null;
        try {
            employeesList = fireBirdDBDAO.findEntity(paramRequest);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(employeesList);
        Assert.assertEquals("Родионов",employeesList.get(0).getSurname());

    }

    @Test
    public void addEntityTest() {
        int result = 0;
        Employee employee = createRandomEmployee();

        try {
            result = fireBirdDBDAO.addEntity(employee);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        Assert.assertNotEquals(0, result);

    }

    @Test
    public void updateEntity() {

        List<Employee> employeesList = null;
        int returnedID = 0;
        Employee employee = createRandomEmployee();

        try {
            returnedID = fireBirdDBDAO.addEntity(employee);

            logger.debug(returnedID);
            employee.setSurname("TestFamily");
            fireBirdDBDAO.updateEntity(employee);

            ParamRequest paramRequest = new ParamRequest("TestFamily");
            logger.debug(employee.getID());
            employeesList = fireBirdDBDAO.findEntity(paramRequest);

         //   fireBirdDBDAO.deleteEntity(employee.getID());

        } catch (DaoException e) {
            e.printStackTrace();
        }

        assert employeesList != null;
        Assert.assertEquals("TestFamily", employeesList.get(0).getSurname());

    }

    @Test
    public void deleteEntity() {

        int returnedID = 0;
        List<Employee> employeesList = null;
        Employee employee = createRandomEmployee();

        try {
            returnedID = fireBirdDBDAO.addEntity(employee);
            fireBirdDBDAO.deleteEntity(returnedID);

            ParamRequest paramRequest = new ParamRequest(returnedID);
            employeesList = fireBirdDBDAO.findEntity(paramRequest);

        } catch (DaoException e) {
            e.printStackTrace();
        }
        assert employeesList != null;
        Assert.assertEquals(0, employeesList.size());
    }

    private Employee createRandomEmployee() {
        Random random = new Random();
        Position position = new Position(5, "Специалист", 45000f);
        Department department = new Department(4, "Отдел разработки и проектирования", 3, "mail@mail.ru", "556678");
        return new Employee(0, "Сергеев", "Даниил", "Аркадьевич", LocalDate.of(getRandomNumber(1920,2005), getRandomNumber(1,13), getRandomNumber(1,28)), position, department, true);
    }

    private int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }



}