package SC2002_2;

public class Booking {
	private String transactionID;
	private String name;
	private String movieName;
	private String cinema;
	private String pax;
	private String seats;
	private String cost;
	
	public Booking()
	{
		this.transactionID = "";
		this.name = "";
		this.movieName = "";
		this.cinema = "";
		this.pax = "";
		this.seats = "";
		this.cost = "";
	}
	
	public Booking(String transactionID, String name, String movieName, String cinema, String pax, String seats, String cost)
	{
		this.transactionID = transactionID;
		this.name = name;
		this.movieName = movieName;
		this.cinema = cinema;
		this.pax = pax;
		this.seats = seats;
		this.cost = cost;
	}
	
	public void setTransactionID(String transactionID)
	{
		this.transactionID = transactionID;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setMovieName(String movieName)
	{
		this.movieName = movieName;
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
	
	public String getTransactionID()
	{
		return transactionID;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getMovieName()
	{
		return movieName;
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
}
