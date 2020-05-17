package ua.training.controller.commands;

import ua.training.controller.constants.PageConstants;
import ua.training.controller.security.UserSessionSecurity;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.UserDao;
import ua.training.model.dao.entity.User;
import ua.training.model.service.UserService;

import static ua.training.controller.constants.PageConstants.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.stream.Stream;

public class LoginUserCommand implements Command {
    private DaoFactory factory = DaoFactory.getInstance();
    private UserDao userDao = factory.createUserDao();
    private  UserSessionSecurity userSessionSecurity;

    public LoginUserCommand(UserSessionSecurity userSessionSecurity) {
        this.userSessionSecurity = userSessionSecurity;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        if (!request.getMethod().equalsIgnoreCase("post")){
            return "WEB-INF/view/login.jsp";
        }else {
            User user = userDao.checkLogin(userName);
            if (user != null && userSessionSecurity.checkPassword(user,password)){
                UserSessionSecurity.addLoggedUser(session,user);
                request.setAttribute("redirect", user.getRole().equals("ROLE_USER") ? "/user":"/admin");
                return null;
            } else {
                request.setAttribute("errorLogin",true);
                return "WEB-INF/view/login.jsp";
            }
        }
    }
}
