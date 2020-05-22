package ua.training.controller.commands;

import ua.training.controller.constants.PageConstants;
import ua.training.model.dao.entity.User;
import ua.training.model.service.TicketService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static ua.training.controller.constants.RequestConstants.*;
import static ua.training.controller.constants.PageConstants.*;
import static ua.training.controller.constants.CommandsUrlConstants.*;

public class LookAllTicketsCommand implements Command {

    private TicketService ticketService;

    public LookAllTicketsCommand(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<User> userAndTickets = ticketService.getAllUsersTickets();
        request.setAttribute(ALL_TICKET_ATTRIBUTE,userAndTickets);
        return ALL_TICKETS_PAGE;
    }
}
