package src.main.java.movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * A Movie Controller Class.
 * @author Boon Hian Lim
 * @version 1.0
 * @since 2022-11-01
 */


public class MovieController {
    
    /**
     * Loads the movie by ratings function.
     * @return a list of movie title sorted by ratings.
     */
    public static List<Movie> showMovieByRating(){
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
                if(curRating > preRating){
                    Collections.swap(movieList,j,j-1);
                    Collections.swap(movieID,j,j-1);
                }
                else break;
            }
        }
        
        return movieList;
    }
    /**
     * Loads the movie by ticket sales function.
     * @return a list of movie title sorted by ticket sales.
     */
    public static List<Movie> showMovieByTicketSales(){
        List<Movie> movieList = MovieListing.getMovieList();
        List<String> movieID = new ArrayList<String>();
        for(int i = 0;i<movieList.size();i++){
            movieID.add(movieList.get(i).getMovieID());
        }

        //insertion sort
        for(int i = 1;i<movieList.size();i++){
            for(int j = i;j> 0;j--){
                double curRating = SalesManager.getSalesByID(movieID.get(j));
                double preRating = SalesManager.getSalesByID(movieID.get(j-1));
                if(curRating < preRating){
                    Collections.swap(movieList,j,j-1);
                    Collections.swap(movieID,j,j-1);
                }
                else break;
            }
        }
        
        return movieList;
    }
    /**
     * Loads the available movie by ticket sales function.
     * @return a list of  avaiable movie title sorted by ticket sales.
     */
    public static List<Movie> showAvailableMovieByRating(){
        List<Movie> movieList = MovieListing.getAvailableMovieList();
        List<String> movieID = new ArrayList<String>();
        for(int i = 0;i<movieList.size();i++){
            movieID.add(movieList.get(i).getMovieID());
        }

        //insertion sort
        for(int i = 1;i<movieList.size();i++){
            for(int j = i;j> 0;j--){
                double curRating = ReviewList.getAvgRating(movieID.get(j));
                double preRating = ReviewList.getAvgRating(movieID.get(j-1));
                if(curRating > preRating){
                    Collections.swap(movieList,j,j-1);
                    Collections.swap(movieID,j,j-1);
                }
                else break;
            }
        }
        
        return movieList;
    }
    /**
     * Loads the available movie by ratings function.
     * @return a list of  avaiable movie title sorted by ratings.
     */
    public static List<Movie> showAvailableMovieByTicketSales(){
        List<Movie> movieList = MovieListing.getAvailableMovieList();
        List<String> movieID = new ArrayList<String>();
        for(int i = 0;i<movieList.size();i++){
            movieID.add(movieList.get(i).getMovieID());
        }

        //insertion sort
        for(int i = 1;i<movieList.size();i++){
            for(int j = i;j> 0;j--){
                double curRating = SalesManager.getSalesByID(movieID.get(j));
                double preRating = SalesManager.getSalesByID(movieID.get(j-1));
                if(curRating < preRating){
                    Collections.swap(movieList,j,j-1);
                    Collections.swap(movieID,j,j-1);
                }
                else break;
            }
        }
        
        return movieList;
    }
}
