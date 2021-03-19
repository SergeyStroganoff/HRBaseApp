package dao;


import entities.BaseEntity;
import entities.Employee;
import exception.DaoException;

import java.sql.SQLException;
import java.util.List;

/**
 * Интерфейс для определения функций c таблицами
 */
public interface ActionDAO {
    // Добавление контакта - возвращает ID добавленного контакта
    public int addEntity(Employee employee) throws DaoException, SQLException;

    // Редактирование контакта
    public void updateEntity(Employee employee) throws DaoException;

    // Удаление контакта по его ID
    public void deleteEntity(int employeeId) throws DaoException;

    // Получение контакта
    public Employee getEntity(Long employeeId) throws DaoException;

    // Получение списка контактов
    public List<Employee> findEntity(ParamRequest paramRequest) throws DaoException;

}
