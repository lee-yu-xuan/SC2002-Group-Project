
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
    public int UI() {

        try {
            int success = -1;
            do {
                System.out.println("Enter your Username: \t");
                username = sc.next().trim();
                System.out.println("Enter your Password: \t");
                password = new Hash().HashPassword(sc.next());
                // System.out.println("enter: " + username + " / " + String.valueOf(password));
                success = verify(username, password);
                if (success == -1)
                    System.out.println("Login Fail, Please try again...");
                return success;
            } while (success == -1);

        } catch (Exception e) {
            System.out.println("Error in LogIn UI\n");
            return -1;
        }

    }

    private int verify(String username, long password) {
        try {
            loginParticularCSV = File_IO.readFile("loginParticular");
            for (String[] user : loginParticularCSV){
            //     for (int i = 0 ; i < user.length; i++){
            //         System.out.print(user[i]);
            //     }
                System.out.println();
                //System.out.println("db: " + user[1] + " / " + user[2]);
                if (user[1].equals(username) && user[2].equals(String.valueOf(password)))
                {
                    System.out.println("Login successful...");
                    System.out.println(user[3]);
                    if (user[3].equals("MOVIEGOER")) return 1;
                    else return 0;
                }
            }
            return -1;
        } catch (Exception e) {
            System.out.println("Error Verifying...");
            return -1;
        }
    }
}
