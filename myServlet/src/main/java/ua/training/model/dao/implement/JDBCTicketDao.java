package ua.training.model.dao.implement;

import ua.training.model.dao.TicketDao;
import ua.training.model.dao.entity.DestinationProperty;
import ua.training.model.dao.entity.Ticket;
import ua.training.model.dao.entity.Train;
import ua.training.model.dao.entity.User;
import ua.training.model.dao.mapper.PropertyMapper;
import ua.training.model.dao.mapper.TrainMapper;
import ua.training.model.dao.mapper.UserMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCTicketDao implements TicketDao {
    private Connection connection;
    private UserMapper userMapper;
    private PropertyMapper propertyMapper;
    private TrainMapper trainMapper;

    private final String sqlInsertTicket = "insert into ticket(users_idusers,property_idproperty) " +
                                                "values(?,?)";

    private final String sqlSelectUsersAndTickets = "SELECT users.*,destinations.*, property.*,train.* from ticket join users on " +
            "ticket.users_idusers = users.idusers join property on ticket.property_idproperty = property.idproperty join destinations " +
            "on  property.destinations_iddestinations = destinations.iddestinations " +
            "join train on property.train_idtrain = train.idtrain";


    JDBCTicketDao(Connection connection){this.connection = connection;}



    @Override
    public void create(Ticket ticket) {
        try (PreparedStatement preparedStatement =
                connection.prepareStatement(sqlInsertTicket)){

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
    public List<User> findAllUsersAndTickets() {
        List<User> userAndTicketsList = new ArrayList<>();
        try(PreparedStatement preparedStatement =
                connection.prepareStatement(sqlSelectUsersAndTickets)){
            ResultSet resultSet = preparedStatement.executeQuery();

            userMapper = new UserMapper();
            propertyMapper = new PropertyMapper();
            trainMapper = new TrainMapper();

            while(resultSet.next()){
                User user = userMapper.extractFromResultSet(resultSet);
                DestinationProperty destinationProperty = propertyMapper.extractFromResultSet(resultSet);
                Train train = trainMapper.extractFromResultSet(resultSet);


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
