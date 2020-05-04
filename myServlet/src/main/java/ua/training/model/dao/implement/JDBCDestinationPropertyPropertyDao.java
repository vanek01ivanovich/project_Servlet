package ua.training.model.dao.implement;

import ua.training.model.dao.DestinationPropertyDao;
import ua.training.model.dao.entity.Application;
import ua.training.model.dao.entity.DestinationProperty;
import ua.training.model.dao.entity.Train;
import ua.training.model.dao.mapper.DestinationMapper;
import ua.training.model.dao.mapper.UserMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class JDBCDestinationPropertyPropertyDao implements DestinationPropertyDao {
    private Connection connection;
    private DestinationMapper destinationMapper;
    public JDBCDestinationPropertyPropertyDao(Connection connection){this.connection = connection;}

    @Override
    public Optional<DestinationProperty> findAll() {
        return null;
    }


    final String sqlFindByStationsAndDate = "SELECT  destinations.departureUA,destinations.arrivalUA,destinations.departure,destinations.arrival,property.*,train.trainName " +
            "FROM myrailwaydb.property join destinations on property.destinations_iddestinations = destinations.iddestinations " +
            "join train on property.train_idtrain = train.idtrain where departure = ? and " +
            "arrival = ? and date_departure = ?";

    final String sqlFindByUkrainianStationsAndDate = "SELECT  destinations.departureUA,destinations.arrivalUA,destinations.departure,destinations.arrival,property.*,train.trainName " +
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

            destinationMapper = new DestinationMapper();


            while (resultSet.next()){
                DestinationProperty destinationProperty = destinationMapper.extractFromResultSet(resultSet);
                System.out.println(destinationProperty.toString());
                destinationMapper.putValuesToMap(destinationMap,destinationProperty);
                System.out.println("Im here");
                System.out.println(destinationMap.values());
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
            destinationMapper = new DestinationMapper();

            while (resultSet.next()){
                DestinationProperty destinationProperty = destinationMapper.extractFromResultSet(resultSet);
                System.out.println(destinationProperty.toString());
                destinationMapper.putValuesToMap(destinationMap,destinationProperty);
                System.out.println(destinationMap.values());
            }
            return new ArrayList<>(destinationMap.values());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
