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

import static ua.training.controller.constants.RequestConstants.*;
import static ua.training.controller.constants.PageConstants.*;
import static ua.training.controller.constants.CommandsUrlConstants.*;

public class TicketCommand implements Command {
    private TicketService ticketService;
    private static String idProperty;

    public TicketCommand(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER_ATTRIBUTE);
        if (!request.getMethod().equalsIgnoreCase(POST_METHOD)) {

            List<DestinationProperty> ticket = (List<DestinationProperty>) session.getAttribute(LIST_ROUTES_ATTRIBUTE);


            if (request.getParameter(ID_PROPERTY_PARAMETER) != null){
                idProperty = request.getParameter(ID_PROPERTY_PARAMETER);
            }

            DestinationProperty destinationProperty = ticketService.getCurrentTicket(ticket, Integer.parseInt(idProperty));
            request.setAttribute(USER_ATTRIBUTE,user);
            request.setAttribute(TICKET_ATTRIBUTE, destinationProperty);
            return TICKET_PAGE;
        }else{
            ticketService.addTicket(session,request);
            request.setAttribute(REDIRECT_ATTRIBUTE,"/findroute");
            return null;
        }

    }
}

