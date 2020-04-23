package ua.training.model.dao.implement;

import ua.training.controller.security.BcryptEncoder;
import ua.training.model.dao.UserDao;
import ua.training.model.dao.entity.User;
import ua.training.model.dao.entity.enums.RoleStatus;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JDBCUserDao implements UserDao {
    private Connection connection;
    private BcryptEncoder encoder = new BcryptEncoder();
    public JDBCUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User checkLogin(String userName, String password){
        User user = null;
        try (PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT * FROM users" +
                        " WHERE user_name = ?")){
            preparedStatement.setString(1,userName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                user = new User();
                user.setUserName(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
                if (!encoder.checkPass(password,user.getPassword())){
                    return null;
                }
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public boolean isExistUser(String userName) {
        try (PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT * FROM users " +
                        "WHERE user_name = ?")){
            preparedStatement.setString(1,userName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void saveNewUser(HttpServletRequest request) {
        //String insertSqlRequest = "insert into users values(?,?,?,?,?,?)";
        String insertSqlRequest = "insert into users(first_name,last_name,users.role,users.password,user_name)" +
                "values(?,?,?,?,?)";
        try (PreparedStatement preparedStatement =
                connection.prepareStatement(insertSqlRequest)){
                //preparedStatement.setInt(1,3);
                preparedStatement.setString(1,request.getParameter("firstName"));
                preparedStatement.setString(2,request.getParameter("lastName"));
                preparedStatement.setString(3, RoleStatus.ROLE_USER.toString());
                preparedStatement.setString(4, encoder.hashPassword(request.getParameter("password")));
                preparedStatement.setString(5,request.getParameter("userName"));
                preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Optional<User> findAll() {
        return null;
    }
}
