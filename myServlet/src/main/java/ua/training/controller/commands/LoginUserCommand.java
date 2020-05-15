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

public class LoginUserCommand implements Command {
    private DaoFactory factory = DaoFactory.getInstance();
    private UserDao userDao = factory.createUserDao();
    private UserService userService;
    private UserSessionSecurity userSessionSecurity;

    public LoginUserCommand(UserService userService, UserSessionSecurity userSessionSecurity) {
        this.userService = userService;
        this.userSessionSecurity = userSessionSecurity;
        }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        System.out.println(userName);



        if (!request.getMethod().equalsIgnoreCase("post")){
            return "WEB-INF/view/login.jsp";
        }else {

            User user = userDao.checkLogin(userName, password);
            if (user != null && userService.checkPassword(user,password)){
                UserSessionSecurity.addLoggedUser(session,user);
                if (user.getRole().equals("ROLE_USER")) {
                    //UserSessionSecurity.addLoggedUser(session,user);
                    /*session.setAttribute("login", true);
                    session.setAttribute("user", user);*/
                    request.setAttribute("redirect", "/user");
                } else {
                   /* session.setAttribute("login", true);
                    session.setAttribute("user", user);*/
                    request.setAttribute("redirect", "/admin");
                }

                return null;

            } else {
                return "WEB-INF/view/login.jsp";
            }
        }


    }
}
