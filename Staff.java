package OODP;

import java.util.List;
import java.util.*;

public class Staff extends constructUser
{ 
	Scanner scan = new Scanner(System.in);
	MovieController MC = new MovieController();
	 public Staff(String name, String username, String password)
	 {
		 this.type = userType.STAFF;
		 this.name = name;
		 this.username = username;
		 this.password = password;
	 }
	 public void addMovie()
	{
		String MovieName="";
		String Enum="Coming Soon";
		String Synopsis = "";
		String Director = "";
		String Cast = "";
		String Rating = "NA";
		String reviews = "";
		String time="";
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
			}while (Director.isEmpty());
		 
		
		do {
			System.out.println("Enter the reviews: ");
			 try {
				 reviews = scan.nextLine();
			 }
			 catch(NumberFormatException nfe) {
				 System.out.println("Please enter in string!");
			 }
			}while (reviews.isEmpty());
		
		do {
			System.out.println("Enter the showing time: ");
			 try {
				 time = scan.nextLine();
			 }
			 catch(NumberFormatException nfe) {
				 System.out.println("Please enter in string!");
			 }
			}while (time.isEmpty());
		 
			//MC.add(String MovieName, Enum status, String Synopsis,String director,String Cast,double rating, String reviews); 
		 
		String path = "/MovieListing/" + this.name;
		List<String[]> MovieListing = File_IO.readFile(path);
		int column = MovieListing.size();
		MovieListing.get(column)[0] = this.MovieName;
		MovieListing.get(column)[1] = this.Enum;
		MovieListing.get(column)[2] = this.Synopsis;
		MovieListing.get(column)[3] = this.director;
		MovieListing.get(column)[4] = this.cast;
		MovieListing.get(column)[5] = this.rating;
		MovieListing.get(column)[6] = this.time;
		File_IO.writeFile(MovieListing,path);		
		 
	}
	 
	 public void removeMovie()
	 {
		 //MC.changeState();
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
			 //MC.showMovieByRating();
		 }
	 }
}