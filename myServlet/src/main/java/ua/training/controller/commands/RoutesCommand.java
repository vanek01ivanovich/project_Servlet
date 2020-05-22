package ua.training.controller.commands;

import ua.training.controller.constants.PageConstants;
import ua.training.model.dao.entity.DestinationProperty;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class RoutesCommand implements Command {

    private static int numberOfTickets = 3;
    private static int start;
    private static int end=3;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)  {

        HttpSession session = request.getSession();
        List<?> routes = (List<?>) session.getAttribute("listRoutes");

        int pages = routes.size() / numberOfTickets;
        if (routes.size() % numberOfTickets != 0){
            pages++;
        }

        if (request.getParameter("page") != null){
            start = numberOfTickets*(Integer.parseInt(request.getParameter("page"))-1);
            end = pages == Integer.parseInt(request.getParameter("page")) ? routes.size() : start+numberOfTickets;
        }

        //request.setAttribute("currentPage",Integer.parseInt(request.getParameter("page")));
        request.setAttribute("lengthPagination", pages);
        request.setAttribute("listRoutes", routes.subList(start,end));
        return "WEB-INF/view/routes.jsp";

    }
}
