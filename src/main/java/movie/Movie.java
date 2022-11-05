package src.main.java.movie;

import src.main.java.enums.ShowingStatus;

/**
 * Movie
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

    public void setTitle(String movieTitle){
        this.movieTitle = movieTitle;
    }

    public void setStatus(ShowingStatus showingStatus){
        this.showingStatus = showingStatus;
    }

    public void setSynopsis(String synopsis){
        this.synopsis = synopsis;
    }

    public void setDirector(String director){
        this.director = director;
    }

    public void setCast(String cast){
        this.cast = cast;
    }

    public void setRating(String rating){
        this.rating = rating;
    }
    
    public void setType(String type) {
    	this.type=type;
    }

    public String getMovieTitle(){
        return movieTitle;
    }
    
    public ShowingStatus getShowingStatus() {
        return showingStatus;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getType() {
        return type;
    }

    public String getDirector() {
        return director;
    }

    public String getCast() {
        return cast;
    }

    public String getRating() {
        return rating;
    }

    public String getMovieID(){
        return movieID;
    }
    

}