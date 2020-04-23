package ua.training.model.dao;

import ua.training.model.dao.entity.User;

import javax.servlet.http.HttpServletRequest;

public interface UserDao extends GenericDao<User>{
    User checkLogin(String userName, String password);
    boolean isExistUser(String userName);
    void saveNewUser(HttpServletRequest request);
}
