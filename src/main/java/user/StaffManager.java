package src.main.java.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import src.main.java.movie.*;
import src.main.java.payment.PromoCode;
import src.main.java.payment.PromoCodeList;
import src.main.java.helper.*;
import src.main.java.sysconfig.*;
import src.main.java.cinema.Cinema;
import src.main.java.cinema.CinemaController;
import src.main.java.cinema.Cineplex;
import src.main.java.cinema.CineplexController;
import src.main.java.enums.*;

/**
 * StaffManager Class. Intermediary for Staff function.
 * 
 * @author Yong Jian Loke
 * @version 1.0
 * @since 2022-11-01
 */
public class StaffManager {

	/**
	 * List of movies.
	 */
	private static List<Movie> movieList;
	private static List<PromoCode> promoList;

	/**
	 * Array of movie details.
	 */
	List<String[]> movie = new ArrayList<String[]>();
	static Scanner scan = new Scanner(System.in);

	/**
	 * Staff's function to add movie to database.
	 */
	public static void addMovie() {
		String MovieName = "";
		String Enum = "Coming Soon";
		String Synopsis = "";
		String Type = "";
		String Director = "";
		String Cast = "";
		String Rating = "NA";
		String reviews = "";
		String rating = "";
		String movieID = "";

		System.out.println("Enter the name of the Movie: ");

		MovieName = ExceptionHandling.checkForAlphabet(1);

		System.out.println("Enter the Synopsis: ");

		Synopsis = ExceptionHandling.checkForAlphabet(1);

		System.out.println("Enter the Type: ");

		Type = ExceptionHandling.checkForAlphabet(1);

		System.out.println("Enter the name of the director: ");

		Director = ExceptionHandling.checkForAlphabet(1);

		System.out.println("Enter the Cast: ");

		Cast = ExceptionHandling.checkForAlphabet(1);

		System.out.println("Enter the rating: ");

		rating = ExceptionHandling.checkForAlphabet(1);

		System.out.println("Enter the movieID: ");

		movieID = ExceptionHandling.checkForAlphabet(2);

		Movie movie = new Movie(MovieName, Synopsis, Type, Director, Cast, rating, movieID);

		MovieListing.add(movie);
	}

	/**
	 * Staff's function to remove movie from database.
	 */
	public static void removeMovie() {
		int no = 0;
		int R = 0;
		System.out.println("Please choose one of the options:");
		System.out.println("1) Delete by movie title");
		System.out.println("2) Delete by movie ID");
		no = ExceptionHandling.IntegerScannerRangeOfFunction(2);

		switch (no) {
			case 1:
				String MovieName = "";
				System.out.println("Enter the name of the Movie: ");

				MovieName = ExceptionHandling.checkForAlphabet(1);

				R = MovieListing.deleteByName(MovieName);
				if (R == 0) {
					System.out.println("Movie not found!!");
					System.out.println();
					return;
				}
				break;

			case 2:
				String MovieID = "";
				System.out.println("Enter the ID of the Movie: ");
				MovieID = ExceptionHandling.checkForAlphabet(2);

				R = MovieListing.deleteByID(MovieID);
				if (R == 0) {
					System.out.println("Movie not found!!");
					System.out.println();
					return;
				}
				break;
			default:
				System.out.println("Wrong options");
		}
	}

	/**
	 * Staff's function to update movie detail.
	 */
	public static void update() {
		int no = 0;
		int index = -1;
		String nam = "";
		System.out.println("Please choose one of the options:");
		System.out.println("1) Update by movie title");
		System.out.println("2) Update by movie ID");
		no = ExceptionHandling.IntegerScannerRangeOfFunction(2);

		switch (no) {
			case 1:
				String MovieName = "";
				System.out.println("Enter the name of the Movie: ");
				MovieName = ExceptionHandling.checkForAlphabet(1);
				index = MovieListing.getMovieIndexByTitle(MovieName);
				if (index == -1) {
					return;
				}
				break;

			case 2:
				String MovieID = "";
				System.out.println("Enter the ID of the Movie: ");
				MovieID = ExceptionHandling.checkForAlphabet(2);
				index = MovieListing.getMovieIndexByID(MovieID);
				if (index == -1) {
					return;
				}
				break;
			default:
				System.out.println("Wrong options");
		}

		boolean x = true;
		while (x) {
			System.out.println("1) Name");
			System.out.println("2) status");
			System.out.println("3) synopsis");
			System.out.println("4) type");
			System.out.println("5) director");
			System.out.println("6) cast");
			System.out.println("7) rating");
			System.out.println("8) Exit");

			System.out.println("Enter your choice:");
			int choice = ExceptionHandling.IntegerScannerRangeOfFunction(8);
			scan.nextLine();
			switch (choice) {
				case 1:
					System.out.println("Enter movie Name");
					String namee = ExceptionHandling.StringScanner();
					MovieListing.getMovieList().get(index).setTitle(namee);
					break;
				case 2:
					System.out.println("Enter movie status");
					String statuss = ExceptionHandling.StringScanner();
					ShowingStatus s = ShowingStatus.valueOf(statuss);
					MovieListing.getMovieList().get(index).setStatus(s);
					// movieCSV.get(i)[1]= statuss;
					break;
				case 3:
					System.out.println("Enter movie synopsis");
					String synopsiss = ExceptionHandling.StringScanner();
					MovieListing.getMovieList().get(index).setSynopsis(synopsiss);
					// movieCSV.get(i)[2]= synopsiss;
					break;
				case 4:
					System.out.println("Enter movie type");
					String typee = ExceptionHandling.StringScanner();
					MovieListing.getMovieList().get(index).setType(typee);
					// movieCSV.get(i)[3]= typee;
					break;
				case 5:
					System.out.println("Enter movie director");
					String directorr = ExceptionHandling.StringScanner();
					MovieListing.getMovieList().get(index).setDirector(directorr);
					// movieCSV.get(i)[4]= directorr;
					break;
				case 6:
					System.out.println("Enter movie cast");
					String castt = ExceptionHandling.StringScanner();
					MovieListing.getMovieList().get(index).setCast(castt);
					// movieCSV.get(i)[5]= castt;
					break;
				case 7:
					System.out.println("Enter movie ratingg");
					String ratingg = ExceptionHandling.StringScanner();
					MovieListing.getMovieList().get(index).setRating(ratingg);
					// movieCSV.get(i)[6]= ratingg;
					break;
				case 8:
					x = false;
					break;
			}

		}

	}

	/**
	 * Staff's function to display top movies by sales or rating.
	 */
	public static void topFiveMovies() {
		int choice = 0;
		do {
			System.out.println("Please choose one of the options");
			System.out.println("1) Ranked by ticketSales");
			System.out.println("2) Ranked by reviewers rating");

			try {
				choice = ExceptionHandling.IntegerScannerRangeOfFunction(2);

			} catch (NumberFormatException nfe) {
				System.out.println("Please enter a number!");
			}
		} while (choice > 2 || choice < 1);

		if (choice == 1) {
			MovieController.showMovieByTicketSales();
		}
		if (choice == 2) {
			List<Movie> movieList = MovieController.showMovieByRating();

			for (int i = 0; i < movieList.size(); i++) {
				System.out.println(i + ". " + movieList.get(i).getMovieTitle());
			}

		}
	}

	/**
	 * Staff's function to add new movie show time.
	 */
	public static void addShowTimes() {
		String movieID = "";
		String cinemaID = "";
		String startTime = "";
		String endTime = "";
		String classOfCinema = "";
		int x = 0;

		System.out.println("Enter the ID of the Movie: ");

		movieID = ExceptionHandling.checkForAlphabet(2);

		System.out.println("Enter the Cinema ID: ");

		cinemaID = ExceptionHandling.checkForAlphabet(2);

		do {
			System.out.println("Enter the startTime of the movie (yyyy-MM-dd HH:mm): ");
			try {
				startTime = ExceptionHandling.StringScanner();
				LocalDateTime.parse(startTime, _DateTimeFormatter.formatter);
				x = 0;
			} catch (NumberFormatException nfe) {
				System.out.println("Please enter in string!");
			} catch (java.time.format.DateTimeParseException e) {
				System.out.println("Please enter the correct format");
				System.out.println();
				x = 1;
			}
		} while (startTime.isEmpty() || x == 1);

		do {
			System.out.println("Enter the endTime of the movie (yyyy-MM-dd HH:mm): ");
			try {
				endTime = ExceptionHandling.StringScanner();
				LocalDateTime.parse(endTime, _DateTimeFormatter.formatter);
				x = 0;
			} catch (NumberFormatException nfe) {
				System.out.println("Please enter in string!");
			} catch (java.time.format.DateTimeParseException e) {
				System.out.println("Please enter the correct format");
				System.out.println();
				x = 1;
			}
		} while (endTime.isEmpty() || x == 1);

		do {
			System.out.println("Enter the class of cinema: ");
			try {
				classOfCinema = ExceptionHandling.StringScanner();
				ClassOfCinema.valueOf(classOfCinema);
				x = 0;
			} catch (NumberFormatException nfe) {
				System.out.println("Please enter in string!");
			} catch (java.lang.IllegalArgumentException e) {
				System.out.println("Please enter the correct format");
				System.out.println();
				x = 1;
			}
		} while (classOfCinema.isEmpty());

		ClassOfCinema CC = ClassOfCinema.valueOf(classOfCinema);
		ShowTime ST = new ShowTime(movieID, cinemaID, startTime, endTime, CC);
		ShowTimeList.add(ST);
	}

	/**
	 * Staff's function to remove movie showtime.
	 */
	public static void removeShowTimes() {
		int no = 0;

		System.out.println("Please choose one of the options:");
		System.out.println("1) Delete by movie index");
		System.out.println("2) Delete by movie info");
		no = ExceptionHandling.IntegerScannerRangeOfFunction(2);

		switch (no) {
			case 1:
				int index = -1;
				System.out.println("Enter the index of the Movie: ");
				do {
					try {
						index = ExceptionHandling.IntegerScanner();
					} catch (NumberFormatException nfe) {
						System.out.println("Please enter in integer!");
					}
				} while (index < 0);

				ShowTimeList.deleteByIndex(index);
				break;

			case 2:
				String movieID = "";
				String cinemaID = "";
				LocalDateTime startTime;
				LocalDateTime endTime;
				String classOfCinema = "";
				int x = 0;
				System.out.println("Enter the ID of the Movie: ");

				movieID = ExceptionHandling.checkForAlphabet(2);

				System.out.println("Enter the Cinema ID: ");

				cinemaID = ExceptionHandling.checkForAlphabet(2);

				System.out.println("Enter the startTime of the movie (yyyy-MM-dd HH:mm): ");
				startTime = ExceptionHandling.checkDateTime();

				System.out.println("Enter the endTime of the movie (yyyy-MM-dd HH:mm): ");
				endTime = ExceptionHandling.checkDateTime();

				ShowTimeList.deleteByMovieInfo(movieID, cinemaID, startTime, endTime);
				break;
			default:
				System.out.println("Wrong options");
		}
	}

	/**
	 * Staff's function to edit System Configuration.
	 */
	public static void editSysCon() {
		int no = 0, i, plat, gold, silv;
		double price;
		String start, end;
		String[] classW;
		try {
			System.out.println("Please choose one of the options:");
			System.out.println("1) Print public holidays");
			System.out.println("2) Remove public holidays");
			System.out.println("3) Add public holidays");
			System.out.println("4) Set base price");
			System.out.println("5) Get base price");
			System.out.println("6) get class weight");
			System.out.println("7) set class weight");

			no = ExceptionHandling.IntegerScannerRangeOfFunction(7);

			switch (no) {

				case 1:
					SystemConfig.printHolidayList();
					break;
				case 2:
					SystemConfig.removeHolidays();
					break;
				case 3:
					System.out.println("Enter holiday start and end (yyyy-MM-dd yyyy-MM-dd):");
					start = ExceptionHandling.StringScanner();
					end = ExceptionHandling.StringScanner();
					SystemConfig.addHoliday(start, end);
					break;
				case 4:
					price = scan.nextDouble();
					SystemConfig.setBasePrice(price);
					break;
				case 5:
					price = SystemConfig.getBasePrice();
					System.out.println("base price: " + price);
					break;
				case 6:
					classW = SystemConfig.getClassWeight();
					for (i = 0; i < classW.length; i += 2) {
						System.out.print(classW[i] + ": " + classW[i + 1]);
					}
					break;
				case 7:
					System.out.println("Enter int multiplier for respective Cinema class");
					System.out.print("Platinum: ");
					plat = ExceptionHandling.IntegerScanner();
					System.out.print("Gold: ");
					gold = ExceptionHandling.IntegerScanner();
					System.out.print("Silver: ");
					silv = ExceptionHandling.IntegerScanner();
					SystemConfig.setClassWeight(plat, gold, silv);
					break;
				default:
					System.out.println("Invalid choice!");
			}
		} catch (Exception e) {
			System.out.println("error " + e.getMessage());
		}
	}

	/**
	 * Add promo code function for Staff.
	 */
	public static void addPromo() {
		String promoCode = "";
    int count = 0;
    LocalDateTime startTime;
    LocalDateTime endTime;
    PromoCodeStatus promoCodeStatus = PromoCodeStatus.READY;
		double offer = 1.0;
		int flag = 0;

		System.out.println("Enter the name of the Promo Code: ");
		promoCode = ExceptionHandling.checkForAlphabet(1);

		System.out.println("Enter the count of the Promo Code: ");
		count = Integer.valueOf(ExceptionHandling.checkForAlphabet(2));

		System.out.println("Enter the startTime of the Promo Code (yyyy-MM-dd HH:mm): ");
		startTime =  ExceptionHandling.checkDateTime();

		System.out.println("Enter the endTime of the Promo Code (yyyy-MM-dd HH:mm): ");
		endTime =  ExceptionHandling.checkDateTime();
		
		do {
			String status;
			System.out.println("Enter the status of the Promo Code :");
			status = ExceptionHandling.StringScanner();
			try {
				promoCodeStatus = PromoCodeStatus.valueOf(status);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Invalid input! Enter either Ready, Available or Blocked");
				continue;
			}
			flag = 1;
			// if(status.toLowerCase().equals("ready"))
			// {
			// 	promoCodeStatus = PromoCodeStatus.READY;
			// 	flag = 1;
			// }
			// else if(status.toLowerCase().equals("available"))
			// {
			// 	promoCodeStatus = PromoCodeStatus.AVAILABLE;
			// 	flag = 1;
			// }
			// else if(status.toLowerCase().equals("blocked"))
			// {
			// 	promoCodeStatus = PromoCodeStatus.BLOCKED;
			// 	flag = 1;
			// }
			// else
			// {
			// 	System.out.println("Invalid input! Enter either Ready, Available or Blocked");
		}while(flag==0);

	PromoCode promo = new PromoCode(promoCode, offer, count, startTime, endTime, promoCodeStatus);

	PromoCodeList.add(promo);
	}

	/**
	 * View all promo code function for Staff.
	 */
	public static void viewAllPromo()
	{
		promoList = PromoCodeList.getPromoCodeList();

		if(promoList.size() == 0)
		{
			System.out.println("No promo codes in database");
		}
		else
		{
			for(int i=0 ; i<promoList.size() ; i++)
			{
				System.out.println((i+1) +". " + promoList.get(i).getPromoCode() + " : " + promoList.get(i).getOffer() + " (" + promoList.get(i).getPromoCodeStatus() +")" );
			}
		}
	}

	/**
	 * Add Cinema function for Staff.
	 */
	public static void addCinema() {
		String cinemaID = "";
		String branch = "";
		int numberOfSeats = 0;
		String tmp_classOfCinema = "";
		Layout tmp_layout;
		
		System.out.println("Enter the cinemaID: ");
		cinemaID = ExceptionHandling.StringScanner();
		
		System.out.println("Enter the branch: ");
		branch = ExceptionHandling.checkForAlphabet(1);
		
		System.out.println("Enter the number of seats ");	
		numberOfSeats = ExceptionHandling.IntegerScanner();
	
		System.out.println("Enter the class of cinema: ");	
		ClassOfCinema classOfCinema = ExceptionHandling.checkClassOfCinema();

		System.out.println("Enter the layout type: ");
		tmp_layout = ExceptionHandling.checkForAlphabet(1);
		Layout layout = Layout.valueOf(tmp_layout);
	
		Cinema cinema = new Cinema(cinemaID, branch, numberOfSeats, classOfCinema, tmp_layout);

		CinemaController.add(cinema);

		System.out.println("Cinema has been added successfully!");
	}

	/**
	 * Remove Cinema function for Staff.
	 */
	public static void removeCinema(){
		String cinemaID = "";
		System.out.println("Enter the cinemaID that you want to remove: ");
		cinemaID = ExceptionHandling.StringScanner();
		CinemaController.deleteByID(cinemaID);
		if(CinemaController.deleteByID(cinemaID)==0){
			System.out.println("Cinema not found!");
			System.out.println();
		}
	}

	/**
	 * Add Cineplex function for Staff.
	 */
	public static void addCineplex(){
		String cineplexName = "";
		System.out.println("Please enter the name of the new cineplex that you wish to add: ");
		cineplexName = ExceptionHandling.checkForAlphabet(1);
		Cineplex cineplex = new Cineplex(cineplexName);
		CineplexController.add(cineplex);

		System.out.println("Cineplex has been added successfully!");
		System.out.println();
	}

	/**
	 * Remove Cineplex function for Staff.
	 */
	public static void removeCineplex(){
		String cineplexName = "";
		System.out.println("Enter the cineplex name that you want to remove: ");
		cineplexName = ExceptionHandling.StringScanner();
		CineplexController.deleteByName(cineplexName);
		if(CineplexController.deleteByName(cineplexName)==0){
			System.out.println("Cineplex not found!");
			System.out.println();
		}
	}

}