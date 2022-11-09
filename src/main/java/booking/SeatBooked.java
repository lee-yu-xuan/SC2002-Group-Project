package src.main.java.booking;

import java.time.LocalDateTime;

/**
 * A SeatBooked class.
 * @author Yong Jian Loke
 * @version 1.0
 * @since 2022-11-01
 */
public class SeatBooked {
    //Attributes
    private String cinemaID;
    private String layoutType;
    private int noOfRows;
    private int noOfColumns;
    private String seatsTaken;
    private LocalDateTime timing;

    /**
     * Cosntructor for seatbooked.
     * @param cinemaID cinemaID of the movie.
     * @param layoutType Layout of the movie.
     * @param noOfRows  Rows in the cinema.
     * @param noOfColumns Columns in the cinema.
     * @param seatsTaken Booked seats.
     * @param timing DateTime of the movie.
     */
    //construct the seatBooked object
    public SeatBooked(String cinemaID, String layoutType, int noOfRows, int noOfColumns, String seatsTaken, LocalDateTime timing) {
        this.cinemaID = cinemaID;
        this.layoutType = layoutType;
        this.noOfRows = noOfRows;
        this.noOfColumns = noOfColumns;
        this.seatsTaken = seatsTaken;
        this.timing = timing;
    }

    /**
     * Get cinema ID.
     * @return cinemaID.
     */
    public String getCinemaID(){
        return cinemaID;
    }

    /**
     * Get layout of movie.
     * @return LayoutType.
     */
    public String getLayoutType(){
        return layoutType;
    }

    /**
     * Get number of rows in the layout.
     * @return Number of rows.
     */
    public int getNoOfRows(){
        return noOfRows;
    }

    /**
     * Get number of columns in the layout.
     * @return Number of columns.
     */
    public int getNoOfColumns(){
        return noOfColumns;
    }

    /**
     * Get seats taken.
     * @return String of seats taken.
     */
    public String getSeatsTaken(){
        return seatsTaken;
    }

    /**
     * Get timing of the movie.
     * @return DateTime of timing.
     */
    public LocalDateTime getTiming(){
        return timing;
    }


    /**
     * Set the cinemaID of movie.
     * @param cinemaID of the seatbooked.
     */
    public void setCinemaID(String cinemaID){
        this.cinemaID = cinemaID;
    }

    /**
     * Set the Layout of movie.
     * @param layoutType of the movie..
     */
    public void setLayoutType(String layoutType){
        this.layoutType = layoutType;
    }

    /**
     * Set the number of row in the movie.
     * @param noOfRows Number of Rows.
     */
    public void setNoOfRows(int noOfRows){
        this.noOfRows = noOfRows;
    }

    /**
     * Set no of columns in the movie.
     * @param noOfColumns Number of Columns.
     */
    public void setNoOfColumns(int noOfColumns){
        this.noOfColumns = noOfColumns;
    }

    /**
     * Set seats of taken.
     * @param seatsTaken Seatstaken of the movie.
     */
    public void setSeatsTaken(String seatsTaken){
        this.seatsTaken = seatsTaken;
    }

    /**
     * Set DateTime of movie.
     * @param timing DateTime of the movie.
     */
    public void setTiming(LocalDateTime timing){
        this.timing = timing;
    }

    
}
