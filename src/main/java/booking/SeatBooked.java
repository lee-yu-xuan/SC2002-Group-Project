package src.main.java.booking;

import java.time.LocalDateTime;

public class SeatBooked {
    //Attributes
    private String cinemaID;
    private String layoutType;
    private int noOfRows;
    private int noOfColumns;
    private String seatsTaken;
    private LocalDateTime timing;

    //construct the seatBooked object
    public SeatBooked(String cinemaID, String layoutType, int noOfRows, int noOfColumns, String seatsTaken, LocalDateTime timing) {
        this.cinemaID = cinemaID;
        this.layoutType = layoutType;
        this.noOfRows = noOfRows;
        this.noOfColumns = noOfColumns;
        this.seatsTaken = seatsTaken;
        this.timing = timing;
    }

    //getters
    public String getCinemaID(){
        return cinemaID;
    }

    public String getLayoutType(){
        return layoutType;
    }

    public int getNoOfRows(){
        return noOfRows;
    }

    public int getNoOfColumns(){
        return noOfColumns;
    }

    public String getSeatsTaken(){
        return seatsTaken;
    }

    public LocalDateTime getTiming(){
        return timing;
    }

    //setters

    public void setCinemaID(String cinemaID){
        this.cinemaID = cinemaID;
    }

    public void setLayoutType(String layoutType){
        this.layoutType = layoutType;
    }

    public void setNoOfRows(int noOfRows){
        this.noOfRows = noOfRows;
    }

    public void setNoOfColumns(int noOfColumns){
        this.noOfColumns = noOfColumns;
    }

    public void setSeatsTaken(String seatsTaken){
        this.seatsTaken = seatsTaken;
    }

    public void setTiming(LocalDateTime timing){
        this.timing = timing;
    }

    
}
