//yj

import java.util.List;

public class Cinema extends Cineplex{
 
    //attributes
    private int cinemaID;
    private int numberOfSeats;
    private ClassOfCinema classOfCinema;
    private Layout layout;

    //constructor
    public Cinema(int cinemaID, int numberOfSeats, ClassOfCinema classOfCinema, Layout layout) {
        this.cinemaID = cinemaID;
        this.numberOfSeats = numberOfSeats;
        this.classOfCinema = classOfCinema;
        this.layout = layout;
    }

    //getter
    public int getCinemaID() {
        return cinemaID;
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

    public void setCinemaID(int cinemaID) {
        this.cinemaID = cinemaID;
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
