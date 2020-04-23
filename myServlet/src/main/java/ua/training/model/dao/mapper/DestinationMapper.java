package ua.training.model.dao.mapper;

import ua.training.model.dao.entity.Destination;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class DestinationMapper implements ObjectMapper<Destination> {
    @Override
    public Destination extractFromResultSet(ResultSet resultSet) throws SQLException {
        Destination destination = new Destination();
        destination.setIdDestination(resultSet.getInt("iddestination"));
        destination.setStationArrival(resultSet.getString("arrival"));
        destination.setStationDeparture(resultSet.getString("departure"));
        destination.setTimeDeparture(resultSet.getString("time_departure"));
        destination.setTimeArrival(resultSet.getString("time_arrival"));
        destination.setDateDeparture(resultSet.getString("date_arrival"));
        destination.setDateArrival(resultSet.getString("date_arrival"));
        destination.setPrice(resultSet.getInt("price"));
        return destination;
    }

    @Override
    public Destination putValuesToMap(Map<Integer, Destination> entity, Destination destination) {
            entity.putIfAbsent(destination.getIdDestination(),destination);
        return entity.get(destination.getIdDestination());
    }
}
