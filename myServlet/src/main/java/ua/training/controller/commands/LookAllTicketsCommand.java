package ua.training.controller.commands;

import ua.training.controller.constants.PageConstants;
import ua.training.model.dao.entity.User;
import ua.training.model.service.TicketService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class LookAllTicketsCommand implements Command {

    private TicketService ticketService;

    public LookAllTicketsCommand(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<User> userAndTickets = ticketService.getAllUsersTickets();
        System.out.println("FirstName = " + userAndTickets.get(0).getFirstName());
        System.out.println("destin = " + userAndTickets.get(0).getDestinationProperties());

        request.setAttribute("allTickets",userAndTickets);
        return "/WEB-INF/view/allTickets.jsp";
    }
}
