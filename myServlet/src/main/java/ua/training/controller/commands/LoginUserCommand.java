package ua.training.controller.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginUserCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        if (userName == null || password == null){
            return "WEB-INF/view/login.jsp";
        }
        return "WEB-INF/view/login.jsp";

    }
}
