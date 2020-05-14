package ua.training.model.dao.implement;

import ua.training.controller.security.BcryptEncoder;
import ua.training.model.dao.UserDao;
import ua.training.model.dao.entity.User;
import ua.training.model.dao.entity.enums.RoleStatus;
import ua.training.model.dao.mapper.UserMapper;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCUserDao implements UserDao {
    private Connection connection;
    private UserMapper userMapper;
    private BcryptEncoder encoder = new BcryptEncoder();



    private final String sqlDeleteUser = "delete from users where users.idusers=?";
    private final String sqlSelectAllUsers = "select * from users";
    private final String sqlUpdateUser = "update users set users.user_name=?," +
                                        "users.first_name=?,users.last_name=?,users.role=? " +
                                        "where users.idusers=?";

    JDBCUserDao(Connection connection) {
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


            userMapper = new UserMapper();
            if(resultSet.next()){
                user = userMapper.extractFromResultSet(resultSet);

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
        String insertSqlRequest = "insert into users(first_name,last_name,first_name_ukr,last_name_ukr,users.role,users.password,user_name)" +
                "values(?,?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement =
                connection.prepareStatement(insertSqlRequest)){
                //preparedStatement.setInt(1,3);
                preparedStatement.setString(1,request.getParameter("firstName"));
                preparedStatement.setString(2,request.getParameter("lastName"));
                preparedStatement.setString(3,request.getParameter("ukrFirstName"));
                preparedStatement.setString(4,request.getParameter("ukrLastName"));
                preparedStatement.setString(5, RoleStatus.ROLE_USER.toString());
                preparedStatement.setString(6, encoder.hashPassword(request.getParameter("password")));
                preparedStatement.setString(7,request.getParameter("userName"));
                preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void create(User entity) {

    }

    @Override
    public List<User> findAll() {
        List<User> listUserr = new ArrayList<>();
        try(PreparedStatement preparedStatement =
                connection.prepareStatement(sqlSelectAllUsers)){
            ResultSet resultSet = preparedStatement.executeQuery();

            userMapper = new UserMapper();

            while(resultSet.next()){
                User user = new User();
                user = userMapper.extractFromResultSet(resultSet);
                listUserr.add(user);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return listUserr;
    }

    @Override
    public void update(User newUser) {
        try(PreparedStatement preparedStatement =
                connection.prepareStatement(sqlUpdateUser)){
            preparedStatement.setString(1,newUser.getUserName());
            preparedStatement.setString(2,newUser.getFirstName());
            preparedStatement.setString(3,newUser.getLastName());
            preparedStatement.setString(4,newUser.getRole());
            preparedStatement.setInt(5,newUser.getId());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
        try(PreparedStatement preparedStatement =
                connection.prepareStatement(sqlDeleteUser)){
            preparedStatement.setInt(1,user.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
