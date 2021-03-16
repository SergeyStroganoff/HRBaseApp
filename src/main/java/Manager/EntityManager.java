package Manager;

import dao.ActionDAO;
import dao.BaseType;
import dao.DAOFactory;
import entities.BaseEntity;
import exception.ContactBusinessException;
import exception.DaoException;

import java.util.List;

public class EntityManager {

    private ActionDAO dao;

    public EntityManager() {
        dao = DAOFactory.getBaseDAO(BaseType.FIREBIRD);
    }

    // Добавление контакта - возвращает ID добавленного контакта
    public Long addEntity(BaseEntity entity) throws ContactBusinessException {
        try {
            return dao.addEntity(entity);
        } catch (DaoException ex) {
            throw new ContactBusinessException(ex);
        }
    }

    // Редактирование
    public void updateEntity(BaseEntity entity) throws ContactBusinessException {
        try {
            dao.updateEntity(entity);
        } catch (DaoException ex) {
            throw new ContactBusinessException(ex);
        }
    }

    // Удаление контакта
    public void deleteEntity(Long Id) throws ContactBusinessException {
        try {
            dao.deleteEntity(Id);
        } catch (DaoException ex) {
            throw new ContactBusinessException(ex);
        }
    }

    // Получение одного
    public BaseEntity getEntity(Long Id) throws ContactBusinessException {
        try {
            return dao.getEntity(Id);
        } catch (DaoException ex) {
            throw new ContactBusinessException(ex);
        }
    }

    // Получение списка
    public List<BaseEntity> findEntity(String surname) throws ContactBusinessException {
        try {
            return dao.findEntity(surname);
        } catch (DaoException ex) {
            throw new ContactBusinessException(ex);
        }
    }
}
