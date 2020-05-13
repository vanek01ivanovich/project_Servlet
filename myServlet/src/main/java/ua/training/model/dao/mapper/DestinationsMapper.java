package ua.training.model.dao.mapper;

import ua.training.model.dao.entity.Destinations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class DestinationsMapper implements ObjectMapper<Destinations> {
    @Override
    public Destinations extractFromResultSet(ResultSet resultSet) throws SQLException {
        Destinations destinations = new Destinations();
        destinations.setDeparture(resultSet.getString("departure"));
        destinations.setArrival(resultSet.getString("arrival"));
        destinations.setArrivalUA(resultSet.getString("arrivalUA"));
        destinations.setDepartureUA(resultSet.getString("departureUA"));
        destinations.setIdDestinations(resultSet.getInt("iddestinations"));
        return destinations;
    }

    @Override
    public void putValuesToMap(Map<Integer, Destinations> emptyEntity, Destinations entity) {

    }
}
