package ua.training.model.dao.implement;

import sun.security.krb5.internal.crypto.Des;
import ua.training.model.dao.DestinationDao;
import ua.training.model.dao.entity.Destination;
import ua.training.model.dao.entity.Train;
import ua.training.model.dao.mapper.DestinationMapper;
import ua.training.model.dao.mapper.ObjectMapper;
import ua.training.model.dao.mapper.TrainMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class JDBCDestinationDao implements DestinationDao {
    private Connection connection;
    public JDBCDestinationDao(Connection connection){this.connection = connection;}

    @Override
    public Optional<Destination> findAll() {
        return null;
    }

    @Override
    public List<Destination> findAllByStationFromAndStationToAndDateDeparture(String stationFrom,
                                                                                  String stationTo) {
        System.out.println("HEy");
        Destination destination = null;
        Train train = null;

        Map<Integer,Destination> destinationMap = new HashMap<>();
        Map<Integer,Train> trainMap = new HashMap<>();

        final String sqlFindByStationsAndDate = "SELECT * FROM destination" +
                " where departure = ? and arrival=?";
        try (PreparedStatement preparedStatement =
                connection.prepareStatement(sqlFindByStationsAndDate)){
            preparedStatement.setString(1,stationFrom);
            preparedStatement.setString(2,stationTo);
            //preparedStatement.setString(3,date);

            ResultSet resultSet = preparedStatement.executeQuery();

            DestinationMapper destinationMapper = new DestinationMapper();
            TrainMapper trainMapper = new TrainMapper();

            while (resultSet.next()){
                destination = destinationMapper.extractFromResultSet(resultSet);
                train = trainMapper.extractFromResultSet(resultSet);
                destination = destinationMapper.putValuesToMap(destinationMap,destination);
                train = trainMapper.putValuesToMap(trainMap,train);

                destination.getTrains().add(train);
            }
            return new ArrayList<>(destinationMap.values());
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
