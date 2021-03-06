package ua.training.model.dao.implement;

import ua.training.model.dao.TicketDao;
import ua.training.model.dao.entity.*;
import ua.training.model.dao.mapper.DestinationsMapper;
import ua.training.model.dao.mapper.PropertyMapper;
import ua.training.model.dao.mapper.TrainMapper;
import ua.training.model.dao.mapper.UserMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class JDBCTicketDao implements TicketDao {
    private Connection connection;
    private UserMapper userMapper;
    private PropertyMapper propertyMapper;
    private TrainMapper trainMapper;
    private DestinationsMapper destinationsMapper;

    private ResourceBundle resourceBundle = ResourceBundle.getBundle("databaseRequest");

    private final String ADD_TICKET = "add.ticket";
    private final String FIND_USERS_AND_TICKETS = "find.users.and.tickets";



    JDBCTicketDao(Connection connection){this.connection = connection;}



    @Override
    public void create(Ticket ticket) {
        try (PreparedStatement preparedStatement =
                connection.prepareStatement(resourceBundle.getString(ADD_TICKET))){

            preparedStatement.setInt(1,ticket.getIdUser());
            preparedStatement.setInt(2,ticket.getIdDestinationProperty());
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Ticket> findAll(){
        return null;
    }

    @Override
    public void update(Ticket entity) {

    }

    @Override
    public void delete(Ticket entity) {

    }


    @Override
    public List<User> findAllUsersAndTickets() {
        List<User> userAndTicketsList = new ArrayList<>();
        try(PreparedStatement preparedStatement =
                connection.prepareStatement(resourceBundle.getString(FIND_USERS_AND_TICKETS))){
            ResultSet resultSet = preparedStatement.executeQuery();

            userMapper = new UserMapper();
            propertyMapper = new PropertyMapper();
            trainMapper = new TrainMapper();
            destinationsMapper = new DestinationsMapper();

            while(resultSet.next()){
                User user = userMapper.extractFromResultSet(resultSet);
                DestinationProperty destinationProperty = propertyMapper.extractFromResultSet(resultSet);
                Destinations destinations = destinationsMapper.extractFromResultSet(resultSet);
                Train train = trainMapper.extractFromResultSet(resultSet);

                destinationProperty.getDestinations().add(destinations);
                user.getDestinationProperties().add(destinationProperty);
                user.getTrains().add(train);
                userAndTicketsList.add(user);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return userAndTicketsList;
    }
}
