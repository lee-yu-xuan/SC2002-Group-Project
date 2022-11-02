import java.util.Scanner;

public class main_UI {

    public static void loadAllClass(){
        MovieListing.load();
        ReviewList.load();
        ShowTimeList.load();
        SeatBooked_Controller.load();
        MovieTicketController.load();
    }

    public static void saveAllClass(){
        MovieListing.save();
        ReviewList.save();
        ShowTimeList.save();
        SeatBooked_Controller.save();
        MovieTicketController.save();
    }

    public static void main(String[] args) {
        //loadAllClass();
        loadAllClass();
        System.out.println("--Welcome to MOVIETICKETING SYSTEM--");
        System.out.println("1. Login");
        System.out.println("2. Continue as Guest");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        String userName = "";

        switch (choice) {
            case 1:
                LoginUI test = new LoginUI();
                // 1 - MOVIEGOER, 0 - STAFF
                String[] userStringArr = test.UI();
                System.out.println(userStringArr);
                
                if(userStringArr[3].equals("MOVIEGOER")){
                    userName = userStringArr[0];
                    BookingManager.load(userName);
                    User_UI.display_UI(userName);
                }
                else if(userStringArr[3].equals("STAFF")){
                    //staffUI.UI();
                }


                //for (int i = 0 ; i < userStringArr.length; i++){
                //System.out.print(userStringArr[i]);
                //}
                break;
            case 2:
                StaffUI.UI();
                break;

            default:
                break;
        }

        //save all instances
        saveAllClass();
        BookingManager.save(userName);
    }
}

/*

Start With:
S - Normal
X - ThreeD
W - Premium

End With:
01 - PG
02 - PG13
03 - R21 
 
 */