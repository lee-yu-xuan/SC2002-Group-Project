
//Lester
import java.util.*;
import java.io.*;
import java.nio.file.*;

//input login interface for startup for the program
public class LoginUI {

    String cwdStr = Paths.get("").toAbsolutePath().toString();
    Scanner sc = new Scanner(System.in);
    private String username;
    private long password;

    // consturctor
    public LoginUI() {
    };

    // methods
    public void UI() {

        try {
            boolean success = false;
            do {
                System.out.println("Enter your Username: \t");
                username = sc.next().trim();
                System.out.println("Enter your Password: \t");
                password = new Hash().HashPassword(sc.next());
                success = verify(Paths.get(cwdStr + "\\CSV\\loginParticular.csv"), username, password);
                if (!success)
                    System.out.println("Login Fail, Please try again...");
            } while (!success);
        } catch (Exception e) {
            System.out.println("Error in LogIn UI\n");
        }

    }

    private boolean verify(Path csv, String username, long password) {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(cwdStr + "\\CSV\\loginParticular.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] strArr = line.split(",");
                if (strArr[1].equals(username) && strArr[2].equals(String.valueOf(password)))
                    return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Error Verifying...");
            return false;
        }
    }

    public static void main(String[] args) {
        LoginUI test = new LoginUI();
        test.UI();
    }
}
