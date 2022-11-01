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

        switch (choice) {
            case 1:
                //list top 5 movies by sales
                movieID = listBySales();
                break;
            case 2:
                //list top 5 movies by rating
                movieID = listByRating();
                break;
            case 3:
                //search by movie title
                movieID = searchByTitle();
                break;
            default:
                System.out.println("Invalid choice");
                break;
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
        int row = sc.next().charAt(0);
        System.out.println("Select the column of your preferred seat");
        int col = sc.nextInt();

        //call payment method

        //after calling payment UI, call this to update the seat
        SeatBooked_Controller.updateSeatBooked(row, col, cinemaID, time);

        //call a method to create a movieTicket
        String ticketID = row+cinemaID+col+movieID;
        String seat = Integer.toString(row+col);
        MovieTicket ticket = new MovieTicket(ticketID, movieID, time, cinemaID, seat, TypeOfTicket.Flat, Restriction.PG13);
        MovieTicketController.add(ticket);
        
        //call a method to add to booking history of the user which i dont know who doing
        
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

    public static String searchByTitle(){
        //search by movie title

        return "helloWorld";
    }

    public String sortByTime(String movieID){
        //sort by time

        return "helloWorld";
    }


}
