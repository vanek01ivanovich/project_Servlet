package ua.training.model.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {
    Optional<T> findAll();
}
