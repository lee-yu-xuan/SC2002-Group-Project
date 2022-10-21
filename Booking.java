package SC2002Project;

import java.util.List;

public class Booking
{
	private String transactionID;
	private String name;
	private String cinema;
	private String pax;
	private String seats;
	private String cost;
	
	public Booking(String transactionID, String name, String cinema, int pax, String seats ,double cost)
	{
		this.transactionID = transactionID;
		this.name = name;
		this.cinema = cinema;
		this.pax = String.valueOf(pax);
		this.seats = seats;
		this.cost = String.valueOf(cost);
		//File IO into database
		String path = "/BookingHistory/" + this.name;
		List<String[]> bookingHistory = File_IO.readFile(path);
		int column = bookingHistory.size();
		bookingHistory.get(column)[0] = this.transactionID;
		bookingHistory.get(column)[1] = this.name;
		bookingHistory.get(column)[2] = this.cinema;
		bookingHistory.get(column)[3] = this.pax;
		bookingHistory.get(column)[4] = this.seats;
		bookingHistory.get(column)[5] = this.cost;
		File_IO.writeFile(bookingHistory,path);
	}
}
