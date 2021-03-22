package dao;


import entities.Department;
import entities.Employee;
import entities.Position;
import exception.DaoException;

import java.sql.SQLException;
import java.util.List;

/**
 * Интерфейс для определения функций c таблицами
 */
public interface ActionDAO {
    // Добавление  - возвращает ID
    int addEntity(Employee employee) throws DaoException, SQLException;

    // Редактирование
    void updateEntity(Employee employee) throws DaoException;

    // Удаление  по его ID
    void deleteEntity(int employeeId) throws DaoException;

    // Получение 1
    Employee getEntity(int employeeId) throws DaoException;

    // Получение списка
    List<Employee> findEntity(ParamRequest paramRequest) throws DaoException;

    // Получение списка департаментов
    List<Department> getDepartment(Integer ID) throws DaoException;

    // Получение списка должностей
    List<Position> getPosition(Integer ID) throws DaoException;

}
