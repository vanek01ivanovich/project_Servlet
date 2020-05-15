package ua.training.controller.security;

import ua.training.model.dao.entity.User;

import javax.servlet.http.HttpSession;

public class UserSessionSecurity {
    private BcryptEncoder encoder = new BcryptEncoder();

    public static void removeUserSession(HttpSession session){
        session.invalidate();
    }

    public static void addLoggedUser(HttpSession session, User user){
        session.setAttribute("login", true);
        session.setAttribute("user", user);
    }

    public boolean checkPassword(User user,String password){
        return encoder.checkPass(password, user.getPassword());
    }
}
