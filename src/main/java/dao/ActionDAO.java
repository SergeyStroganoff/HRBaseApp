package dao;


import entities.BaseEntity;
import exception.DaoException;

import java.util.List;

/**
 * Интерфейс для определения функций c таблицами
 */
public interface ActionDAO {
    // Добавление контакта - возвращает ID добавленного контакта
    public Long addEntity(BaseEntity entity) throws DaoException;

    // Редактирование контакта
    public void updateEntity(BaseEntity entity) throws DaoException;

    // Удаление контакта по его ID
    public void deleteEntity(Long entityId) throws DaoException;

    // Получение контакта
    public BaseEntity getEntity(Long entityId) throws DaoException;

    // Получение списка контактов
    public List<BaseEntity> findEntity(String surname) throws DaoException;

}
