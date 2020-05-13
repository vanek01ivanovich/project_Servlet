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

    public TicketCommand(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();

        System.out.println("im here = " + request.getMethod());

        if (!request.getMethod().equalsIgnoreCase("post")) {
            List<DestinationProperty> ticket = (List<DestinationProperty>) session.getAttribute("listRoutes");

            DestinationProperty destinationProperty = ticketService.getCurrentTicket(ticket, Integer.parseInt(request.getParameter("idProperty")));

            request.setAttribute("ticket", destinationProperty);
            return "WEB-INF/view/ticket.jsp";
        }else{
            ticketService.addTicket(session,request);
            request.setAttribute("redirect","/findroute");
            return null;
        }

    }
}
