package src.main.java.movie;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import src.main.java.helper.*;
import src.main.java.enums.*;
/**
 * A ShowTimeController Class.
 * @author Yong Jian Loke
 * @version 1.0
 * @since 2022-11-01
 */
public class ShowTimeList {
    private static List<ShowTime> showTimeList;
    private static List<String[]> showTimeCSV;
    /**
     * sorts the list of show time after a new one has been added in
     */
    private static void sortAfterAppend()
	{
        int position = showTimeList.size() - 1;
        Comparable key = showTimeList.get(showTimeList.size() -1);
        while (position > 0 && key.compareTo(showTimeList.get(position-1)) < 0)
        {
            Collections.swap(showTimeList, position, position-1);
            position--;
        }
	}
    /**
     * returns a list of showtime
     * @return a list of showtime
     */
    public static List<ShowTime> getShowTimeList(){
        return showTimeList;
    }
    /**
     * return a list of showtime for a specific movie
     * @param movieID id of the movie
     * @return the lsit of showtime for the specific movie
     */
    public static List<ShowTime> getShowTimeByID(String movieID){
        List<ShowTime> returnList = new ArrayList<ShowTime>();
        for(int i = 0;i<showTimeList.size();i++){
            if(movieID.compareTo(showTimeList.get(i).getMovieID()) == 0){
                while(i < showTimeList.size() && movieID.compareTo(showTimeList.get(i).getMovieID()) == 0){
                    returnList.add(showTimeList.get(i));
                    i++;
                }
                break;
            }
        }
        return returnList;
    }
    /**
     * add a showTime
     * @param showTime Showtime show time of the movie
     */
    public static void add(ShowTime showTime){
        if(showTimeList == null){
            System.out.println("The showTimeList is empty");
            showTimeList = new ArrayList<ShowTime>();
        }
        showTimeList.add(showTime);
        sortAfterAppend();
    }
    /**
     * delete a show time via id
     * @param index index of the showtime
     */
    public static void deleteByIndex(int index){
        showTimeList.remove(index);
    }
    /**
     * delete a show time via movie info
     * @param movieID String movie id
     * @param cinemaID String cinema id
     * @param startTime LocalDateTime start time of the movie
     * @param endTime LocalDateTIme end time of the movie
     */
    public static void deleteByMovieInfo(String movieID, String cinemaID, LocalDateTime startTime, LocalDateTime endTime){
        for(int i = 0;i<showTimeList.size();i++){
            if(showTimeList.get(i).getMovieID() == movieID &&
            showTimeList.get(i).getCinemaID() == cinemaID &&
            showTimeList.get(i).getStartTime() == startTime &&
            showTimeList.get(i).getEndTime() == endTime)
                showTimeList.remove(i);
        }
        
    }
   /**
     * Load the content of showtime list CSV into the system
     */ 
    public static void load(){
        if(showTimeList == null){
            showTimeList = new ArrayList<ShowTime>();
        }
        showTimeCSV = File_IO.readFile("showTime");
        
        for(int i = 0;i<showTimeCSV.size();i++){
            String movieID = showTimeCSV.get(i)[0];
            String cinemaID = showTimeCSV.get(i)[1];
            String startTime = showTimeCSV.get(i)[2];
            String endTime = showTimeCSV.get(i)[3];
            ClassOfCinema classOfCinema = ClassOfCinema.valueOf(showTimeCSV.get(i)[4]);
            ShowTime showTime = new ShowTime(movieID, 
                                        cinemaID,
                                        LocalDateTime.parse(startTime,_DateTimeFormatter.formatter),
                                        LocalDateTime.parse(endTime,_DateTimeFormatter.formatter),
                                        classOfCinema);
            showTimeList.add(showTime);
        }
    }
    /**
    * Save the content of the system into the showtime list CSV
    */	
    public static void save(){
        List<String[]> writeBackCSV = File_IO.readFile("showTime");

        for(int i =0;i<showTimeList.size();i++){
            List<String> tempTimeList = new ArrayList<String>();

            tempTimeList.add(showTimeList.get(i).getMovieID());

            tempTimeList.add(showTimeList.get(i).getCinemaID());

            LocalDateTime startTime = showTimeList.get(i).getStartTime();
            tempTimeList.add(startTime.format(_DateTimeFormatter.formatter));

            LocalDateTime endTime = showTimeList.get(i).getEndTime();
            tempTimeList.add(endTime.format(_DateTimeFormatter.formatter));

            ClassOfCinema classOfCinema = showTimeList.get(i).getClassOfCinema();
            tempTimeList.add(classOfCinema.toString());

            writeBackCSV.add(tempTimeList.toArray(new String[0]));
        }

        File_IO.writeFile(writeBackCSV, "showTime");
    }
}
