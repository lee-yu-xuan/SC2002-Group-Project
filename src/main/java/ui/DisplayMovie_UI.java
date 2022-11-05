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
                Scanner stringScanner = new Scanner(System.in).useDelimiter("\n");
                System.out.println("Enter movie title: ");
                String movieTitle = stringScanner.nextLine();
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

        System.out.println("1. View movie details");
        System.out.println("2. Add ratings and reviews");
        //System.out.println("3. Book tickets");

        int choice2 = sc.nextInt();

        switch (choice2) {
            case 1:
                //view movie details
                MovieListing.getMovieDetails(movieID);
                break;
            case 2:
                //add ratings and reviews
                Review_UI.display_UI(movieID);
                break;
            /** 
            case 3:
                //book tickets
                BuyTicket_UI.purchaseTicket(movieID, userName);
                break;
            */
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public static String listBySales(){
        //list top 5 movies by sales
        List<Movie> movieList = MovieController.showMovieByTicketSales();
        System.out.print( "\n\n\n" );
        for(int i = 0;i<movieList.size();i++){
            System.out.println((i+1) + ". "+movieList.get(i).getMovieTitle());
        }

        //select movie
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        String movieID = movieList.get(option-1).getMovieID();

        return movieID;
    }

    public static String listByRating(){
        //list top 5 movies by rating
        List<Movie> movieList = MovieController.showMovieByRating();
        System.out.print( "\n\n\n" );
        for(int i = 0;i<movieList.size();i++){
            System.out.println((i+1) +". "+movieList.get(i).getMovieTitle());
        }

        //select movie
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        String movieID = movieList.get(option-1).getMovieID();

        return movieID;
    }

  
}
