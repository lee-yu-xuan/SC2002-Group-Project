//yj

public class MovieTicket{
    private static final int basePrice = 6;

    //Attributes
    private String ticketID;
    private String movieID;
    private String date;
    private String time;
    private String cinemaID;
    private String seatNo;
    private TypeOfTicket ticketType;
    private Restriction restriction;

    //construct the movieTicket object
    public MovieTicket(String ticketID, String movieID, String date, String time, String cinemaID, String seatNo, TypeOfTicket ticketType, Restriction restriction) {
        this.ticketID = ticketID;
        this.movieID = movieID;
        this.date = date;
        this.time = time;
        this.cinemaID = cinemaID;
        this.seatNo = seatNo;
        this.ticketType = ticketType;
        this.restriction = restriction;
    }

    public double calculateFair(){
        double fair = 0;
        
        switch(ticketType){
            case Flat:
                fair = basePrice;
                break;
            case Volume:
                fair = basePrice * 1.5;
                break;
            case GOLD:
                fair = basePrice * 2;
                break;
        }
        
        return fair;
    }

    //getters
    public String getTicketID(){
        return ticketID;
    }

    public String getMovieID(){
        return movieID;
    }   

    public String getDate(){
        return date;
    }   

    public String getTime(){
        return time;
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

    public void setDate(String date){
        this.date = date;
    }   

    public void setTime(String time){
        this.time = time;
    }   

    public void setcinemaID(int cinemaID){
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
