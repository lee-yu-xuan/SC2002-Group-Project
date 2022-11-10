package src.main.java.booking;

import java.time.LocalDateTime;
import src.main.java.enums.*;

/**
 * A MovieTicket class.
 * @author Yong Jian Loke
 * @version 1.0
 * @since 2022-11-01
 */
public class MovieTicket{
    //Attributes
    private String ticketID;
    private String movieID;
    private LocalDateTime dateTime;
    private String cinemaID;
    private String seatNo;
    private TypeOfTicket ticketType;
    private Restriction restriction;

    /**
     * MovieTicket constructor.
     * @param ticketID ID of the ticket.
     * @param movieID ID of the movie.
     * @param dateTime DateTime of the movie.
     * @param cinemaID Cinema of the movie.
     * @param seatNo Seat that is chosen.
     * @param ticketType TicketType of the movie.
     * @param restriction Restriction rating of the movie.
     */
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


    /**
     * Get ID of ticket.
     * @return String of ID of ticket.
     */
    public String getTicketID(){
        return ticketID;
    }

    /**
     * Get ID of movie.
     * @return String of ID of movie.
     */
    public String getMovieID(){
        return movieID;
    }   

    /**
     * Get Datetime of the movie.
     * @return LocalDateTime for movie.
     */
    public LocalDateTime getDateTime(){
        return dateTime;
    }

    /**
     * Get ID of ticket.
     * @return String of ID of ticket.
     */
    public String getcinemaID(){
        return cinemaID;
    }   

    /**
     * Get SeatNo of ticket.
     * @return String of SeatNo of ticket.
     */
    public String getSeatNo(){
        return seatNo;
    }   

    /**
     * Get Type of ticket.
     * @return TypeOfTicket.
     */
    public TypeOfTicket getTicketType(){
        return ticketType;
    }   

    /**
     * Get restriction rating of ticket.
     * @return String of restriction rating for movie in the ticket.
     */
    public Restriction getRestriction(){
        return restriction;
    }   

    /**
     * Set ID of Ticket.
     * @param ticketID String of TicketID.
     */
    public void setTicketID(String ticketID){
        this.ticketID = ticketID;
    }   

    /**
     * Set ID of movie.
     * @param movieID MovieID booked.
     */
    public void setMovieID(String movieID){
        this.movieID = movieID;
    }   

    /**
     * Set the DateTime for the ticket.
     * @param dateTime DateTime of the ticket.
     */
    public void setDateTime(LocalDateTime dateTime){
        this.dateTime = dateTime;
    }

    /**
     * Set ID for Cinema.
     * @param cinemaID of cinemaID for ticket.
     */
    public void setcinemaID(String cinemaID){
        this.cinemaID = cinemaID;
    }   

    /**
     * Set Seat No on the ticket.
     * @param seatNo seat number for the ticket.
     */
    public void setSeatNo(String seatNo){
        this.seatNo = seatNo;
    }   

    /**
     * Set ticket type.
     * @param ticketType TicketType of the ticket.
     */
    public void setTicketType(TypeOfTicket ticketType){
        this.ticketType = ticketType;
    }   

    /**
     * Set restriction rating for ticket.
     * @param restriction Restriction rating for the movie in ticket.
     */
    public void setRestriction(Restriction restriction){
        this.restriction = restriction;
    }   

}
