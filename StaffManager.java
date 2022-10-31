import java.util.List;
import java.util.Scanner;

import constructUser.userType;

public class StaffManager {
	
	List<String[]> movie = new ArrayList<String[]>;
	Scanner scan = new Scanner(System.in);
	 
	 public void addMovie()
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
	 
	 public void removeMovie()
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
	 public void topFiveMovies()
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
			 //MC.showMovieByTicketSales();
		 }
		 if(choice ==2) {
			MovieController.showMovieByRating();
		 }
	 }
}
