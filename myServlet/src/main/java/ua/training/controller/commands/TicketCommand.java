package ua.training.controller.commands;

import ua.training.controller.constants.PageConstants;
import ua.training.model.dao.entity.DestinationProperty;
import ua.training.model.dao.entity.Ticket;
import ua.training.model.dao.entity.User;
import ua.training.model.service.TicketService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class TicketCommand implements Command {
    private TicketService ticketService;
    private Ticket ticket = new Ticket();
    private static String idProperty;

    public TicketCommand(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (!request.getMethod().equalsIgnoreCase("post")) {

            List<DestinationProperty> ticket = (List<DestinationProperty>) session.getAttribute("listRoutes");


            if (request.getParameter("idProperty") != null){
                idProperty = request.getParameter("idProperty");
            }

            DestinationProperty destinationProperty = ticketService.getCurrentTicket(ticket, Integer.parseInt(idProperty));
            request.setAttribute("user",user);
            request.setAttribute("ticket", destinationProperty);
            return "WEB-INF/view/ticket.jsp";
        }else{
            ticketService.addTicket(session,request);
            request.setAttribute("redirect","/findroute");
            return null;
        }

    }
}

