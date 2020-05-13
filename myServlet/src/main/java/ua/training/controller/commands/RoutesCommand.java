package ua.training.controller.commands;

import ua.training.controller.constants.PageConstants;
import ua.training.model.dao.entity.DestinationProperty;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class RoutesCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){

        HttpSession session = request.getSession();
        List<?> routes = (List<?>) session.getAttribute("listRoutes");
        request.setAttribute("listRoutes",routes);
        return "WEB-INF/view/routes.jsp";
    }
}
