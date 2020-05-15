package ua.training.model.dao.mapper;

import ua.training.model.dao.entity.Ticket;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class TicketMapper implements ObjectMapper<Ticket> {
    @Override
    public Ticket extractFromResultSet(ResultSet resultSet) throws SQLException {
        Ticket ticket = new Ticket();
        return ticket;
    }

    @Override
    public void putValuesToMap(Map<Integer, Ticket> emptyEntity, Ticket entity) {

    }
}
