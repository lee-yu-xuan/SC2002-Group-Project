import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class movieBooking {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the movie booking system");
        System.out.println("Please select an action to begin with");
        System.out.println("1. View the list of movie");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Exit");

        int selection = sc.nextInt();

        switch (selection) {
            case 1: 
                movieController.viewMovieList();
                break;
            
            case 2:
                bookManager.bookTicket();
                break;

            default:
                break;
        }
    }
}
