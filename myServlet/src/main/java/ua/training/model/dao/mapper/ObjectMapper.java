package ua.training.model.dao.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public interface ObjectMapper<T> {
    T extractFromResultSet(ResultSet resultSet) throws SQLException;
    void putValuesToMap(Map<Integer,T> emptyEntity,T entity);
}
