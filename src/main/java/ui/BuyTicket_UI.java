package src.main.java.ui;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import src.main.java.movie.*;
import src.main.java.booking.*;
import src.main.java.cinema.CinemaController;
import src.main.java.enums.*;
import src.main.java.helper.ExceptionHandling;
import src.main.java.sysconfig.*;

/**
 * User interface for purchase of Ticket.
 * 
 * @author Lester Lee
 * @version 1.0
 * @since 2022-11-01
 */
public class BuyTicket_UI {
    /**
     * Display the user interface to buy tickets.
     * 
     * @param movieID  ID for chosen Movie.
     * @param userName Username of the user.
     */
    public static void purchaseTicket(String movieID, String userName) {
        Scanner sc = new Scanner(System.in);
        List<ShowTime> tmp = ShowTimeController.showTimeByShowTime(movieID);
        System.out.println("\nShowtimes");
        System.out.println("--------------------");
        for (int i = 0; i < tmp.size(); i++) {
            System.out.println((i + 1) + ". " + tmp.get(i).getCinemaID() + " " + tmp.get(i).getStartTime());
        }

        // user select cinema and timing
        System.out.println("Select your preferred cinema and timing");

        int choice = 0;
        choice = ExceptionHandling.IntegerScannerRangeOfFunction(tmp.size()) - 1;
        String cinemaID = tmp.get(choice).getCinemaID();
        LocalDateTime time = tmp.get(choice).getStartTime();

        // pass time, and cinema to displayLayout_UI
        LayoutController.displayLayout(cinemaID, time);

        boolean duplicateSeat = true;
        int row = 0;
        int col = 0;
        while (duplicateSeat == true) {
            System.out.println("*Note that the first 2 rows will have a price deduction of $2");
            System.out.println("Select the row of your preferred seat");
            String[] rowColumn = CinemaController.checklayout(cinemaID);
            int rowUpperbound = Integer.parseInt(rowColumn[0]);
            int columnUpperbound = Integer.parseInt(rowColumn[1]);
            row = ExceptionHandling.IntegerScannerRangeOfFunction(rowUpperbound);
            System.out.println("Select the column of your preferred seat");
            col = ExceptionHandling.IntegerScannerRangeOfFunction(columnUpperbound);
            duplicateSeat = LayoutController.checkIfDuplicateSeats(row, col, cinemaID, time);
            System.out.println("\n");
            if (duplicateSeat == true)
                System.out.println("Seat is taken, please choose another seat");
        }

        // after calling payment UI, call this to update the seat
        SeatBooked_Controller.updateSeatBooked(row, col, cinemaID, time);

        // call a method to create a movieTicket
        String ticketID = row + cinemaID + col + movieID;
        String seat = Integer.toString((row * 10) + col);

        TypeOfTicket ticketType = TypeOfTicket.Normal;
        // check movieID for the ticketType
        if (movieID.charAt(0) == 'S') {
            ticketType = TypeOfTicket.Normal;
        } else if (movieID.charAt(0) == 'T') {
            ticketType = TypeOfTicket.ThreeD;
        } else if (movieID.charAt(0) == 'P') {
            ticketType = TypeOfTicket.Premium;
        }

        Restriction restriction = Restriction.PG;
        // check movieID for the restriction
        if (movieID.charAt(4) == '1') {
            restriction = Restriction.PG;
        } else if (movieID.charAt(4) == '2') {
            restriction = Restriction.PG13;
        } else if (movieID.charAt(4) == '3') {
            restriction = Restriction.R21;
        }
    
        // pass price arguments
        // get the movieGoer's age since he/she might be booking for another person
        System.out.println("Please enter the age of the movieGoer");
        String age = ExceptionHandling.checkForAlphabet(2);
        new Price(time, age, 1, SystemConfigController.getClassMulti(tmp.get(choice).getClassOfCinema().toString()),
                row);

        // call payment method
        double priceInDouble = Payment_UI.display_UI(userName, ticketID);
        String fare = Double.toString(priceInDouble);

        MovieTicket ticket = new MovieTicket(ticketID, movieID, time, cinemaID, seat, ticketType, restriction);
        MovieTicketController.add(ticket);

        // increment sales
        SalesManager.addSalesByID(movieID);

        // call a method to add to booking history of the user
        Booking booking = new Booking(ticketID, userName, movieID, cinemaID, "1", seat, fare, time);
        BookingManager.addBooking(booking);
        System.out.println("Booking successful");
        BookingManager.save(userName);
    }
}
