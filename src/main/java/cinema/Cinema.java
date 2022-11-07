package src.main.java.cinema;

import src.main.java.enums.*;

public class Cinema{
 
    //attributes
    private String cinemaID;
    private String cineplexName;
    private int numberOfSeats;
    private ClassOfCinema classOfCinema;
    private Layout layout;

    //constructor
    public Cinema(String cinemaID, String cineplexName, int numberOfSeats, ClassOfCinema classOfCinema, Layout layout) {
        this.cinemaID = cinemaID;
        this.cineplexName = cineplexName;
        this.numberOfSeats = numberOfSeats;
        this.classOfCinema = classOfCinema;
        this.layout = layout;
    }

    //getter
    public String getCinemaID() {
        return cinemaID;
    }

    public String getCineplexName() {
        return cineplexName;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public ClassOfCinema getClassOfCinema() {
        return classOfCinema;
    }

    public Layout getLayout() {
        return layout;
    }

    //setter

    public void setCinemaID(String cinemaID) {
        this.cinemaID = cinemaID;
    }

    public void setCineplexName(String cineplexName) {
        this.cineplexName = cineplexName;
    }
    
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setClassOfCinema(ClassOfCinema classOfCinema) {
        this.classOfCinema = classOfCinema;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

}
