package SC2002_2;

import java.util.ArrayList;
import java.util.List;

public class BookingManager {
	private static List<Booking> bookingHistory;
	private static List<String[]> bookingHistoryCSV;
	
	public static List<Booking> getBookingHistory()
	{
		return bookingHistory;
	}
	
	public static void addBooking(Booking booking)
	{
		if(bookingHistory == null)
		{
			System.out.println("Booking history is empty");
			bookingHistory = new ArrayList<Booking>();
		}
		bookingHistory.add(booking);
	}
	
	public static int deleteBooking(String transactionID)
	{
		for(int i=0 ; i<bookingHistory.size(); i++)
		{
			if(bookingHistory.get(i).getTransactionID() == transactionID)
			{
				bookingHistory.remove(i);
				return 1;
			}
		}
		return 0;
	}
	
	public static void load(String name)
	{
		if(bookingHistory == null)
		{
			//System.out.println("Booking history is empty");
			bookingHistory = new ArrayList<Booking>();			
		}
		
		bookingHistoryCSV = File_IO.readFile("BookingHistory/"+name);
		
		for(int i=0 ; i<bookingHistoryCSV.size(); i++)
		{
			String transactionID = bookingHistoryCSV.get(i)[0];
			String user_name = bookingHistoryCSV.get(i)[1];
			String movieName = bookingHistoryCSV.get(i)[2];
			String cinema = bookingHistoryCSV.get(i)[3];
			String pax = bookingHistoryCSV.get(i)[4];;
			String seats = bookingHistoryCSV.get(i)[5];
			String cost = bookingHistoryCSV.get(i)[6];
			bookingHistory.add(new Booking(transactionID, user_name, movieName, cinema, pax, seats, cost));
		}
	}
	
	public static void save(String name)
	{
		List<String[]> tempCSV = new ArrayList<String[]>();
		
		for(int i=0 ; i<bookingHistory.size() ; i++)
		{
			String[] temp = new String[7];
			temp[0] = bookingHistory.get(i).getTransactionID();
			temp[1] = bookingHistory.get(i).getName();
			temp[2] = bookingHistory.get(i).getMovieName();
			temp[3] = bookingHistory.get(i).getCinema();
			temp[4] = bookingHistory.get(i).getPax();
			temp[5] = bookingHistory.get(i).getSeats();
			temp[6] = bookingHistory.get(i).getCost();
			tempCSV.add(temp);
		}
		File_IO.writeFile(tempCSV, "BookingHistory/"+name);
	}
}
