import java.util.List;

public class Cinema extends Cineplex{
    public enum ClassOfCinema {
        Platinum, Gold, Silver
    }

    public enum Layout{
        small, medium, large
    }

    //attributes
    private int cinemaID;
    private int numberOfSeats;
    private int seatLeft;
    private ClassOfCinema classOfCinema;
    private Layout layout;

    //constructor
    public Cinema(int cinemaID, int numberOfSeats, int seatLeft,ClassOfCinema classOfCinema, Layout layout) {
        this.cinemaID = cinemaID;
        this.numberOfSeats = numberOfSeats;
        this.seatLeft = seatLeft;
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

    public int getSeatLeft() {
        return seatLeft;
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

    public void setSeatLeft(int seatLeft) {
        this.seatLeft = seatLeft;
    }

    public void setClassOfCinema(ClassOfCinema classOfCinema) {
        this.classOfCinema = classOfCinema;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

}
