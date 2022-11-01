import java.util.Scanner;

public class User_UI {

    public static void display_UI(){
    //display all options
    System.out.println("---Welcome to MOVIETICKETING SYSTEM---");
    System.out.println("1. List the Movies");
    System.out.println("2. View Booking History");
    System.out.println("3. Exit");
    Scanner sc = new Scanner(System.in);
    int choice = sc.nextInt();

    switch (choice) {
        case 1:
            //list the movies
            DisplayMovie_UI.displayInformation();
            break;
        case 2:
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
    }
}
