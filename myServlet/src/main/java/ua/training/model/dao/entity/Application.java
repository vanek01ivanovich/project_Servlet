package ua.training.model.dao.entity;

public class Application {
    private int idApplication;
    private int idUser;
    private String departure;
    private String departureUA;
    private String arrival;
    private String arrivalUA;
    private String dateDeparture;

    public int getIdApplication() {
        return idApplication;
    }

    public void setIdApplication(int idApplication) {
        this.idApplication = idApplication;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDateDeparture() {
        return dateDeparture;
    }

    public void setDateDeparture(String dateDeparture) {
        this.dateDeparture = dateDeparture;
    }

    public String getDepartureUA() {
        return departureUA;
    }

    public void setDepartureUA(String departureUA) {
        this.departureUA = departureUA;
    }

    public String getArrivalUA() {
        return arrivalUA;
    }

    public void setArrivalUA(String arrivalUA) {
        this.arrivalUA = arrivalUA;
    }
}
