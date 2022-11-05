import java.time.LocalDateTime;
import java.util.List;

public class ShowTimeController {
    public static List<ShowTime> showTimeByShowTime(String movieID){
        return ShowTimeList.getShowTimeByID(movieID);
    }
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

        
    }
}

