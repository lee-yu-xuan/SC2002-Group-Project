package src.main.java.ui;

import java.util.List;
import java.util.Scanner;
import src.main.java.booking.*;
import src.main.java.movie.*;
import src.main.java.sysconfig.*;
import src.main.java.helper.*;

public class User_UI {
    public static void display_UI(String userName){
    //display all options
    int choice;
    do{
        System.out.println("\n");
        System.out.println("---Welcome to Our User application---");
        System.out.println("1. List the Movies");
        System.out.println("2. Book Tickets");
        System.out.println("3. View Booking History");
        System.out.println("4. Exit");
        System.out.println("-------------------------------------");
        choice = ExceptionHandling.IntegerScannerRangeOfFunction(4);
        switch (choice) {
            case 1:
                DisplayMovie_UI.displayInformation(userName);
                break;
            case 2:
                DisplayMovieBooking_UI.displayInformation(userName);
                break;
            case 3:
                if(userName=="Guest"){
                    System.out.println("You are not logged in. Please login to view your booking history.");
                }
                else{
                    List<Booking> bookingHistory = BookingManager.getBookingHistory();
                if(bookingHistory!=null){
                     //show upcoming booking
                     List<Booking> upcomingBooking = BookingManager.showUpcomingBooking();
                     if(upcomingBooking==null){
                         System.out.println("\nYou have no upcoming booking");
                     }else{
                         System.out.println("Your upcoming booking:");
                         for(int i=0; i<upcomingBooking.size(); i++){
                             System.out.println("You have a movie: "+MovieListing.getMovieName(upcomingBooking.get(i).getmovieID())+" at "+upcomingBooking.get(i).getDateTime()+" and your seat number is "+upcomingBooking.get(i).getSeats());
                         }
                     }
                     System.out.println("\n");
                     //show expired tickets
                     List<Booking> pastBooking = BookingManager.showPastBooking();
                     if(pastBooking==null){
                         System.out.println("You have no past booking");
                     }else{
                         System.out.println("Your past booking:");
                         for(int i=0; i<pastBooking.size(); i++){
                             System.out.println("You have a movie: "+MovieListing.getMovieName(pastBooking.get(i).getmovieID())+" at "+pastBooking.get(i).getDateTime()+" and your seat number is "+pastBooking.get(i).getSeats());
                         }
                     }
                    }else{
                        System.out.println("You have not done any booking yet");
                    }
                    
                
                    break;
                }
                
                    case 4:
                    System.out.println("Thank you for using our application!");
                    return;

                    default:
                    System.out.println("Invalid choice");
                    break;
        }
    }while(choice > 0 || choice < 4);
    }
}