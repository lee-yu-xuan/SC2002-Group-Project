import java.util.List;

/**
 * Movie
 */
public class Movie implements MovieInterface{
    private String movieTitle;
    private ShowingStatus showingStatus;
    private String synopsis;
    private String director;
    private String cast;
    private Review review;
    private String type;
    private String movieID;

    public Movie(String movieTitle, String synopsis, String director, String cast, String type, String movieID){
        this.movieTitle = movieTitle;
        this.showingStatus = ShowingStatus.COMING_SOON;
        this.director = director;
        this.synopsis = synopsis;
        this.cast = cast;
        this.review = null;
        this.type = type;
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

    public Review getReview(){
        return this.review;
    }

    public 
}