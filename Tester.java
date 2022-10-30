import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) throws Exception {
        MovieListing.load();
        List<Movie> movieList = MovieListing.getMovieList();
        for(int i =0;i<movieList.size();i++){
            System.out.println(movieList.get(i).getMovieTitle());
            System.out.println(movieList.get(i).getShowingStatus());
            System.out.println(movieList.get(i).getSynopsis());
            System.out.println(movieList.get(i).getType());
            System.out.println(movieList.get(i).getDirector());
            System.out.println(movieList.get(i).getCast());
            System.out.println(movieList.get(i).getRating());
            System.out.println(movieList.get(i).getMovieID());
        }
    }
    public static void main4(String[] args) {
        while(true){
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Title");
            String movieTitle = sc.nextLine();
            if(movieTitle.charAt(0) == '#'){
                break;
            }

            System.out.println("Enter Sypnosis");
            String sypnosis = sc.nextLine();
            
            System.out.println("Enter type");
            String type = sc.nextLine();

            System.out.println("Enter director");
            String director = sc.nextLine();

            System.out.println("Enter cast (seperate by comma -> ',' )");
            String cast = sc.nextLine();

            System.out.println("Enter rating");
            String rating = sc.nextLine();
            
            System.out.println("Enter movieID");
            String movieID = sc.nextLine();

            MovieListing.add(new Movie(movieTitle, sypnosis, type, director, cast, rating, movieID));
        }
        MovieListing.save();
    }
}