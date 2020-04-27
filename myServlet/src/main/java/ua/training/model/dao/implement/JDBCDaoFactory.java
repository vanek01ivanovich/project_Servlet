package ua.training.model.dao.implement;

import ua.training.model.dao.ApplicationDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.DestinationPropertyDao;
import ua.training.model.dao.UserDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {
    @Override
    public UserDao createUserDao() {
        return new JDBCUserDao(getConnection());
    }

    @Override
    public DestinationPropertyDao createDestinationDao() {
        return new JDBCDestinationPropertyPropertyDao(getConnection());
    }

    @Override
    public ApplicationDao createApplicationDao() {
        return new JDBCApplicationDao(getConnection());
    }


    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    private Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
