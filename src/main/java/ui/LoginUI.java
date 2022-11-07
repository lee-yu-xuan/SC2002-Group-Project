package src.main.java.ui;

import java.util.*;
import src.main.java.user.*;
import src.main.java.helper.*;

/**
 * Login User Interface.
 * @author Lester Lee
 * @version 1.0
 * @since 2022-11-01
 */
//input login interface for startup for the program
public class LoginUI {

    Scanner sc = new Scanner(System.in);
    public List<String[]> loginParticularCSV;
    private String username;
    private long password;

    /**
     * Default constructor for LoginUI.
     */
    // consturctor
    public LoginUI() {
    };

    /**
     * Display Login User Interface.
     * @return Detail of the user who has logged in.
     */
    // methods
    public String[] UI() {

        String[] success = new String[0];
        try {
            do {
                System.out.println("\n");
                System.out.println("Enter your Username: \t");
                username = sc.next().trim();
                System.out.println("Enter your Password: \t");
                password = new Hash().HashPassword(sc.next());
                // System.out.println("enter: " + username + " / " + String.valueOf(password));
                success = verify(username, password);
                if (success.length == 0) {
                    System.out.println("Login Fail, Please try again...");
                    continue;
                }
                return success;
            } while (success.length == 0);

        } catch (Exception e) {
            System.out.println("Error in LogIn UI\n");
        }
        return success;

    }

    /**
     * Private method to verify if the login particular entered by User is correct.
     * @param username Username entered by user.
     * @param password  Password entered by user.
     * @return Details of user upon sucessful log in.
     */
    private String[] verify(String username, long password) {
        try {
            loginParticularCSV = File_IO.readFile("loginParticular");
            for (String[] user : loginParticularCSV) {
                // for (int i = 0 ; i < user.length; i++){
                // System.out.print(user[i]);
                // }
                System.out.println();
                // System.out.println("db: " + user[1] + " / " + user[2]);
                if (user[1].equals(username) && user[2].equals(String.valueOf(password))) {
                    System.out.println("Login successful...");
                    return user;
                }
            }
            return new String[0];
        } catch (Exception e) {
            System.out.println("Error Verifying...");
            return new String[0];
        }
    }
}
