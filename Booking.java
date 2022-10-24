package SC2002Project;

import java.util.List;

public class Booking
{
	private String transactionID;
	private String name;
	private String movieName;
	private String cinema;
	private String pax;
	private String seats;
	private String cost;
	
	public Booking(String transactionID, String name, String movieName, String cinema, int pax, String seats ,double cost)
	{
		this.transactionID = transactionID;
		this.name = name;
		this.movieName = movieName;
		this.cinema = cinema;
		this.pax = String.valueOf(pax);
		this.seats = seats;
		this.cost = String.valueOf(cost);
		//File IO into database
	}
	
	public void addBooking()
	{
		String path = "/BookingHistory/" + this.name;
		List<String[]> bookingHistory = File_IO.readFile(path);
		int column = bookingHistory.size();
		bookingHistory.get(column)[0] = this.transactionID;
		bookingHistory.get(column)[1] = this.name;
		bookingHistory.get(column)[2] = this.movieName;
		bookingHistory.get(column)[3] = this.cinema;
		bookingHistory.get(column)[4] = this.pax;
		bookingHistory.get(column)[5] = this.seats;
		bookingHistory.get(column)[6] = this.cost;
		File_IO.writeFile(bookingHistory,path);		
		addToSales(this.movieName, Integer.parseInt(pax));
	}
	
	public void addToSales(String movieName, int pax)
	{
		String path = "movieSalesRanking";
		List<String[]> salesRanking = File_IO.readFile(path);
		//File I/O function to help find an element
		//update the sales number of that movie by the number of pax
	}
}
