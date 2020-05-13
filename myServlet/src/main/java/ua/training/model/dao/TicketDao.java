package ua.training.model.dao;

import ua.training.model.dao.entity.Ticket;
import ua.training.model.dao.entity.User;

import java.util.List;

public interface TicketDao extends GenericDao<Ticket> {
    List<User> findAllUsersAndTickets();
}
