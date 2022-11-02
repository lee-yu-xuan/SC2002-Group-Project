import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class DisplayMovie_UI {
    public static void displayInformation(){
        Scanner sc = new Scanner(System.in);
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

        //call payment method
        


        //after calling payment UI, call this to update the seat
        SeatBooked_Controller.updateSeatBooked(row, col, cinemaID, time);
        SeatBooked_Controller.save();
        //call a method to create a movieTicket
        String ticketID = row+cinemaID+col+movieID;
        String seat = Integer.toString((row*10)+col);
        MovieTicket ticket = new MovieTicket(ticketID, movieID, time, cinemaID, seat, TypeOfTicket.Flat, Restriction.PG13);
        MovieTicketController.add(ticket);
        MovieTicketController.save();
        
        
        String costs = "10";

        //call a method to add to booking history of the user which i dont know who doing
        Booking booking = new Booking(ticketID, name, movieID, cinemaID, "1", seat, costs);

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

    //working example
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
