package ua.training.model.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DestinationProperty {
    private int idDestination;
    private int idProperty;
    private int idTrain;
    private String stationDeparture;
    private String stationDepartureUA;
    private String stationArrival;
    private String stationArrivalUA;
    private String timeDeparture;
    private String timeArrival;
    private Date dateDepartureFormInput;
    private String dateDeparture;
    private String dateArrival;
    private int price;
    private List<Train> users = new ArrayList<>();


    public int getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(int idDestination) {
        this.idDestination = idDestination;
    }

    public String getStationDeparture() {
        return stationDeparture;
    }

    public void setStationDeparture(String stationDeparture) {
        this.stationDeparture = stationDeparture;
    }

    public String getStationArrival() {
        return stationArrival;
    }

    public void setStationArrival(String stationArrival) {
        this.stationArrival = stationArrival;
    }

    public String getTimeDeparture() {
        return timeDeparture;
    }

    public void setTimeDeparture(String timeDeparture) {
        this.timeDeparture = timeDeparture;
    }

    public String getTimeArrival() {
        return timeArrival;
    }

    public void setTimeArrival(String timeArrival) {
        this.timeArrival = timeArrival;
    }

    public Date getDateDepartureFormInput() {
        return dateDepartureFormInput;
    }

    public void setDateDepartureFormInput(Date dateDepartureFormInput) {
        this.dateDepartureFormInput = dateDepartureFormInput;
    }

    public String getDateDeparture() {
        return dateDeparture;
    }

    public void setDateDeparture(String dateDeparture) {
        this.dateDeparture = dateDeparture;
    }

    public String getDateArrival() {
        return dateArrival;
    }

    public void setDateArrival(String dateArrival) {
        this.dateArrival = dateArrival;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Train> getUsers() {
        return users;
    }

    public void setUsers(List<Train> users) {
        this.users = users;
    }



    public int getIdProperty() {
        return idProperty;
    }

    public void setIdProperty(int idProperty) {
        this.idProperty = idProperty;
    }

    public int getIdTrain() {
        return idTrain;
    }

    public void setIdTrain(int idTrain) {
        this.idTrain = idTrain;
    }

    @Override
    public String toString() {
        return "DestinationProperty{" +
                "idDestination=" + idDestination +
                ", idProperty=" + idProperty +
                ", idTrain=" + idTrain +
                ", stationDeparture='" + stationDeparture + '\'' +
                ", stationArrival='" + stationArrival + '\'' +
                ", timeDeparture='" + timeDeparture + '\'' +
                ", timeArrival='" + timeArrival + '\'' +
                ", dateDepartureFormInput=" + dateDepartureFormInput +
                ", dateDeparture='" + dateDeparture + '\'' +
                ", dateArrival='" + dateArrival + '\'' +
                ", price=" + price +
                ", users=" + users +
                '}';
    }

    public String getStationDepartureUA() {
        return stationDepartureUA;
    }

    public void setStationDepartureUA(String stationDepartureUA) {
        this.stationDepartureUA = stationDepartureUA;
    }

    public String getStationArrivalUA() {
        return stationArrivalUA;
    }

    public void setStationArrivalUA(String stationArrivaUAl) {
        this.stationArrivalUA = stationArrivaUAl;
    }
}
