import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class BuyTicket_UI {
    public static void purchaseTicket(String movieID, String userName){
        List<ShowTime> tmp = ShowTimeController.showTimeByShowTime(movieID);
            for(int i = 0;i<tmp.size();i++){
                System.out.println(i+". "+tmp.get(i).getCinemaID()+" "+tmp.get(i).getStartTime());
            }
        
        //user select cinema and timing
        System.out.println("Select your preferred cinema and timing");
        Scanner sc = new Scanner(System.in);
        int choice=0;
        choice = sc.nextInt();
        String cinemaID = tmp.get(choice).getCinemaID();
        LocalDateTime time = tmp.get(choice).getStartTime();
  
        //pass time, and cinema to displayLayout_UI   
        LayoutController.displayLayout(cinemaID, time);

        System.out.println("Select the row of your preferred seat");
        int row = sc.nextInt();
        System.out.println("Select the column of your preferred seat");
        int col = sc.nextInt();

        //after calling payment UI, call this to update the seat
        SeatBooked_Controller.updateSeatBooked(row, col, cinemaID, time);
  
        //call a method to create a movieTicket
        String ticketID = row+cinemaID+col+movieID;
        String seat = Integer.toString((row*10)+col);

        TypeOfTicket ticketType = TypeOfTicket.Normal;
        //check movieID for the ticketType
        if(movieID.charAt(0)=='S'){
            ticketType = TypeOfTicket.Normal;
        }
        else if(movieID.charAt(0)=='T'){
            ticketType = TypeOfTicket.ThreeD;
        }
        else if(movieID.charAt(0)=='P'){
            ticketType = TypeOfTicket.Premium;
        }

        Restriction restriction = Restriction.PG;
        //check movieID for the restriction
        if(movieID.charAt(4)=='1'){
            restriction = Restriction.PG;
        }
        else if(movieID.charAt(4)=='2'){
            restriction = Restriction.PG13;
        }
        else if(movieID.charAt(4)=='3'){
            restriction = Restriction.R21;
        }
        // pass price arguments
        new Price(time, "20", 1, SystemConfigController.getClassMulti(tmp.get(choice).getClassOfCinema().toString()));

        //call payment method
        double priceInDouble = Payment_UI.display_UI(userName, ticketID);
        String fare = Double.toString(priceInDouble);

        MovieTicket ticket = new MovieTicket(ticketID, movieID, time, cinemaID, seat, ticketType, restriction);
        MovieTicketController.add(ticket);

        //increment sales
        SalesManager.addSalesByID(movieID);

        //call a method to add to booking history of the user
        Booking booking = new Booking(ticketID, userName, movieID, cinemaID, "1", seat, fare);
        BookingManager.addBooking(booking);
        System.out.println("Booking successful");
    }
}
