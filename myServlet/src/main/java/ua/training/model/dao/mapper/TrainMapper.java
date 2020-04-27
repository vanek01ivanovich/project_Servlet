package ua.training.model.dao.mapper;

import ua.training.model.dao.entity.Train;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class TrainMapper implements ObjectMapper<Train> {
    @Override
    public Train extractFromResultSet(ResultSet resultSet) throws SQLException {
        Train train = new Train();
        train.setIdTrain(resultSet.getInt("idtrain"));
        train.setTrainName(resultSet.getString("train_name"));
        return train;
    }

    @Override
    public void putValuesToMap(Map<Integer, Train> entity, Train train) {
        entity.putIfAbsent(train.getIdTrain(),train);

    }
}
