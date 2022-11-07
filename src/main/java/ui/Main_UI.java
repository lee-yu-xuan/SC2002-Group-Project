package src.main.java.ui;

import java.util.Scanner;
import src.main.java.movie.*;
import src.main.java.payment.PromoCode;
import src.main.java.payment.PromoCodeList;
import src.main.java.booking.*;
import src.main.java.cinema.Cinema;
import src.main.java.cinema.CinemaController;
import src.main.java.sysconfig.*;
import src.main.java.helper.*;

/**
 * Main Application User Interface.
 * @author Lester Lee
 * @version 1.0
 * @since 2022-11-01
 */
public class Main_UI {

    /**
     * Load all the necessary information pirior to Application start up.
     */
    public static void loadAllClass() {
        MovieListing.load();
        ReviewList.load();
        ShowTimeList.load();
        SeatBooked_Controller.load();
        MovieTicketController.load();
        SalesManager.load();
        Holiday.load();
        CinemaController.load();
        SystemConfigController.load();
        PromoCodeList.load();
    }

    /**
     * Unload and save all the necessary information before closing program.
     */
    public static void saveAllClass() {
        MovieListing.save();
        ReviewList.save();
        ShowTimeList.save();
        SeatBooked_Controller.save();
        MovieTicketController.save();
        SalesManager.save();
        Holiday.save();
        CinemaController.save();
        SystemConfigController.save();
        PromoCodeList.save();
    }

    /**
     * Display the main application user interface.
     */
    public static void main(String[] args) {
        // get current DateTime for booking history
        // if havent pass current DateTime, display under upcoming
        // if passed, display under history
        // this implementation has not been done yet

        // DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        // Calendar cal = Calendar.getInstance();
        // System.out.println(dateFormat.format(cal.getTime()));

        loadAllClass();
        ShowTimeController.refresh();
        boolean quit = false;
        while (!quit) {
            System.out.println("\n");
            System.out.println("--Welcome to MovieTickeing Application--");
            System.out.println("1. Login");
            System.out.println("2. Continue as Guest");
            System.out.println("3. Register new User");
            System.out.println("4. Quit Application");
            System.out.println("----------------------------------------");

            int choice = ExceptionHandling.IntegerScannerRangeOfFunction(4);
            String userName = "";

            switch (choice) {
                case 1:
                    LoginUI test = new LoginUI();
                    // 1 - MOVIEGOER, 0 - STAFF
                    String[] userStringArr = test.UI();

                    if (userStringArr[3].equals("MOVIEGOER")) {
                        userName = userStringArr[0];
                        BookingManager.load(userName);
                        User_UI.display_UI(userName);
                        BookingManager.save(userName);
                    } else if (userStringArr[3].equals("STAFF")) {
                        StaffUI.UI();
                    }
                    break;

                case 2:
                    User_UI.display_UI("Guest");
                    break;

                case 3:
                    RegistrationUI.UI();
                    break;

                case 4:
                    System.out.println("Thank you for using our application!");
                    quit = true;
                    break;

                default:
                    break;
            }
        }

        // save all instances
        saveAllClass();
    }
}

/*
 * 
 * Start With:
 * S - Normal
 * X - ThreeD
 * W - Premium
 * 
 * End With:
 * 01 - PG
 * 02 - PG13
 * 03 - R21
 * 
 */