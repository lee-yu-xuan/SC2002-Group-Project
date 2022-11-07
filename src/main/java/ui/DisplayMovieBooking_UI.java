package src.main.java.ui;

import java.util.List;
import java.util.Scanner;
import src.main.java.movie.*;
import src.main.java.helper.*;

public class DisplayMovieBooking_UI {
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

    public static String listBySales(){
        //list top 5 movies by sales
        List<Movie> movieList = MovieController.showAvailableMovieByTicketSales();
        for(int i = 0;i<movieList.size();i++){
            System.out.println((i+1) + ". "+movieList.get(i).getMovieTitle());

        }

        //select movie
        Scanner sc = new Scanner(System.in);
        int option = ExceptionHandling.IntegerScannerRangeOfFunction(movieList.size());
        String movieID = movieList.get(option-1).getMovieID();

        return movieID;
    }

    public static String listByRating(){
        //list top 5 movies by rating
        List<Movie> movieList = MovieController.showAvailableMovieByRating();
        for(int i = 0;i<movieList.size();i++){
            System.out.println((i+1) +". "+movieList.get(i).getMovieTitle());
        }

        //select movie
        Scanner sc = new Scanner(System.in);
        int option = ExceptionHandling.IntegerScannerRangeOfFunction(movieList.size());
        String movieID = movieList.get(option-1).getMovieID();

        return movieID;
    }
}
