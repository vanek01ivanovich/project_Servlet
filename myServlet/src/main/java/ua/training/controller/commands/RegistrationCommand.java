package ua.training.controller.commands;

import ua.training.controller.constants.PageConstants;
import ua.training.model.dao.entity.User;
import ua.training.model.service.UserService;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegistrationCommand implements Command {

    private UserService userService;

    public RegistrationCommand(UserService userService){
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        String userName = request.getParameter("userName");

        if (request.getMethod().equalsIgnoreCase("post")) {

            if ((userService.isExistUser(userName))) {
                request.setAttribute("alert", 0);
                return "WEB-INF/view/registration.jsp";
            } else if (request.getAttribute("regexFalseOrTrue").equals("false")) {
                request.setAttribute("alert", 1);
                return "WEB-INF/view/registration.jsp";
            } else {
                userService.saveNewUser(request);
                request.setAttribute("redirect", "/login");
                return null;
            }

        }else {
            return "WEB-INF/view/registration.jsp";
        }
    }
}
