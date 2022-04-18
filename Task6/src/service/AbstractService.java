package service;

import dao.entity.AbstractEntity;

import java.io.File;
import java.util.List;

public interface AbstractService<T extends AbstractEntity> {
    T getById(long id);

    List<T> getAll();

    public void create(T entity);

    public void deleteById(long id);

    public void updateById(long id, T entity);

    public File getFile();

    public void setFile(File file);
}
