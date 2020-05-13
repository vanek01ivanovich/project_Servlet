package ua.training.model.dao.entity;

public class Destinations {
    private int idDestinations;
    private String departure;
    private String arrival;
    private String departureUA;
    private String arrivalUA;


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

    @Override
    public String toString() {
        return "Destinations{" +
                "idDestinations='" + idDestinations + '\'' +
                ", departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                ", departureUA='" + departureUA + '\'' +
                ", arrivalUA='" + arrivalUA + '\'' +
                '}';
    }

    public int getIdDestinations() {
        return idDestinations;
    }

    public void setIdDestinations(int idDestinations) {
        this.idDestinations = idDestinations;
    }
}
