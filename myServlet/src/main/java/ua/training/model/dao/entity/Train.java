package ua.training.model.dao.entity;

import sun.security.krb5.internal.crypto.Des;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private int idTrain;
    private String trainName;
    //private List<Destination> destinations= new ArrayList<>();

    public int getIdTrain() {
        return idTrain;
    }

    public void setIdTrain(int idTrain) {
        this.idTrain = idTrain;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

   /* public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }
*/
    @Override
    public String toString() {
        return "Train{" +
                "idTrain=" + idTrain +
                ", trainName='" + trainName + '\'' +
               // ", destinations=" + destinations +
                '}';
    }
}
