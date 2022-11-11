package src.main.java.booking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import src.main.java.helper.*;

/**
 * A BookingManager class.
 * @author Yong Jian Loke
 * @version 1.0
 * @since 2022-11-01
 */
public class BookingManager {
	private static List<Booking> bookingHistory;
	private static List<String[]> bookingHistoryCSV;
	/**
	 * Create instance of File_IO.
	 */
	private static File_IOInterface file_IO = new CSVFile_IO();
	/**
	 * Upcomingmovie booking.
	 * @return List of Upcoming Movie Booking.
	 */
	public static List<Booking> showUpcomingBooking(){
		bookingHistory = BookingManager.getBookingHistory();
		//get current dateTime
		LocalDateTime currentDateTime = LocalDateTime.now();
		List<Booking> upcomingBooking = new ArrayList<Booking>();
		int existUpComingBooking = 0;
		for(int i=0; i<bookingHistory.size(); i++){
			if(bookingHistory.get(i).getDateTime().isAfter(currentDateTime)){
				upcomingBooking.add(bookingHistory.get(i));
				existUpComingBooking = 1;
			}
		}
		if(existUpComingBooking==0) return null;
		return upcomingBooking;
	}

	/**
	 * Past movie bookings.
	 * @return List of Past Movie booking.
	 */
	public static List<Booking> showPastBooking(){
		bookingHistory = BookingManager.getBookingHistory();
		LocalDateTime currentDateTime = LocalDateTime.now();
		List<Booking> upcomingBooking = new ArrayList<Booking>();
		int existUpComingBooking = 0;
		for(int i=0; i<bookingHistory.size(); i++){
			if(bookingHistory.get(i).getDateTime().isBefore(currentDateTime)){
				upcomingBooking.add(bookingHistory.get(i));
				existUpComingBooking = 1;
			}
		}
		if(existUpComingBooking==0) return null;
		return upcomingBooking;
	}

	/**
	 * Booking history of user.
	 * @return List of Booking history made by a user.
	 */
	public static List<Booking> getBookingHistory()
	{
		if(bookingHistory==null){
			//System.out.println("You have not done any booking yet");
			return null;
		}
		return bookingHistory;
	}
	
	/**
	 * Add booking details to the existing booking
	 * @param booking Booking class of the new booking.
	 */
	public static void addBooking(Booking booking)
	{
		if(bookingHistory == null)
		{
			bookingHistory = new ArrayList<Booking>();
		}
		bookingHistory.add(booking);
	}
	
	/**
	 * Remove booking history.
	 * @param ticketID TicketID of booking class to be removed.
	 * @return Integer representation if removal is successful.
	 */
	public static int deleteBooking(String ticketID)
	{
		for(int i=0 ; i<bookingHistory.size(); i++)
		{
			if(bookingHistory.get(i).getTicketID() == ticketID)
			{
				bookingHistory.remove(i);
				return 1;
			}
		}
		return 0;
	}
	
	/**
	 * Load all booking history.
	 * @param name Username of user history to be loaded.
	 */
	public static void load(String name)
	{
		bookingHistory = new ArrayList<Booking>();	
		bookingHistoryCSV = file_IO.readFile("BookingHistory/"+name);
		if(bookingHistoryCSV==null) {
			//System.out.println("You have not done any booking yet");
			return;
		}
		
		for(int i=0 ; i<bookingHistoryCSV.size(); i++)
		{
			String ticketID = bookingHistoryCSV.get(i)[0];
			String user_name = bookingHistoryCSV.get(i)[1];
			String movieName = bookingHistoryCSV.get(i)[2];
			String cinema = bookingHistoryCSV.get(i)[3];
			String pax = bookingHistoryCSV.get(i)[4];;
			String seats = bookingHistoryCSV.get(i)[5];
			String cost = bookingHistoryCSV.get(i)[6];
			String dateTime = bookingHistoryCSV.get(i)[7];
			bookingHistory.add(new Booking(ticketID, user_name, movieName, cinema, pax, seats, cost, LocalDateTime.parse(dateTime,_DateTimeFormatter.formatter)));
		}
	}
	
	/**
	 * Save booking history details.
	 * @param name Username of user that made a booking.
	 */
	public static void save(String name)
	{
		List<String[]> tempCSV = new ArrayList<String[]>();
		
		for(int i=0 ; i<bookingHistory.size() ; i++)
		{
			String[] temp = new String[8];
			temp[0] = bookingHistory.get(i).getTicketID();
			temp[1] = bookingHistory.get(i).getName();
			temp[2] = bookingHistory.get(i).getmovieID();
			temp[3] = bookingHistory.get(i).getCinema();
			temp[4] = bookingHistory.get(i).getPax();
			temp[5] = bookingHistory.get(i).getSeats();
			temp[6] = bookingHistory.get(i).getCost();
			LocalDateTime dateTime = bookingHistory.get(i).getDateTime();
			temp[7] = dateTime.format(_DateTimeFormatter.formatter);
			tempCSV.add(temp);
		}
		file_IO.writeFile(tempCSV, "BookingHistory/"+name);
	}
}
