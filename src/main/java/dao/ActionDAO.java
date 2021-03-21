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
    public int addEntity(Employee employee) throws DaoException, SQLException;

    // Редактирование
    public void updateEntity(Employee employee) throws DaoException;

    // Удаление  по его ID
    public void deleteEntity(int employeeId) throws DaoException;

    // Получение 1
    public Employee getEntity(int employeeId) throws DaoException;

    // Получение списка
    public List<Employee> findEntity(ParamRequest paramRequest) throws DaoException;

    // Получение списка департаментов
    public List<Department> getDepartment(Integer ID) throws DaoException;

    // Получение списка должностей
    public List<Position> getPosition(Integer ID) throws DaoException;

}
