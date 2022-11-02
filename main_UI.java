import java.util.Scanner;

public class main_UI {

    public static void loadAllClass(){

        MovieListing.load();
        ReviewList.load();
        ShowTimeList.load();
        SeatBooked_Controller.load();
   
    }
    public static void main(String[] args) {
        loadAllClass();

        System.out.println("--Welcome to MOVIETICKETING SYSTEM--");
        System.out.println("1. Login");
        System.out.println("2. Continue as Guest");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                LoginUI test = new LoginUI();
                test.UI();
                break;
            case 2:
                StaffUI.UI();
                break;
        
            default:
                break;
        }
    }
}
