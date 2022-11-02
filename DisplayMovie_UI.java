import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class DisplayMovie_UI {
    public static void displayInformation(String userName) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("1. List top 5 movies by sales");
        System.out.println("2. List top 5 movies by rating");
        System.out.println("3. Search by movie title");

        int choice = sc.nextInt();
        String movieID = "";

        if(choice==3){
            System.out.println("Enter movie title: ");
            String movieTitle = sc.nextLine();
            movieID = MovieListing.getMovieID(movieTitle);
            if(movieID == null){
                System.out.println("Movie not found");
                return;
            }
        }
        else{
            switch (choice) {
                case 1:
                    //list top 5 movies by sales
                    movieID = listBySales();
                    break;
                case 2:
                    //list top 5 movies by rating
                    movieID = listByRating();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }

        List<ShowTime> tmp = ShowTimeController.showTimeByShowTime(movieID);
            for(int i = 0;i<tmp.size();i++){
                System.out.println(i+". "+tmp.get(i).getCinemaID()+" "+tmp.get(i).getStartTime());
            }
        
        //user select cinema and timing
        System.out.println("Select your preferred cinema and timing");
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
        
        //call payment method
        Payment_UI.display_UI(userName, ticketID);

        MovieTicket ticket = new MovieTicket(ticketID, movieID, time, cinemaID, seat, ticketType, restriction);
        MovieTicketController.add(ticket);

        //increment sales
        SalesManager.addSalesByID(movieID);

        //call a method to add to booking history of the user
        Booking booking = new Booking(ticketID, userName, movieID, cinemaID, "1", seat, "4");
        BookingManager.addBooking(booking);
        System.out.println("Booking successful");

    }

    public static String listBySales(){
        //list top 5 movies by sales
        List<Movie> movieList = MovieController.showMovieByTicketSales();
        for(int i = 0;i<movieList.size();i++){
            System.out.println(i+". "+movieList.get(i).getMovieTitle());
        }

        //select movie
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        String movieID = movieList.get(option).getMovieID();

        return movieID;
    }

    public static String listByRating(){
        //list top 5 movies by rating
        List<Movie> movieList = MovieController.showMovieByRating();
        for(int i = 0;i<movieList.size();i++){
            System.out.println(i+". "+movieList.get(i).getMovieTitle());
        }

        //select movie
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        String movieID = movieList.get(option).getMovieID();

        return movieID;
    }

  
}
