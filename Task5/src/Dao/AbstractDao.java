package Dao;

import Dao.Entity.AbstractEntity;

import java.util.List;

public interface AbstractDao<T extends AbstractEntity> {
    T getById(long id);

    List<T> getAll();

    public void create(T entity);

    public void deleteById(long id);

    public void updateById(long id, T entity);
}
