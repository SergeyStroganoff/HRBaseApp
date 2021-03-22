package Manager;

import dao.ActionDAO;
import dao.BaseType;
import dao.DAOFactory;
import dao.ParamRequest;
import entities.BaseEntity;
import entities.Department;
import entities.Employee;
import entities.Position;
import exception.ContactBusinessException;
import exception.DaoException;

import java.sql.SQLException;
import java.util.List;

public class ConnectionManager {

    private ActionDAO dao;

    public ConnectionManager() {
        dao = DAOFactory.getBaseDAO(BaseType.FIREBIRD);
    }

    // Добавление объекта - возвращает ID
    public int addEntity(Employee employee) throws ContactBusinessException {
        try {
            return dao.addEntity(employee);
        } catch (DaoException | SQLException ex) {
            throw new ContactBusinessException(ex);
        }
    }

    // Редактирование
    public void updateEntity(Employee employee) throws ContactBusinessException {
        try {
            dao.updateEntity(employee);
        } catch (DaoException ex) {
            throw new ContactBusinessException(ex);
        }
    }

    // Удаление сущности
    public void deleteEntity(int Id) throws ContactBusinessException {
        try {
            dao.deleteEntity(Id);
        } catch (DaoException ex) {
            throw new ContactBusinessException(ex);
        }
    }

    // Получение одного
    public BaseEntity getEntity(int Id) throws ContactBusinessException {
        try {
            return dao.getEntity(Id);
        } catch (DaoException ex) {
            throw new ContactBusinessException(ex);
        }
    }

    // Получение списка
    public List<Employee> findEntity(ParamRequest paramRequest) throws ContactBusinessException {
        try {
            return dao.findEntity(paramRequest);
        } catch (DaoException ex) {
            throw new ContactBusinessException(ex);
        }
    }

    // Получение департаментов
    public List<Department> getDepartmentList(Integer ID) throws ContactBusinessException {
        try {
            return dao.getDepartment(ID);
        } catch (DaoException ex) {
            throw new ContactBusinessException(ex);
        }
    }

    public List<Position> getPositionList(Integer ID) throws ContactBusinessException {
        try {
            return dao.getPosition(ID);
        } catch (DaoException ex) {
            throw new ContactBusinessException(ex);
        }
    }
}
