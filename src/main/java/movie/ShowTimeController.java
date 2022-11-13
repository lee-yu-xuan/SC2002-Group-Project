package src.main.java.movie;

import java.time.LocalDateTime;
import java.util.List;

import src.main.java.enums.ShowingStatus;
/**
 * A ShowTimeController Class.
 * @author Yong Jian Loke
 * @version 1.0
 * @since 2022-11-01
 */
public class ShowTimeController {
    /**
     * return a list of show time for a specfiic movie
     * @param movieID id of a movie
     * @return the list of showtime for the movie
     */
    public static List<ShowTime> showTimeByShowTime(String movieID){
        return ShowTimeList.getShowTimeByID(movieID);
    }
    /**
     * refreshes the list of showtime
     */
    public static void refresh(){
        //debug
        //LocalDateTime now = LocalDateTime.parse("2023-01-03 12:00",_DateTimeFormatter.formatter);
        
        LocalDateTime now = LocalDateTime.now();
        List<ShowTime> showTime = ShowTimeList.getShowTimeList();

        for(int i = 0;i<showTime.size();i++){

            int diff = now.compareTo(showTime.get(i).getStartTime());

            if(diff > 0){ // current Time already past start Time
                String currentMovieID = showTime.get(i).getMovieID();
                
                if(ShowTimeList.getShowTimeByID(currentMovieID).size() != 0){
                    int index = MovieListing.getMovieIndexByID(currentMovieID);
                    if(index != -1){
                        MovieListing.getMovieList().get(index).setStatus(ShowingStatus.NOW_SHOWING);
                    }
                }
                //debug message 
                //System.out.println("This show is over.");
            }
        }

        for(int i = 0;i<showTime.size();i++){

            int diff = now.compareTo(showTime.get(i).getEndTime());

            if(diff > 0){ // current Time already past End Time
                String currentMovieID = showTime.get(i).getMovieID();
                showTime.remove(i);
                
                if(ShowTimeList.getShowTimeByID(currentMovieID).size() == 0){
                    int index = MovieListing.getMovieIndexByID(currentMovieID);
                    if(index != -1){
                        MovieListing.getMovieList().get(index).setStatus(ShowingStatus.END_OF_SHOWING);
                    }
                }
                i--;

                //debug message 
                //System.out.println("This show is over.");
            }
        }
        MovieListing.save();
        ShowTimeList.save();
        
    }
}

