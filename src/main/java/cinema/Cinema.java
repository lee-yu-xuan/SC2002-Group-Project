package src.main.java.cinema;

import src.main.java.enums.*;
/**
 * Cinema Class.
 * @author Yong Jian loke
 * @version 1.0
 * @since 2022-11-01
 */
 
public class Cinema{
     
    private String cinemaID;
    private String cineplexName;
    private int numberOfSeats;
    private ClassOfCinema classOfCinema;
    private Layout layout;

    /**
     * Cinema Constructor.
     * @param cinemaID id for the cinema
     * @param cineplexName cineplex that the cinema belongs to
     * @param numberOfSeats number of seats inside the cinema
     * @param classOfCinema class of the cinema(Platinum, Gold, Silver)
     * @param layout layout and size of the cinema(small, medium, large)
     */
    public Cinema(String cinemaID, String cineplexName, int numberOfSeats, ClassOfCinema classOfCinema, Layout layout) {
        this.cinemaID = cinemaID;
        this.cineplexName = cineplexName;
        this.numberOfSeats = numberOfSeats;
        this.classOfCinema = classOfCinema;
        this.layout = layout;
    }

    /**
	  * Get cinema's ID.
	  * @return cinema's ID.
	  */
    public String getCinemaID() {
        return cinemaID;
    }

    /**
     * Get cineplex's name.
     * @return cineplex's name.
     */
    public String getCineplexName() {
        return cineplexName;
    }

    /**
     * Get number of seats.
     * @return number of seats.
     */
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    /**
     * Get class of cinema.
     * @return class of cinema.
     */
    public ClassOfCinema getClassOfCinema() {
        return classOfCinema;
    }

    /**
     * Get layout of cinema.
     * @return layout of cinema.
     */
    public Layout getLayout() {
        return layout;
    }

    
    /**
     * Set cinema's ID.
     * @param cinemaID cinema's ID.
     */
    public void setCinemaID(String cinemaID) {
        this.cinemaID = cinemaID;
    }

    /**
     * Set cineplex's name.
     * @param cineplexName cineplex's name.
     */
    public void setCineplexName(String cineplexName) {
        this.cineplexName = cineplexName;
    }
    
    /**
     * Set number of seats.
     * @param numberOfSeats number of seats.
     */
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    /**
     * Set class of cinema.
     * @param classOfCinema class of cinema.
     */
    public void setClassOfCinema(ClassOfCinema classOfCinema) {
        this.classOfCinema = classOfCinema;
    }

    /**
     * Set layout of cinema.
     * @param layout layout of cinema.
     */
    public void setLayout(Layout layout) {
        this.layout = layout;
    }

}
