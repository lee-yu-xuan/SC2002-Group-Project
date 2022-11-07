package src.main.java.ui;

import java.util.*;
import src.main.java.user.*;
import src.main.java.enums.*;
import src.main.java.helper.*;

public class RegistrationUI {
    private static String name;
    private static String password;
    private static String username;
    private static char type;

    public static void UI() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Register a new user...");
        System.out.println("Enter your name: ");
        name = ExceptionHandling.StringScanner();
        System.out.println("Enter your username (used in login): ");
        username = ExceptionHandling.StringScanner();
        System.out.println("Enter your password: ");
        password = ExceptionHandling.StringScanner();
        System.out.println("Are you a MOVIEGOER (y/n)?");
        type = sc.next().charAt(0);

        Registration reg = new Registration(name, username, password,
                (type == 'y') ? UserType.MOVIEGOER : UserType.STAFF);
        reg.Register();
    }
}
