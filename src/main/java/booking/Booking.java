package src.main.java.booking;

import java.time.LocalDateTime;

public class Booking {
	private String ticketID;
	private String name;
	private String movieID;
	private String cinema;
	private String pax;
	private String seats;
	private String cost;
	private LocalDateTime dateTime;
	
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
	
	public void setticketID(String ticketID)
	{
		this.ticketID = ticketID;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setmovieID(String movieID)
	{
		this.movieID = movieID;
	}
	
	public void setCinema(String cinema)
	{
		this.cinema = cinema;
	}
	
	public void setPax(String pax)
	{
		this.pax = pax;
	}
	
	public void setSeats(String seats)
	{
		this.seats = seats;
	}
	
	public void setCost(String cost)
	{
		this.cost = cost;
	}

	public void setDateTime(LocalDateTime date)
	{
		this.dateTime = date;
	}
	
	public String getTicketID()
	{
		return ticketID;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getmovieID()
	{
		return movieID;
	}
	
	public String getCinema()
	{
		return cinema;
	}
	
	public String getPax()
	{
		return pax;
	}
	
	public String getSeats()
	{
		return seats;
	}
	
	public String getCost()
	{
		return cost;
	}

	public LocalDateTime getDateTime()
	{
		return dateTime;
	}
}
