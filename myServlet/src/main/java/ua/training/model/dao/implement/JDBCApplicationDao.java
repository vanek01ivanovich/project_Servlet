package ua.training.model.dao.implement;

import ua.training.App;
import ua.training.model.dao.ApplicationDao;
import ua.training.model.dao.entity.Application;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JDBCApplicationDao implements ApplicationDao {

    final String sqlInsertApplication = "insert into applications(users_idusers," +
            "departure,arrival,date_departure) values(?,?,?,?)";

    private final String sqlInsertUkrainianApplication = "insert into applications(users_idusers," +
            "departureUA,arrivalUA,date_departure) values(?,?,?,?)";

    /*final String sqlExtractFromDestination = "select * from destinations " +
                                             "where destinations.departure = ? and " +
                                             "destination.arrival = ? and " +
                                             "destination.date_departure = ?";*/
    private Connection connection;

    public JDBCApplicationDao(Connection connection){this.connection = connection;}

    @Override
    public void create(Application entity) {

    }

    @Override
    public List<Application> findAll() {
        return null;
    }

    @Override
    public void update(Application entity) {

    }

    @Override
    public void delete(Application entity) {

    }

    @Override
    public Application addApplication(Application application) {

        try(PreparedStatement preparedStatement =
                connection.prepareStatement(sqlInsertApplication)){
                preparedStatement.setInt(1,application.getIdUser());
                preparedStatement.setString(2,application.getDeparture());
                preparedStatement.setString(3,application.getArrival());
                preparedStatement.setString(4,application.getDateDeparture());
                preparedStatement.executeUpdate();

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return application;
    }

    @Override
    public Application addUkrainianApplication(Application application) {
        try (PreparedStatement preparedStatement =
                connection.prepareStatement(sqlInsertUkrainianApplication)){
                preparedStatement.setInt(1,application.getIdUser());
                preparedStatement.setString(2,application.getDepartureUA());
                preparedStatement.setString(3,application.getArrivalUA());
                preparedStatement.setString(4,application.getDateDeparture());
                preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return application;
    }


}
