package src.main.java.movie;

import src.main.java.enums.ShowingStatus;

/**
 * A Movie Class.
 * @author Yong Jian Loke
 * @version 1.0
 * @since 2022-11-01
 */
public class Movie{
    private String movieTitle;
    private ShowingStatus showingStatus;
    private String synopsis;
    private String type;
    private String director;
    private String cast;
    private String rating;
    private String movieID;

    /**
     * Constructor of Movie class.
     * @param movieTitle String movie title.
     * @param synopsis String synopsis of movie.
     * @param type String genre of movie.
     * @param director String name of director.
     * @param cast String name of cast.
     * @param rating String rating of movie.
     * @param movieID String movie ID
     */
    public Movie(String movieTitle, String synopsis, String type,String director, String cast, String rating,String movieID){
        this.movieTitle = movieTitle;
        //this.showingStatus = ShowingStatus.COMING_SOON;
        this.synopsis = synopsis;
        this.type = type;
        this.director = director;
        this.cast = cast;
        this.rating = rating;
        this.movieID = movieID;
    }
     /**
     * Constructor of Movie class.
     * @param movieTitle String movie title.
     * @param showingStatus ShowingStatus: movie status
     * @param synopsis String synopsis of movie.
     * @param type String genre of movie.
     * @param director String name of director.
     * @param cast String name of cast.
     * @param rating String rating of movie.
     * @param movieID String movie ID
     */
    public Movie(String movieTitle, ShowingStatus showingStatus, String synopsis, String type,String director, String cast, String rating,String movieID){
        this.movieTitle = movieTitle;
        this.showingStatus = showingStatus;
        this.synopsis = synopsis;
        this.type = type;
        this.director = director;
        this.cast = cast;
        this.rating = rating;
        this.movieID = movieID;
    }
    /**
     * Set the title of a movie.
     * @param movieTitle String of movieTitle.
     */
    public void setTitle(String movieTitle){
        this.movieTitle = movieTitle;
    }
    /**
     * Set the status of a movie.
     * @param showingStatus Enum of movie showing status.
     */
    public void setStatus(ShowingStatus showingStatus){
        this.showingStatus = showingStatus;
    }
    /**
     * Set the synposis of a movie.
     * @param synopsis String of movie synopsis.
     */
    public void setSynopsis(String synopsis){
        this.synopsis = synopsis;
    }
    /**
     * Set the director of a movie.
     * @param director String of movie director.
     */
    public void setDirector(String director){
        this.director = director;
    }
    /**
     * Set the cast of a movie.
     * @param cast String of movie cast.
     */
    public void setCast(String cast){
        this.cast = cast;
    }
    /**
     * Set the rating of a movie.
     * @param rating String of movie ratings.
     */
    public void setRating(String rating){
        this.rating = rating;
    }
    /**
     * Set the genre of a movie.
     * @param type String of movie genre.
     */    
    public void setType(String type) {
    	this.type=type;
    }
    /**
     * Get Movie Title function.
     * @return the movie title.
     */ 
    public String getMovieTitle(){
        return movieTitle;
    }
    /**
     * Get Movie Showing Status function.
     * @return the showing status.
     */    
    public ShowingStatus getShowingStatus() {
        return showingStatus;
    }
    /**
     * Get Movie synopsis function.
     * @return the synopsis.
     */ 
    public String getSynopsis() {
        return synopsis;
    }
    /**
     * Get Movie genre function.
     * @return the genre.
     */ 
    public String getType() {
        return type;
    }
    /**
     * Get Movie Director function.
     * @return the director.
     */ 
    public String getDirector() {
        return director;
    }
    /**
     * Get Movie cast function.
     * @return the cast.
     */ 
    public String getCast() {
        return cast;
    }
    /**
     * Get Movie rating function.
     * @return the rating.
     */ 
    public String getRating() {
        return rating;
    }
    /**
     * Get Movie ID function.
     * @return the movie ID.
     */ 
    public String getMovieID(){
        return movieID;
    }
}