package dao.impl;

import dao.AbstractDao;
import dao.entity.AbstractEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDaoImpl<T extends AbstractEntity> implements AbstractDao<T>, Cloneable {
    protected List<T> repository = new ArrayList<T>();

    public abstract void giveId(T entity);

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
        giveId(entity);
        repository.add(entity);
    }

    public void addAll(List<T> newRepository) {
        repository = new ArrayList<>();
        for (int i = 0; i < newRepository.size(); i++) {
            repository.add(newRepository.get(i));
        }

    }

    @Override
    public void deleteById(long id) {
        T entity = getById(id);
        repository.remove(entity);
    }

}
