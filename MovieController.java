import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieController {
    public static void showMovieByRating(){
        List<Movie> movieList = MovieListing.getMovieList();
        List<String> movieID = new ArrayList<String>();
        for(int i = 0;i<movieList.size();i++){
            movieID.add(movieList.get(i).getMovieID());
        }

        //insertion sort
        for(int i = 1;i<movieList.size();i++){
            for(int j = i;j> 0;j--){
                double curRating = ReviewList.getAvgRating(movieID.get(j));
                double preRating = ReviewList.getAvgRating(movieID.get(j-1));
                if(curRating < preRating){
                    Collections.swap(movieList,j,j-1);
                }
                else break;
            }
            
        }
        for(int k = 0;k<movieList.size();k++){
            System.out.println(movieList.get(k).getMovieTitle());
            System.out.println(ReviewList.getAvgRating(movieList.get(k).getMovieID()));
        }
        
    }

    public static void showMovieByTicketSales(){
        
    }
}
