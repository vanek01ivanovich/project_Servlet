package ua.training.model.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {
    void create(T entity);
    List<T> findAll();
    void update(T entity);
}
