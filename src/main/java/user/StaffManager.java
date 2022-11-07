package src.main.java.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import src.main.java.movie.*;
import src.main.java.helper.*;
import src.main.java.sysconfig.*;
import src.main.java.enums.*;

/**
 * StaffManager Class. Intermediary for Staff function.
 * 
 * @author Yong Jian
 * @version 1.0
 * @since 2022-11-01
 */
public class StaffManager {

	/**
	 * List of movies.
	 */
	private static List<Movie> movieList;

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
		do {
			System.out.println("Enter the name of the Movie: ");
			try {
				MovieName = scan.nextLine();
			} catch (NumberFormatException nfe) {
				System.out.println("Please enter in string!");
			}
		} while (MovieName.isEmpty());

		do {
			System.out.println("Enter the Synopsis: ");
			try {
				Synopsis = scan.nextLine();
			} catch (NumberFormatException nfe) {
				System.out.println("Please enter in string!");
			}
		} while (Synopsis.isEmpty());

		do {
			System.out.println("Enter the Type: ");
			try {
				Type = scan.nextLine();
			} catch (NumberFormatException nfe) {
				System.out.println("Please enter in string!");
			}
		} while (Type.isEmpty());

		do {
			System.out.println("Enter the name of the director: ");
			try {
				Director = scan.nextLine();
			} catch (NumberFormatException nfe) {
				System.out.println("Please enter in string!");
			}
		} while (Director.isEmpty());

		do {
			System.out.println("Enter the Cast: ");
			try {
				Cast = scan.nextLine();
			} catch (NumberFormatException nfe) {
				System.out.println("Please enter in string!");
			}
		} while (Cast.isEmpty());

		do {
			System.out.println("Enter the rating: ");
			try {
				rating = scan.nextLine();
			} catch (NumberFormatException nfe) {
				System.out.println("Please enter in string!");
			}
		} while (rating.isEmpty());

		do {
			System.out.println("Enter the movieID: ");
			try {
				movieID = scan.nextLine();
			} catch (NumberFormatException nfe) {
				System.out.println("Please enter in string!");
			}
		} while (movieID.isEmpty());

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
		no = scan.nextInt();

		switch (no) {
			case 1:
				String MovieName = "";
				System.out.println("Enter the name of the Movie: ");
				do {
					try {
						MovieName = scan.nextLine();
					} catch (NumberFormatException nfe) {
						System.out.println("Please enter in string!");
					}
				} while (MovieName.isEmpty());

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
				do {
					try {
						MovieID = scan.nextLine();
					} catch (NumberFormatException nfe) {
						System.out.println("Please enter in string!");
					}
				} while (MovieID.isEmpty());

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
		no = scan.nextInt();

		switch (no) {
			case 1:
				String MovieName = "";
				System.out.println("Enter the name of the Movie: ");
				do {

					try {
						MovieName = scan.nextLine();
					} catch (NumberFormatException nfe) {
						System.out.println("Please enter in string!");
					}
				} while (MovieName.isEmpty());
				index = MovieListing.getMovieIndexByTitle(MovieName);
				if (index == -1) {
					return;
				}
				break;

			case 2:
				String MovieID = "";
				System.out.println("Enter the ID of the Movie: ");
				do {
					try {
						MovieID = scan.nextLine();
					} catch (NumberFormatException nfe) {
						System.out.println("Please enter in string!");
					}
				} while (MovieID.isEmpty());
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
			int choice = scan.nextInt();
			scan.nextLine();
			switch (choice) {
				case 1:
					System.out.println("Enter movie Name");
					String namee = scan.nextLine();
					MovieListing.getMovieList().get(index).setTitle(namee);
					break;
				case 2:
					System.out.println("Enter movie status");
					String statuss = scan.nextLine();
					ShowingStatus s = ShowingStatus.valueOf(statuss);
					MovieListing.getMovieList().get(index).setStatus(s);
					// movieCSV.get(i)[1]= statuss;
					break;
				case 3:
					System.out.println("Enter movie synopsis");
					String synopsiss = scan.nextLine();
					MovieListing.getMovieList().get(index).setSynopsis(synopsiss);
					// movieCSV.get(i)[2]= synopsiss;
					break;
				case 4:
					System.out.println("Enter movie type");
					String typee = scan.nextLine();
					MovieListing.getMovieList().get(index).setType(typee);
					// movieCSV.get(i)[3]= typee;
					break;
				case 5:
					System.out.println("Enter movie director");
					String directorr = scan.nextLine();
					MovieListing.getMovieList().get(index).setDirector(directorr);
					// movieCSV.get(i)[4]= directorr;
					break;
				case 6:
					System.out.println("Enter movie cast");
					String castt = scan.nextLine();
					MovieListing.getMovieList().get(index).setCast(castt);
					// movieCSV.get(i)[5]= castt;
					break;
				case 7:
					System.out.println("Enter movie ratingg");
					String ratingg = scan.nextLine();
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
				choice = scan.nextInt();

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

		do {
			System.out.println("Enter the ID of the Movie: ");
			try {
				movieID = scan.nextLine();
			} catch (NumberFormatException nfe) {
				System.out.println("Please enter in string!");
			}
		} while (movieID.isEmpty());

		do {
			System.out.println("Enter the Cinema ID: ");
			try {
				cinemaID = scan.nextLine();
			} catch (NumberFormatException nfe) {
				System.out.println("Please enter in string!");
			}
		} while (cinemaID.isEmpty());

		do {
			System.out.println("Enter the startTime of the movie (yyyy-MM-dd HH:mm): ");
			try {
				startTime = scan.nextLine();
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
				endTime = scan.nextLine();
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
				classOfCinema = scan.nextLine();
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
		no = scan.nextInt();

		switch (no) {
			case 1:
				int index = -1;
				System.out.println("Enter the name of the Movie: ");
				do {
					try {
						index = scan.nextInt();
					} catch (NumberFormatException nfe) {
						System.out.println("Please enter in integer!");
					}
				} while (index < 0);

				ShowTimeList.deleteByIndex(index);
				break;

			case 2:
				String movieID = "";
				String cinemaID = "";
				String startTime = "";
				String endTime = "";
				String classOfCinema = "";
				int x = 0;
				System.out.println("Enter the ID of the Movie: ");

				do {
					try {
						movieID = scan.nextLine();
					} catch (NumberFormatException nfe) {
						System.out.println("Please enter in string!");
					}
				} while (movieID.isEmpty());

				do {
					System.out.println("Enter the Cinema ID: ");
					try {
						cinemaID = scan.nextLine();
					} catch (NumberFormatException nfe) {
						System.out.println("Please enter in string!");
					}
				} while (cinemaID.isEmpty());

				do {
					System.out.println("Enter the startTime of the movie (yyyy-MM-dd HH:mm): ");
					try {
						startTime = scan.nextLine();
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
						endTime = scan.nextLine();
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

				ShowTimeList.deleteByMovieInfo(movieID, cinemaID,
						LocalDateTime.parse(startTime, _DateTimeFormatter.formatter),
						LocalDateTime.parse(endTime, _DateTimeFormatter.formatter));
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
			System.out.println("2) Remove prublic holidays");
			System.out.println("3) Add public holidays");
			System.out.println("4) Set base price");
			System.out.println("5) Get base price");
			System.out.println("6) get class weight");
			System.out.println("7) set class weight");

			no = scan.nextInt();

			switch (no) {

				case 1:
					SystemConfig.printHolidayList();
					break;
				case 2:
					SystemConfig.removeHolidays();
					break;
				case 3:
					System.out.println("Enter holiday start and end (yyyy-MM-dd yyyy-MM-dd):");
					start = scan.next();
					end = scan.next();
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
					plat = scan.nextInt();
					System.out.print("Gold: ");
					gold = scan.nextInt();
					System.out.print("Silver: ");
					silv = scan.nextInt();
					SystemConfig.setClassWeight(plat, gold, silv);
					break;
				default:
					System.out.println("Invalid choice!");
			}
		} catch (Exception e) {
			System.out.println("error " + e.getMessage());
		}
	}
}