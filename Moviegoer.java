package SC2002Project;
import java.util.List;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 

public class Moviegoer extends constructUser
{
	private List<Booking> bookingHistory;
	
	public Moviegoer(String name, String username, String password)
	{
		this.name = name;
		this.username = username;
		this.password = password;
		//File I/O to get bookingHistory
	}
	
	public void addBooking(String cinemaCode, String movieName, String cinema, int pax, String seats,double cost)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmm");  
		LocalDateTime now = LocalDateTime.now();
		String transactionID = cinemaCode + dtf.format(now);
		bookingHistory.add(new Booking(transactionID, this.name, movieName, cinema, pax, seats, cost));
	}
	
	public void checkBookingHistory()
	{
		for(int i = 0; i < bookingHistory.size() ; i++)
		{
			System.out.println(bookingHistory.get(i));
		}
	}
	
	public void searchMovie(String movieName)
	{
		MovieController mc = new MovieController();
		//MC.getSearchMovie(movieName);
	}
	
	public void listMovie()
	{
		MovieController mc = new MovieController();
		//mc.getMovieList(movieName);
	}
	
	public void showAvailability(String movieName, String movieClass)
	{
		LayoutController lc = new LayoutController();
		//lc.showAvailability(movieName, movieClass);
	}
	
	public void showSalesRanking()
	{
		LayoutController lc = new LayoutController();
		//lc.showSalesRanking();
	}
	
	public void showReviewRanking()
	{
		LayoutController lc = new LayoutController();
		//lc.showReviewRanking();
	}
}
