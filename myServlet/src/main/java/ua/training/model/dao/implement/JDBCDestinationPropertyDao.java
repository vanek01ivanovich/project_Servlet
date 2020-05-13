package ua.training.model.dao.implement;

import ua.training.model.dao.DestinationPropertyDao;
import ua.training.model.dao.entity.Application;
import ua.training.model.dao.entity.DestinationProperty;
import ua.training.model.dao.entity.Destinations;
import ua.training.model.dao.entity.Train;
import ua.training.model.dao.mapper.PropertyMapper;
import ua.training.model.dao.mapper.DestinationsMapper;
import ua.training.model.dao.mapper.TrainMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class JDBCDestinationPropertyDao implements DestinationPropertyDao {
    private Connection connection;
    private PropertyMapper propertyMapper;
    private DestinationsMapper destinationsMapper;
    private TrainMapper trainMapper;
    JDBCDestinationPropertyDao(Connection connection){this.connection = connection;}

    @Override
    public void create(DestinationProperty entity) {

    }

    @Override
    public List<DestinationProperty> findAll() {
        return null;
    }

    @Override
    public void update(DestinationProperty entity) {

    }


    final String sqlFindByStationsAndDate = "SELECT  destinations.*,property.*,train.* " +
            "FROM myrailwaydb.property join destinations on property.destinations_iddestinations = destinations.iddestinations " +
            "join train on property.train_idtrain = train.idtrain where departure = ? and " +
            "arrival = ? and date_departure = ?";

    final String sqlFindByUkrainianStationsAndDate = "SELECT  destinations.*,property.*,train.* " +
            "FROM myrailwaydb.property join destinations on property.destinations_iddestinations = destinations.iddestinations " +
            "join train on property.train_idtrain = train.idtrain where departureUA = ? and " +
            "arrivalUA = ? and date_departure = ?";

    @Override
    public List<DestinationProperty> findAllByApplication(Application application) {
        System.out.println("Dd");
        Map<Integer, DestinationProperty> destinationMap = new HashMap<>();
        Map<Integer,Train> trainMap = new HashMap<>();

        try (PreparedStatement preparedStatement =
                connection.prepareStatement(sqlFindByStationsAndDate)){
            preparedStatement.setString(1,application.getDeparture());
            preparedStatement.setString(2,application.getArrival());
            preparedStatement.setString(3,application.getDateDeparture());

            ResultSet resultSet = preparedStatement.executeQuery();

            propertyMapper = new PropertyMapper();
            destinationsMapper = new DestinationsMapper();
            trainMapper = new TrainMapper();

            while (resultSet.next()){
                DestinationProperty destinationProperty = propertyMapper.extractFromResultSet(resultSet);
                Destinations destination = destinationsMapper.extractFromResultSet(resultSet);
                Train train = trainMapper.extractFromResultSet(resultSet);

                destinationProperty.getDestinations().add(destination);
                destinationProperty.getTrains().add(train);

                propertyMapper.putValuesToMap(destinationMap,destinationProperty);

            }
            return new ArrayList<>(destinationMap.values());
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<DestinationProperty> findAllByUkrainianApplication(Application application) {
        System.out.println("DEP UA = " + application.getDepartureUA());
        Map<Integer, DestinationProperty> destinationMap = new HashMap<>();
        try (PreparedStatement preparedStatement =
                connection.prepareStatement(sqlFindByUkrainianStationsAndDate)){
            preparedStatement.setString(1,application.getDepartureUA());
            preparedStatement.setString(2,application.getArrivalUA());
            preparedStatement.setString(3,application.getDateDeparture());

            ResultSet resultSet = preparedStatement.executeQuery();
            propertyMapper = new PropertyMapper();

            while (resultSet.next()){
                DestinationProperty destinationProperty = propertyMapper.extractFromResultSet(resultSet);
                System.out.println(destinationProperty.toString());
                propertyMapper.putValuesToMap(destinationMap,destinationProperty);
                System.out.println(destinationMap.values());
            }
            return new ArrayList<>(destinationMap.values());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
