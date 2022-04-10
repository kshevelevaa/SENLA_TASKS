package Dao.Impl;

import Dao.AbstractDao;
import Dao.Entity.AbstractEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDaoImpl<T extends AbstractEntity> implements AbstractDao<T> {
    protected List<T> repository = new ArrayList<T>();

    @Override
    public T getById(long id) {
        for (T entity : repository) {
            if (entity.getId() == id)
                return entity;
        }
        return null;
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<T>(repository);
    }

    @Override
    public void create(T entity) {

        repository.add(entity);
    }

    @Override
    public void deleteById(long id) {
        T entity = getById(id);
        repository.remove(entity);
    }

}
