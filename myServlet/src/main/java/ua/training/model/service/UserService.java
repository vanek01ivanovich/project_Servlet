package ua.training.model.service;

import ua.training.controller.security.BcryptEncoder;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.UserDao;
import ua.training.model.dao.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserService {

    private DaoFactory factory = DaoFactory.getInstance();
    private UserDao userDao = factory.createUserDao();
    private BcryptEncoder encoder = new BcryptEncoder();

    public boolean isExistUser(String userName){
        return userDao.isExistUser(userName);
    }
    public void saveNewUser(HttpServletRequest userRequest){
        userDao.saveNewUser(userRequest);
    }

    public List<User> findAllUsers(){
        return userDao.findAll();
    }

    public void updateUser(User newUser){
        userDao.update(newUser);
    }

    public void deleteUser(User user){userDao.delete(user);}

    public boolean checkPassword(User user,String password){
        return encoder.checkPass(password, user.getPassword());
    }

}
