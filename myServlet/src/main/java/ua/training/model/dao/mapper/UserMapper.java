package ua.training.model.dao.mapper;

import ua.training.model.dao.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UserMapper implements ObjectMapper<User> {
    @Override
    public User extractFromResultSet(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public void putValuesToMap(Map<Integer, User> emptyEntity, User entity) {

    }
}
