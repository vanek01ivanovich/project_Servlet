package ua.training.controller.commands;

import ua.training.controller.constants.PageConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutUserCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();

            session.removeAttribute("userName");
            session.removeAttribute("login");
            session.removeAttribute("role");
            session.removeAttribute("iduser");
            return "WEB-INF/view/login.jsp";

    }
}
