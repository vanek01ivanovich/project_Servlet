package ua.training.model.dao.mapper;

import ua.training.model.dao.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UserMapper implements ObjectMapper<User> {
    @Override
    public User extractFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("idusers"));
        user.setUserName(resultSet.getString("user_name"));
        user.setPassword(resultSet.getString("password"));
        user.setRole(resultSet.getString("role"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("last_name"));
        user.setLastNameUkr(resultSet.getString("last_name_ukr"));
        user.setFirstNameUkr(resultSet.getString("first_name_ukr"));

        return user;
    }

    @Override
    public void putValuesToMap(Map<Integer, User> emptyEntity, User entity) {

    }
}
