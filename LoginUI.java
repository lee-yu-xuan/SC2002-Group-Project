
//Lester
import java.util.*;

//input login interface for startup for the program
public class LoginUI {

    Scanner sc = new Scanner(System.in);
    public List<String[]> loginParticularCSV;
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
                // System.out.println("enter: " + username + " / " + String.valueOf(password));
                success = verify(username, password);
                if (!success)
                    System.out.println("Login Fail, Please try again...");
            } while (!success);
        } catch (Exception e) {
            System.out.println("Error in LogIn UI\n");
        }

    }

    private boolean verify(String username, long password) {
        try {
            loginParticularCSV = File_IO.readFile("loginParticular");
            for (String[] user : loginParticularCSV){
            //     for (int i = 0 ; i < user.length; i++){
            //         System.out.print(user[i]);
            //     }
                System.out.println();
                //System.out.println("db: " + user[1] + " / " + user[2]);
                if (user[1].equals(username) && user[2].equals(String.valueOf(password))) return true;
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

        //load all class
        //classLoader loader = new classLoader();
        //loader.load();

        //if user go user_UI
        //if staff go staff_UI
        MovieListing.load();
        ReviewList.load();
        ShowTimeList.load();
        SeatBooked_Controller.load();
        MovieListing.load();

        User_UI.display_UI();
    }
}
