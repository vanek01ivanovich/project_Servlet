package ua.training.model.dao.mapper;

import ua.training.model.dao.entity.Train;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class TrainMapper implements ObjectMapper<Train> {
    @Override
    public Train extractFromResultSet(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public Train putValuesToMap(Map<Integer, Train> emptyEntity, Train entity) {
        return null;
    }
}
