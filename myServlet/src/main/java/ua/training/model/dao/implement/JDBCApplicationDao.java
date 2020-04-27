package ua.training.model.dao.implement;

import ua.training.App;
import ua.training.model.dao.ApplicationDao;
import ua.training.model.dao.entity.Application;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class JDBCApplicationDao implements ApplicationDao {

    final String sqlInsertApplication = "insert into applications(users_idusers," +
            "departure,arrival,date_departure)" +
            "values(?,?,?,?)";
    final String sqlExtractFromDestination = "select * from destinations " +
                                             "where destinations.departure = ? and " +
                                             "destination.arrival = ? and " +
                                             "destination.date_departure = ?";
    private Connection connection;

    public JDBCApplicationDao(Connection connection){this.connection = connection;}

    @Override
    public Optional<Application> findAll() {
        return Optional.empty();
    }

    @Override
    public Application addApplication(int idUser,String stationFrom,String stationTo,String date) {
        Application application = new Application();
        try(PreparedStatement preparedStatement =
                connection.prepareStatement(sqlInsertApplication)){
                preparedStatement.setInt(1,idUser);
                preparedStatement.setString(2,stationFrom);
                preparedStatement.setString(3,stationTo);
                preparedStatement.setString(4,date);
                preparedStatement.executeUpdate();

                application.setArrival(stationTo);
                application.setDeparture(stationFrom);
                application.setIdUser(idUser);
                application.setDateDeparture(date);

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return application;
    }
}
