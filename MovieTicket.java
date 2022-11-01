import java.time.LocalDateTime;

//yj

public class MovieTicket{
    //Attributes
    private String ticketID;
    private String movieID;
    private LocalDateTime dateTime;
    private String cinemaID;
    private String seatNo;
    private TypeOfTicket ticketType;
    private Restriction restriction;

    //construct the movieTicket object
    public MovieTicket(String ticketID, String movieID, LocalDateTime dateTime, String cinemaID, String seatNo, TypeOfTicket ticketType, Restriction restriction) {
        this.ticketID = ticketID;
        this.movieID = movieID;
        this.dateTime = dateTime;
        this.cinemaID = cinemaID;
        this.seatNo = seatNo;
        this.ticketType = ticketType;
        this.restriction = restriction;
    }


    //getters
    public String getTicketID(){
        return ticketID;
    }

    public String getMovieID(){
        return movieID;
    }   

    public String getDateTime(){
        return dateTime.toString();
    }

    public String getcinemaID(){
        return cinemaID;
    }   

    public String getSeatNo(){
        return seatNo;
    }   

    public TypeOfTicket getTicketType(){
        return ticketType;
    }   

    public Restriction getRestriction(){
        return restriction;
    }   

    //setters
    public void setTicketID(String ticketID){
        this.ticketID = ticketID;
    }   

    public void setMovieID(String movieID){
        this.movieID = movieID;
    }   

    public void setDateTime(LocalDateTime dateTime){
        this.dateTime = dateTime;
    }

    public void setcinemaID(String cinemaID){
        this.cinemaID = cinemaID;
    }   

    public void setSeatNo(String seatNo){
        this.seatNo = seatNo;
    }   

    public void setTicketType(TypeOfTicket ticketType){
        this.ticketType = ticketType;
    }   

    public void setRestriction(Restriction restriction){
        this.restriction = restriction;
    }   

}
