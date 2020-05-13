package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.TicketDao;
import ua.training.model.dao.entity.DestinationProperty;
import ua.training.model.dao.entity.Ticket;
import ua.training.model.dao.entity.User;
import ua.training.model.dao.implement.JDBCTicketDao;
import ua.training.model.dao.mapper.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class TicketService {
    private DaoFactory factory = DaoFactory.getInstance();
    private TicketDao ticketDao = factory.createTicketDao();
    private Ticket ticket = new Ticket();

    public DestinationProperty getCurrentTicket(List<DestinationProperty> destinationProperties,int idPoperty){
            for (DestinationProperty dest : destinationProperties) {
                if (dest.getIdProperty() == idPoperty) {
                    return dest;
                }
            }
       return null;
    }

    public void addTicket(HttpSession session, HttpServletRequest request){
        User user = (User) session.getAttribute("user");
        int idDestinationProperty = Integer.parseInt(request.getParameter("idProperty"));
        ticket.setIdUser(user.getId());
        ticket.setIdDestinationProperty(idDestinationProperty);
        ticketDao.create(ticket);
    }

    public List<User> getAllUsersTickets(){
        return ticketDao.findAllUsersAndTickets();

    }

}
