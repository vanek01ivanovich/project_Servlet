package ua.training.model.dao.mapper;

import ua.training.model.dao.entity.DestinationProperty;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class PropertyMapper implements ObjectMapper<DestinationProperty> {
    @Override
    public DestinationProperty extractFromResultSet(ResultSet resultSet) throws SQLException {
        DestinationProperty destinationProperty = new DestinationProperty();
        destinationProperty.setIdDestination(resultSet.getInt("destinations_iddestinations"));
        destinationProperty.setIdProperty(resultSet.getInt("idproperty"));
        destinationProperty.setTimeDeparture(resultSet.getString("time_departure"));
        destinationProperty.setTimeArrival(resultSet.getString("time_arrival"));
        destinationProperty.setDateDeparture(resultSet.getString("date_departure"));
        destinationProperty.setDateArrival(resultSet.getString("date_arrival"));
        destinationProperty.setPrice(resultSet.getInt("price"));
        destinationProperty.setIdTrain(resultSet.getInt("train_idtrain"));
        return destinationProperty;
    }

    @Override
    public void putValuesToMap(Map<Integer, DestinationProperty> entity, DestinationProperty destinationProperty) {
            entity.putIfAbsent(destinationProperty.getIdProperty(), destinationProperty);

    }
}
