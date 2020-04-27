package ua.training.model.dao.mapper;

import ua.training.model.dao.entity.Application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ApplicationMapper implements ObjectMapper<Application> {
    @Override
    public Application extractFromResultSet(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public void putValuesToMap(Map<Integer, Application> emptyEntity, Application entity) {

    }
}
