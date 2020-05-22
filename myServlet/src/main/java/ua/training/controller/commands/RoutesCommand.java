package ua.training.controller.commands;

import ua.training.controller.constants.PageConstants;
import ua.training.model.dao.entity.DestinationProperty;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


import static ua.training.controller.constants.RequestConstants.*;
import static ua.training.controller.constants.PageConstants.*;
import static ua.training.controller.constants.CommandsUrlConstants.*;

public class RoutesCommand implements Command {

    private static int numberOfTickets = 3;
    private static int start;
    private static int end=3;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)  {

        HttpSession session = request.getSession();
        List<?> routes = (List<?>) session.getAttribute(LIST_ROUTES_ATTRIBUTE);

        int pages = routes.size() / numberOfTickets;
        if (routes.size() % numberOfTickets != 0){
            pages++;
        }

        if (request.getParameter(PAGE_ATTRIBUTE) != null){
            start = numberOfTickets*(Integer.parseInt(request.getParameter(PAGE_ATTRIBUTE))-1);
            end = pages == Integer.parseInt(request.getParameter(PAGE_ATTRIBUTE)) ? routes.size() : start+numberOfTickets;
        }

        //request.setAttribute("currentPage",Integer.parseInt(request.getParameter("page")));
        request.setAttribute(PAGINATION_LENGTH_ATTRIBUTE, pages);
        request.setAttribute(LIST_ROUTES_ATTRIBUTE, routes.subList(start,end));
        return ROUTES_PAGE;

    }
}
