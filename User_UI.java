import java.util.List;
import java.util.Scanner;

public class User_UI {

    public static void display_UI(String userName){
    //display all options
    int choice;
    do{
        System.out.println("\n");
        System.out.println("---Welcome to MOVIETICKETING SYSTEM---");
        System.out.println("1. List the Movies");
        System.out.println("2. View Booking History");
        System.out.println("3. Exit");
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                //list the movies
                DisplayMovie_UI.displayInformation(userName);
                break;
            case 2:
                List<Booking> bookingHistory = BookingManager.getBookingHistory();
                if(bookingHistory!=null){
                    for(int i=0 ; i<bookingHistory.size(); i++){
                        System.out.println("Movie Name:"+MovieListing.getMovieName(bookingHistory.get(i).getmovieID())+"\t"+"TicketID: "+bookingHistory.get(i).getTicketID());
                        System.out.println("Your seat number is: "+bookingHistory.get(i).getSeats());
                    }
                }
                //view booking history
                //DisplayBookingHistory_UI.displayInformation();
                break;
            case 3:
                //exit
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }while(choice > 0 || choice < 3);
    }
}
