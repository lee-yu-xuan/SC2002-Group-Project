package src.main.java.ui;

import java.util.List;
import java.util.Scanner;
import src.main.java.movie.*;
import src.main.java.helper.*;

/**
 * User Interface for Movie.
 * @author Lester Lee
 * @version 1.0
 * @since 2022-11-01
 */
public class DisplayMovie_UI {
    /**
     * Display user interface to show movie particular.
     * @param userName Username of user.
     */
    public static void displayInformation(String userName) {
       
        System.out.println("\n");
        System.out.println("1. List top 5 movies by sales");
        System.out.println("2. List top 5 movies by rating");
        System.out.println("3. Search by movie title");

        int choice = ExceptionHandling.IntegerScannerRangeOfFunction(3);
        String movieID = "";

        if(choice==3){
                Scanner stringScanner = new Scanner(System.in).useDelimiter("\n");
                System.out.println("Enter movie title: ");
                String movieTitle = stringScanner.nextLine();
                movieID = MovieListing.getMovieID(movieTitle);
            
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

        System.out.println("1. View movie details");
        System.out.println("2. Add ratings and reviews");
        //System.out.println("3. Book tickets");

        int choice2 = ExceptionHandling.IntegerScannerRangeOfFunction(2);

        switch (choice2) {
            case 1:
                //view movie details
                MovieListing.getMovieDetails(movieID);
                break;
            case 2:
                //add ratings and reviews
                Review_UI.display_UI(movieID);
                break;
            /** 
            case 3:
                //book tickets
                BuyTicket_UI.purchaseTicket(movieID, userName);
                break;
            */
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
    /**
     * Arrange the movie by Sales.
     * @return MovieID that is selected.
     */
    public static String listBySales(){
        //list top 5 movies by sales
        List<Movie> movieList = MovieController.showMovieByTicketSales();
        System.out.print( "\n\n\n" );
        int size = 5;
        if(movieList.size()>5) size = 5;
        else size = movieList.size();

        for(int i = 0;i<size;i++){
            System.out.println((i+1) + ". "+movieList.get(i).getMovieTitle());
        }

        //select movie
     
        int option = ExceptionHandling.IntegerScannerRangeOfFunction(movieList.size());
        String movieID = movieList.get(option-1).getMovieID();

        return movieID;
    }

    /**
     * Arrange the movie by Ratings.
     * @return The MovieID that is selected.
     */
    public static String listByRating(){
        //list top 5 movies by rating
        List<Movie> movieList = MovieController.showMovieByRating();
        System.out.print( "\n\n\n" );
        int size = 5;
        if(movieList.size()>5) size = 5;
        else size = movieList.size();
        
        for(int i = 0;i<size;i++){
            System.out.println((i+1) +". "+movieList.get(i).getMovieTitle());
        }

        //select movie
        
        int option = ExceptionHandling.IntegerScannerRangeOfFunction(movieList.size());
        String movieID = movieList.get(option-1).getMovieID();

        return movieID;
    }

  
}
