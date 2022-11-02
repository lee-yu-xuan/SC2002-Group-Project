import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaffManager {
	private static List<Movie> movieList;
	List<String[]> movie = new ArrayList<String[]>();
	static Scanner scan = new Scanner(System.in);
	 
	 public static void addMovie()
	{
		String MovieName="";
		String Enum="Coming Soon";
		String Synopsis = "";
		String Type = "";
		String Director = "";
		String Cast = "";
		String Rating = "NA";
		String reviews = "";
		String rating="";
		String movieID ="";
		do {
		 System.out.println("Enter the name of the Movie: ");
		 try {
			 MovieName = scan.nextLine();
		 }
		 catch(NumberFormatException nfe) {
			 System.out.println("Please enter in string!");
		 }
		}while (MovieName.isEmpty());
		
		 
		do {
			System.out.println("Enter the Synopsis: ");
			 try {
				 Synopsis = scan.nextLine();
			 }
			 catch(NumberFormatException nfe) {
				 System.out.println("Please enter in string!");
			 }
			}while (Synopsis.isEmpty());
		
		do {
			System.out.println("Enter the Type: ");
			 try {
				 Type = scan.nextLine();
			 }
			 catch(NumberFormatException nfe) {
				 System.out.println("Please enter in string!");
			 }
			}while (Type.isEmpty());
		 
		do {
			System.out.println("Enter the name of the director: ");
			 try {
				 Director = scan.nextLine();
			 }
			 catch(NumberFormatException nfe) {
				 System.out.println("Please enter in string!");
			 }
			}while (Director.isEmpty());
		 
		do {
			System.out.println("Enter the Cast: ");
			 try {
				 Cast = scan.nextLine();
			 }
			 catch(NumberFormatException nfe) {
				 System.out.println("Please enter in string!");
			 }
			}while (Cast.isEmpty());
		
		do {
			System.out.println("Enter the rating: ");
			 try {
				 rating = scan.nextLine();
			 }
			 catch(NumberFormatException nfe) {
				 System.out.println("Please enter in string!");
			 }
			}while (rating.isEmpty());
		 
		do {
			System.out.println("Enter the movieID: ");
			 try {
				 movieID = scan.nextLine();
			 }
			 catch(NumberFormatException nfe) {
				 System.out.println("Please enter in string!");
			 }
			}while (movieID.isEmpty());
		
			Movie movie = new Movie(MovieName, Synopsis, Type,Director, Cast, rating,movieID);
			
			MovieListing.add(movie); 
			
		
			
			
			/*
			 * String path = "/MovieListing/" + this.MovieName; List<String[]> MovieListing
			 * = File_IO.readFile(path); int column = MovieListing.size();
			 * MovieListing.get(column)[0] = this.MovieName; MovieListing.get(column)[1] =
			 * this.Enum; MovieListing.get(column)[2] = this.Synopsis;
			 * MovieListing.get(column)[3] = this.director; MovieListing.get(column)[4] =
			 * this.cast; MovieListing.get(column)[5] = this.rating;
			 * MovieListing.get(column)[6] = this.time;
			 * File_IO.writeFile(MovieListing,path);
			 */
	}
	 
	 public static void removeMovie()
	 {
		 int no=0;
		 
		 System.out.println("Please choose one of the options:");
		 System.out.println("1) Delete by movie title");
		 System.out.println("2) Delete by movie ID");
		 no=scan.nextInt();
		 
		 switch(no) {
		 case 1: String MovieName="";
				 do {
					 System.out.println("Enter the name of the Movie: ");
					 try {
						 MovieName = scan.nextLine();
					 }
					 catch(NumberFormatException nfe) {
						 System.out.println("Please enter in string!");
					 }
					}while (MovieName.isEmpty());
					
				 MovieListing.deleteByName(MovieName);
				 break;
				 
		 case 2: String MovieID="";
				 do {
					 System.out.println("Enter the ID of the Movie: ");
					 try {
						 MovieID = scan.nextLine();
					 }
					 catch(NumberFormatException nfe) {
						 System.out.println("Please enter in string!");
					 }
					}while (MovieID.isEmpty());
					
				 MovieListing.deleteByID(MovieID);
				 break;
		default: System.out.println("Wrong options");
		 }	 
	 }
	 
	 public static void update() {
		 int no=0;
		 int index=-1;
		 String nam="";
		 System.out.println("Please choose one of the options:");
		 System.out.println("1) Update by movie title");
		 System.out.println("2) Update by movie ID");
		 no=scan.nextInt();
		 
		 switch(no) {
		 case 1: String MovieName="";
				 do {
					 System.out.println("Enter the name of the Movie: ");
					 try {
						 MovieName = scan.nextLine();
					 }
					 catch(NumberFormatException nfe) {
						 System.out.println("Please enter in string!");
					 }
					}while (MovieName.isEmpty());
				 index=MovieListing.getMovieIndexByTitle(MovieName);
					
				 break;
				 
		 case 2: String MovieID="";
				 do {
					 System.out.println("Enter the ID of the Movie: ");
					 try {
						 MovieID = scan.nextLine();
					 }
					 catch(NumberFormatException nfe) {
						 System.out.println("Please enter in string!");
					 }
					}while (MovieID.isEmpty());
				 index=MovieListing.getMovieIndexByID(MovieID);
				 if(index==-1) {
					 return;
				 }
				 break;
		default: System.out.println("Wrong options");
		 }	 
		 
	            	boolean x=true;
	            	while(x) {
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
	            		switch(choice) {
	            		case 1: System.out.println("Enter movie Name");
	            				String namee = scan.nextLine();
	            				MovieListing.getMovieList().get(index).setTitle(namee);
	            				MovieListing.save();
	            				break;
	            		case 2: System.out.println("Enter movie status");
        						String statuss = scan.nextLine();
        						ShowingStatus s = ShowingStatus.valueOf(statuss);
        						MovieListing.getMovieList().get(index).setStatus(s);
	            				MovieListing.save();
        						//movieCSV.get(i)[1]= statuss;
        						break;
	            		case 3:System.out.println("Enter movie synopsis");
        						String synopsiss = scan.nextLine();
        						MovieListing.getMovieList().get(index).setSynopsis(synopsiss);
	            				MovieListing.save();
        						//movieCSV.get(i)[2]= synopsiss;
        						break;
	            		case 4:System.out.println("Enter movie type");
        						String typee = scan.nextLine();
        						MovieListing.getMovieList().get(index).setType(typee);
	            				MovieListing.save();
        						//movieCSV.get(i)[3]= typee;
        						break;
	            		case 5:System.out.println("Enter movie director");
        						String directorr = scan.nextLine();
        						MovieListing.getMovieList().get(index).setDirector(directorr);
	            				MovieListing.save();
        						//movieCSV.get(i)[4]= directorr;
        						break;
	            		case 6:System.out.println("Enter movie cast");
        						String castt = scan.nextLine();
        						MovieListing.getMovieList().get(index).setCast(castt);
	            				MovieListing.save();
        						//movieCSV.get(i)[5]= castt;
        						break;
	            		case 7:System.out.println("Enter movie ratingg");
        						String ratingg = scan.nextLine();
        						MovieListing.getMovieList().get(index).setRating(ratingg);
	            				MovieListing.save();
        						//movieCSV.get(i)[6]= ratingg;
        						break;
	            		case 8: x=false;
	            			break;
	            		}

<<<<<<< HEAD
	            
	        }
=======

		  for(int h=0; h<ticketCSV.size(); h++){
		       String ticketID = ticketCSV.get(h)[0];
		       String movieID = ticketCSV.get(h)[1];
		       String dateTime = ticketCSV.get(h)[2];
		       String cinemaID = ticketCSV.get(h)[3];
		       String seatNo = ticketCSV.get(h)[4];
		       TypeOfTicket ticketType = TypeOfTicket.valueOf(ticketCSV.get(h)[5]);
		       Restriction restriction = Restriction.valueOf(ticketCSV.get(h)[6]);
		       
			   //Movie newMovie = new Movie(////);
			   //then MovieListing.add(newMovie);

			   //this is the part u update movie, u r touching ticket now instead
		       ticketList.add(new MovieTicket(ticketID, movieID, LocalDateTime.parse(dateTime,_DateTimeFormatter.formatter), cinemaID, seatNo, ticketType, restriction));
		   }
>>>>>>> ea7dd62be35da7d54521aa2c572167df1fa0bde8
		 
		 
	 }
	 public static void topFiveMovies()
	 {
		 int choice=0;
		 do {
			 System.out.println("Please choose one of the options");
			 System.out.println("1) Ranked by ticketSales");
			 System.out.println("2) Ranked by reviewers rating");
		 
			 try {
				 choice = scan.nextInt();
				 
			 }
			 catch(NumberFormatException nfe) {
				 System.out.println("Please enter a number!");
			 }
		 }while(choice>2 || choice<1);
		 

		 
		 if(choice ==1) {
			MovieController.showMovieByTicketSales();
		 }
		 if(choice ==2) {
			List<Movie> movieList = MovieController.showMovieByRating();
			
			for(int i = 0;i<movieList.size();i++){
				System.out.println(i+". "+movieList.get(i).getMovieTitle());
			}

		 }
	 }
	 public static void addShowTimes() {
			String movieID ="";
			String cinemaID ="";
			String startTime="";
			String endTime="";
			String classOfCinema="";
			String price = "";
			
			do {
			 System.out.println("Enter the ID of the Movie: ");
			 try {
				 movieID = scan.nextLine();
			 }
			 catch(NumberFormatException nfe) {
				 System.out.println("Please enter in string!");
			 }
			}while (movieID.isEmpty());
			
			 
			do {
				System.out.println("Enter the Cinema ID: ");
				 try {
					 cinemaID = scan.nextLine();
				 }
				 catch(NumberFormatException nfe) {
					 System.out.println("Please enter in string!");
				 }
				}while (cinemaID.isEmpty());
			
			do {
				System.out.println("Enter the startTime: ");
				 try {
					 startTime = scan.nextLine();
				 }
				 catch(NumberFormatException nfe) {
					 System.out.println("Please enter in string!");
				 }
				}while (startTime.isEmpty());
			 
			do {
				System.out.println("Enter the endTime of the movie: ");
				 try {
					 endTime = scan.nextLine();
				 }
				 catch(NumberFormatException nfe) {
					 System.out.println("Please enter in string!");
				 }
				}while (endTime.isEmpty());
			 
			do {
				System.out.println("Enter the class of cinema: ");
				 try {
					 classOfCinema = scan.nextLine();
				 }
				 catch(NumberFormatException nfe) {
					 System.out.println("Please enter in string!");
				 }
				}while (classOfCinema.isEmpty());
			
			do {
				System.out.println("Enter the price: ");
				 try {
					 price = scan.nextLine();
				 }
				 catch(NumberFormatException nfe) {
					 System.out.println("Please enter in string!");
				 }
				}while (price.isEmpty());
			ClassOfCinema CC = ClassOfCinema.valueOf(classOfCinema);
			double P = Double.valueOf(price);
			ShowTime ST = new ShowTime(movieID, cinemaID, startTime, endTime, CC, P);
			ShowTimeList.add(ST);
	 }
	 public static void removeShowTimes() {
		 int no=0;
		 
		 System.out.println("Please choose one of the options:");
		 System.out.println("1) Delete by movie index");
		 System.out.println("2) Delete by movie info");
		 no=scan.nextInt();
		 
		 switch(no) {
		 case 1: int index=-1;
				 do {
					 System.out.println("Enter the name of the Movie: ");
					 try {
						 index = scan.nextInt();
					 }
					 catch(NumberFormatException nfe) {
						 System.out.println("Please enter in integer!");
					 }
					}while (index<0);
					
				 ShowTimeList.deleteByIndex(index);
				 break;
				 
		 case 2: String movieID ="";
				String cinemaID ="";
				String startTime="";
				String endTime="";
				String classOfCinema="";
				String price = "";
				
				do {
				 System.out.println("Enter the ID of the Movie: ");
				 try {
					 movieID = scan.nextLine();
				 }
				 catch(NumberFormatException nfe) {
					 System.out.println("Please enter in string!");
				 }
				}while (movieID.isEmpty());
				
				 
				do {
					System.out.println("Enter the Cinema ID: ");
					 try {
						 cinemaID = scan.nextLine();
					 }
					 catch(NumberFormatException nfe) {
						 System.out.println("Please enter in string!");
					 }
					}while (cinemaID.isEmpty());
				
				do {
					System.out.println("Enter the startTime: ");
					 try {
						 startTime = scan.nextLine();
					 }
					 catch(NumberFormatException nfe) {
						 System.out.println("Please enter in string!");
					 }
					}while (startTime.isEmpty());
				 
				do {
					System.out.println("Enter the endTime of the movie: ");
					 try {
						 endTime = scan.nextLine();
					 }
					 catch(NumberFormatException nfe) {
						 System.out.println("Please enter in string!");
					 }
					}while (endTime.isEmpty());
				 
				
				
				ShowTimeList.deleteByMovieInfo(movieID, cinemaID, LocalDateTime.parse(startTime,_DateTimeFormatter.formatter), LocalDateTime.parse(endTime,_DateTimeFormatter.formatter));
		default: System.out.println("Wrong options");
		 }	 
	 }
}
