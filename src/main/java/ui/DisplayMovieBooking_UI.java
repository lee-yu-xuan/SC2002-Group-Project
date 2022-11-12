package src.main.java.ui;

import java.util.List;
import java.util.Scanner;
import src.main.java.movie.*;
import src.main.java.helper.*;

/**
 * User Interface for Movie Booking.
 * @author Lester Lee
 * @version 1.0
 * @since 2022-11-01
 */
public class DisplayMovieBooking_UI {
    /**
     * Display user interface for MovieBooking.
     * @param userName username of the user.
     */
    public static void displayInformation(String userName) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n");
        System.out.println("1. List top 5 movies by sales");
        System.out.println("2. List top 5 movies by rating");
        System.out.println("3. Search by movie title");

        int choice = ExceptionHandling.IntegerScannerRangeOfFunction(3);
        String movieID = "";

        if(choice==3){
                Scanner stringScanner = new Scanner(System.in).useDelimiter("\n");
                System.out.println("Enter movie title: ");
                String movieTitle = stringScanner.nextLine();
                movieID = MovieListing.getAvailableMovieID(movieTitle);
            
            if(movieID == null){
                System.out.println("Movie not found");
                return;
            }
        }
        else{
            switch (choice) {
                case 1:
                    //list top 5 movies by sales
                    movieID = listBySales();
                    break;
                case 2:
                    //list top 5 movies by rating
                    movieID = listByRating();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        BuyTicket_UI.purchaseTicket(movieID, userName);
    }

    /**
     * Arrange the movie by Sales.
     * @return MovieID that is selected.
     */
    public static String listBySales(){
        //list top 5 movies by sales
        List<Movie> movieList = MovieController.showAvailableMovieByTicketSales();
        System.out.println("\nMovies");
        System.out.println("--------------------");
        int size = 5;
        if(movieList.size()>5) size = 5;
        else size = movieList.size();

        for(int i = 0;i<size;i++){
            System.out.println((i+1) + ". "+movieList.get(i).getMovieTitle());
        }

        //select movie
        Scanner sc = new Scanner(System.in);
        int option = ExceptionHandling.IntegerScannerRangeOfFunction(movieList.size());
        String movieID = movieList.get(option-1).getMovieID();

        return movieID;
    }

    /**
     * Arrange the movie by Ratings.
     * @return MovieID that is selected.
     */
    public static String listByRating(){
        //list top 5 movies by rating
        List<Movie> movieList = MovieController.showAvailableMovieByRating();
        System.out.println("\nMovies");
        System.out.println("--------------------");
        int size = 5;
        if(movieList.size()>5) size = 5;
        else size = movieList.size();
        
        for(int i = 0;i<size;i++){
            System.out.println((i+1) +". "+movieList.get(i).getMovieTitle());
        }

        //select movie
        Scanner sc = new Scanner(System.in);
        int option = ExceptionHandling.IntegerScannerRangeOfFunction(movieList.size());
        String movieID = movieList.get(option-1).getMovieID();

        return movieID;
    }
}
