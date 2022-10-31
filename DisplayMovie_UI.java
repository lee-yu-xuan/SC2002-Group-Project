import java.util.List;
import java.util.Scanner;

public class DisplayMovie_UI {
    public void displayInformation(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1. List top 5 movies by sales");
        System.out.println("2. List top 5 movies by rating");
        System.out.println("3. Search by movie title");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                //list top 5 movies by sales
                listBySales();
                break;
            case 2:
                //list top 5 movies by rating
                listByRating();
                break;
            case 3:
                //search by movie title
                searchByTitle();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public void listBySales(){
        //list top 5 movies by sales
        List<Movie> movieList = MovieController.showMovieByTicketSales();
        //print movieList
        for(int i = 0;i<movieList.size();i++){
            System.out.println(i+". "+movieList.get(i).getMovieTitle());
        }

        //select movie
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        String movieID = movieList.get(option).getMovieID();

        //sort cinema by time here
        //pass time, movieID and cinema to displayLayout_UI       
    }

    public void listByRating(){
        //list top 5 movies by rating
    }

    public void searchByTitle(){
        //search by movie title
    }

    public void sortByTime(String movieID){
        //sort by time
    }


}
