package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.UserDao;

import javax.servlet.http.HttpServletRequest;

public class UserService {

    private DaoFactory factory = DaoFactory.getInstance();
    private UserDao userDao = factory.createUserDao();

    public boolean isExistUser(String userName){
        return userDao.isExistUser(userName);
    }
    public void saveNewUser(HttpServletRequest userRequest){
        userDao.saveNewUser(userRequest);
    }

}
