package src.main.java.booking;

import java.time.LocalDateTime;

/**
 * A Booking class.
 * @author Yong Jian Loke
 * @version 1.0
 * @since 2022-11-01
 */
public class Booking {
	private String ticketID;
	private String name;
	private String movieID;
	private String cinema;
	private String pax;
	private String seats;
	private String cost;
	private LocalDateTime dateTime;
	
	/**
	 * Default constructor for Booking.
	 */
	public Booking()
	{
		this.ticketID = "";
		this.name = "";
		this.movieID = "";
		this.cinema = "";
		this.pax = "";
		this.seats = "";
		this.cost = "";
		this.dateTime = LocalDateTime.now();
	}
	
	/**
	 * Booking constructor to create booking class with appropriate argument. 
	 * @param ticketID Movie ticket ID.
	 * @param name Username of user.
	 * @param movieID Movie ID.
	 * @param cinema Cinema of movie.
	 * @param pax Number of pax.
	 * @param seats Seats in the Cinema.
	 * @param cost Cost of the movie ticket.
	 * @param dateTime DateTime of the movie.
	 */
	public Booking(String ticketID, String name, String movieID, String cinema, String pax, String seats, String cost, LocalDateTime dateTime)
	{
		this.ticketID = ticketID;
		this.name = name;
		this.movieID = movieID;
		this.cinema = cinema;
		this.pax = pax;
		this.seats = seats;
		this.cost = cost;
		this.dateTime = dateTime;
	}
	
	/**
	 * Set Ticket ID for booking.
	 * @param ticketID TicketID of the movie booking.
	 */
	public void setticketID(String ticketID)
	{
		this.ticketID = ticketID;
	}
	
	/**
	 * Set name for the booking.
	 * @param name Username of the user.
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Set movieID for booking.
	 * @param movieID movieID of the booking.
	 */
	public void setmovieID(String movieID)
	{
		this.movieID = movieID;
	}
	
	/**
	 * Set cinema for booking.
	 * @param cinema Cinema of the booking.
	 */
	public void setCinema(String cinema)
	{
		this.cinema = cinema;
	}
	
	/**
	 * Set Number of pax for booking.
	 * @param pax Number of people for booking.
	 */
	public void setPax(String pax)
	{
		this.pax = pax;
	}
	
	/**
	 * Set Seat for the booking.
	 * @param seats Seats for the booking.
	 */
	public void setSeats(String seats)
	{
		this.seats = seats;
	}
	
	/**
	 * Set cost for booking.
	 * @param cost Cost for booking.
	 */
	public void setCost(String cost)
	{
		this.cost = cost;
	}

	/**
	 * Set date time for the booking.
	 * @param date Date of the booking.
	 */
	public void setDateTime(LocalDateTime date)
	{
		this.dateTime = date;
	}
	
	/**
	 * Get movie ticketID for the booking.
	 * @return String representation of ticketID.
	 */
	public String getTicketID()
	{
		return ticketID;
	}
	
	/**
	 * Get Username for the booking.
	 * @return String of user's Username.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Get movieID for the booking.
	 * @return String representation of MovieID.
	 */
	public String getmovieID()
	{
		return movieID;
	}
	
	/**
	 * Get Cinema for the booking.
	 * @return String representation for the cinema.
	 */
	public String getCinema()
	{
		return cinema;
	}
	
	/**
	 * Get pax for the booking.
	 * @return String value of number of pax.
	 */
	public String getPax()
	{
		return pax;
	}
	
	/**
	 * Get seats for the booking.
	 * @return String representation of the booking.
	 */
	public String getSeats()
	{
		return seats;
	}
	
	/**
	 * Get cost of the booking.
	 * @return String value of cost of booking.
	 */
	public String getCost()
	{
		return cost;
	}

	/**
	 * Get LocalDateTime for the booking.
	 * @return LocalDateTime for booking.
	 */
	public LocalDateTime getDateTime()
	{
		return dateTime;
	}
}
