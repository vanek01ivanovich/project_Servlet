package ua.training.model.dao.entity;

import java.util.ArrayList;
import java.util.List;

public class User {


    private int id;

    private String firstName;
    private String firstNameUkr;
    private String lastName;
    private String lastNameUkr;
    private String role;
    private String password;
    private String userName;

    private List<DestinationProperty> destinationProperties = new ArrayList<>();
    private List<Train> trains = new ArrayList<>();

    public List<Train> getTrains(){
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }


    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<DestinationProperty> getDestinationProperties() {
        return destinationProperties;
    }

    public void setDestinationProperties(List<DestinationProperty> destinationProperties) {
        this.destinationProperties = destinationProperties;
    }



    public String getFirstNameUkr() {
        return firstNameUkr;
    }

    public void setFirstNameUkr(String firstNameUkr) {
        this.firstNameUkr = firstNameUkr;
    }

    public String getLastNameUkr() {
        return lastNameUkr;
    }

    public void setLastNameUkr(String lastNameUkr) {
        this.lastNameUkr = lastNameUkr;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", firstNameUkr='" + firstNameUkr + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lastNameUkr='" + lastNameUkr + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", destinationProperties=" + destinationProperties +
                ", trains=" + trains +
                '}';
    }
}
