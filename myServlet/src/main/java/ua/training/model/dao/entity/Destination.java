package ua.training.model.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Destination {
    private int idDestination;
    private String stationDeparture;
    private String stationArrival;
    private String timeDeparture;
    private String timeArrival;
    private Date dateDepartureFormInput;
    private String dateDeparture;
    private String dateArrival;
    private int price;
    private List<Train> trains = new ArrayList<>();


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

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }
}
