package src.main.java.movie;

import java.time.LocalDateTime;
import src.main.java.enums.*;
import src.main.java.helper.*;
/**
 * A ReviewList Class.
 * @author Luke Yong Jian
 * @version 1.0
 * @since 2022-11-01
 */
public class ShowTime implements Comparable{
    private String movieID;
    private String cinemaID;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private ClassOfCinema classOfCinema;
    /**
     * compareTo method for ShowTime Comparable.
     */
    public int compareTo(Object o){
        if(o == null){
            return -1;
        }
        else if(!(o instanceof ShowTime)){
            return -1;
        }
        else{
            ShowTime inputShowTime = (ShowTime) o;
            int diff = this.movieID.compareTo(inputShowTime.movieID);
            if(diff!=0){
                return diff;
            }else{
                return this.startTime.compareTo(inputShowTime.startTime);
            }
        }
    }
    /**
     * @param movieID String of movie ID
     * @param cinemaID String of cinema ID
     * @param startTime LocalDateTime of the start date
     * @param endTime LocalDateTime of the end date
     * @param classOfCinema Enum of ClassOfCinema
     */
    public ShowTime(String movieID, String cinemaID, LocalDateTime startTime, LocalDateTime endTime, ClassOfCinema classOfCinema){
        this.movieID = movieID;
        this.cinemaID = cinemaID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.classOfCinema = classOfCinema;
    }
    /**
     * @param movieID String of movie ID
     * @param cinemaID String of cinema ID
     * @param startTime String of the start date
     * @param endTime String of the end date
     * @param classOfCinema Enum of ClassOfCinema
     */
    public ShowTime(String movieID, String cinemaID, String startTime, String endTime, ClassOfCinema classOfCinema){
        this(movieID,
            cinemaID,
            LocalDateTime.parse(startTime,_DateTimeFormatter.formatter),
            LocalDateTime.parse(endTime,_DateTimeFormatter.formatter),
            classOfCinema);
    }
    /**
     * set the id of the cinema
     * @param cinemaID id of the cinema
     */
    public void setCinemaID(String cinemaID) {
        this.cinemaID = cinemaID;
    }
    /**
     * set the id of the movie
     * @param movieID id of the movie
     */
    public void setMovieID(String movieID){
        this.movieID = movieID;
    }
    /**
     * set the start time of the movie
     * @param startTime String start time of the movie
     */
    public void setStartTime(String startTime) {
        this.startTime = LocalDateTime.parse(startTime,_DateTimeFormatter.formatter);
    }
    /**
     * set the start time of the movie
     * @param startTime LocalDateTime start time of the movie
     */
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    /**
     * set the end time of the movie
     * @param endTime String end time of the movie
     */
    public void setEndTime(String endTime) {
        this.startTime = LocalDateTime.parse(endTime,_DateTimeFormatter.formatter);
    }
    /**
     * set the end time of the movie
     * @param endTime LocalDateTime end time of the movie
     */
    public void setEndTime(LocalDateTime endTime) {
        this.startTime = endTime;
    }
    /**
     * set the class of the cinema
     * @param classOfCinema Enum of the class of cinema
     */
    public void setClassOfCinema(ClassOfCinema classOfCinema){
        this.classOfCinema = classOfCinema;
    }
    /**
     * return the movie ID
     * @return return the movie ID
     */
    public String getMovieID() {
        return movieID;
    }
    /**
     * return the id of the cinema
     * @return the id of the cinema
     */
    public String getCinemaID() {
        return cinemaID;
    }
    /**
     * return the start time of the movie
     * @return the start time of the movie
     */
    public LocalDateTime getStartTime() {
        return startTime;
    }
    /**
     * return the end time of the movie
     * @return the end time of the moive
     */
    public LocalDateTime getEndTime() {
        return endTime;
    }
    /**
     * return the class of the cinema
     * @return the class of the cinema
     */
    public ClassOfCinema getClassOfCinema() {
        return classOfCinema;
    }
}
