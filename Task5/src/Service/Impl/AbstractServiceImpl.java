package Service.Impl;

import Dao.AbstractDao;
import Dao.Entity.AbstractEntity;
import Service.AbstractService;

import java.util.List;

public abstract class AbstractServiceImpl<T extends AbstractEntity, D extends AbstractDao<T>> implements AbstractService<T> {
    private D defaultDao;

    public AbstractServiceImpl(D defaultDao) {

        this.defaultDao = defaultDao;
    }

    @Override
    public T getById(long id) {

        return defaultDao.getById(id);
    }

    @Override
    public List<T> getAll() {
        return defaultDao.getAll();
    }

    @Override
    public void create(T entity) {

        defaultDao.create(entity);
    }

    @Override
    public void deleteById(long id) {

        defaultDao.deleteById(id);
    }

    @Override
    public void updateById(long id, T entity) {

        defaultDao.updateById(id, entity);
    }
}
