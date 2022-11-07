package src.main.java.user;

import java.util.*;
import src.main.java.enums.*;
import src.main.java.helper.*;

/**
 * Regsitration Class to create an account and update particular to database.
 * @author Lester Lee
 * @version 1.0
 * @since 2022-11-01
 */
public class Registration extends ConstructUser {

    /**
     * List of all the valid login information.
     */
    public List<String[]> loginParticularCSV;

    /**
     * Constructor for Registration for a newly registered user.
     * @param name User's name.
     * @param username User's username.
     * @param password User's password.
     * @param usertype User's type.
     */
    public Registration(String name, String username, String password, UserType usertype) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.type = usertype;
    }

    /**
     * Save user's information to database.
     */
    public void Register() {
        // Hash the password, store the password into CSV pegged to the other
        // particulars
        Hash hashFunction = new Hash();
        long hashPass = hashFunction.HashPassword(password);

        // read CSV and add to last line of CSV
        try {
            loginParticularCSV = File_IO.readFile("loginParticular");
            String[] temp = { name, username, String.valueOf(hashPass), type.toString() };
            loginParticularCSV.add(temp);
            File_IO.writeFile(loginParticularCSV, "loginParticular");
        } catch (Exception e) {
            System.out.println("registration fail, please try again!");
        }
        System.out.println("Registration completed! Welcome.");

    }

    // public static void main(String[] args) {
    //     Registration test = new Registration("ben", "tang", "BenTang", userType.MOVIEGOER);
    //     Registration test = new Registration("staff1", "staff1", "staffpass", userType.STAFF);
    //     Registration test = new Registration("les", "ter", "password", userType.MOVIEGOER);
    //     test.Register();
    // }

}
