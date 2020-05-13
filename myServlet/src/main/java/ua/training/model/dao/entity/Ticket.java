package ua.training.model.dao.entity;

public class Ticket {
    private int idTicket;
    private int idUser;
    private int idDestinationProperty;

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdDestinationProperty() {
        return idDestinationProperty;
    }

    public void setIdDestinationProperty(int idDestinationProperty) {
        this.idDestinationProperty = idDestinationProperty;
    }
}
