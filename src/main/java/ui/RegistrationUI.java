import java.util.*;

public class RegistrationUI {
    private static String name;
    private static String password;
    private static String username;
    private static char type;

    public static void UI() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Register a new user...");
        System.out.println("Enter your name: ");
        name = sc.nextLine();
        System.out.println("Enter your username (used in login): ");
        username = sc.nextLine();
        System.out.println("Enter your password: ");
        password = sc.nextLine();
        System.out.println("Are you a MOVIEGOER (y/n)?");
        type = sc.next().charAt(0);

        Registration reg = new Registration(name, username, password,
                (type == 'y') ? UserType.MOVIEGOER : UserType.STAFF);
        reg.Register();
    }
}
