package ua.training.controller.security;

import org.apache.log4j.Logger;
import ua.training.model.dao.entity.User;

import javax.servlet.http.HttpSession;

public class UserSessionSecurity {
    private BcryptEncoder encoder = new BcryptEncoder();
    private static final Logger log = Logger.getLogger(UserSessionSecurity.class);

    public void removeUserSession(HttpSession session){
        session.invalidate();
    }

    public static void addLoggedUser(HttpSession session, User user){
        session.setAttribute("login", true);
        session.setAttribute("user", user);
        log.info("USER " + user.getUserName() + " has logged successfully!");
    }

    public boolean checkPassword(User user,String password){
        return encoder.checkPass(password, user.getPassword());
    }
}
