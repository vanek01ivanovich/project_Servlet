package ua.training.controller.commands;

import ua.training.controller.constants.PageConstants;
import ua.training.controller.security.UserSessionSecurity;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.UserDao;
import ua.training.model.dao.entity.User;
import ua.training.model.dao.entity.enums.RoleStatus;
import ua.training.model.service.UserService;

import static ua.training.controller.constants.PageConstants.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.stream.Stream;

import static ua.training.controller.constants.RequestConstants.*;
import static ua.training.controller.constants.PageConstants.*;
import static ua.training.controller.constants.CommandsUrlConstants.*;


public class LoginUserCommand implements Command {
    private DaoFactory factory = DaoFactory.getInstance();
    private UserDao userDao = factory.createUserDao();
    private  UserSessionSecurity userSessionSecurity;

    public LoginUserCommand(UserSessionSecurity userSessionSecurity) {
        this.userSessionSecurity = userSessionSecurity;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter(USER_NAME_PARAMETER);
        String password = request.getParameter(PASSWORD_ATTRIBUTE);
        HttpSession session = request.getSession();

        if (!request.getMethod().equalsIgnoreCase(POST_METHOD)){
            return LOGIN_PAGE;
        }else {
            User user = userDao.checkLogin(userName);
            if (user != null && userSessionSecurity.checkPassword(user,password)){
                UserSessionSecurity.addLoggedUser(session,user);
                request.setAttribute(REDIRECT_ATTRIBUTE, user.getRole().equals(RoleStatus.ROLE_USER.toString()) ? "/user":"/admin");
                return null;
            } else {
                request.setAttribute(ERROR_LOGIN_ATTRIBUTE,true);
                return LOGIN_PAGE;
            }
        }
    }
}
