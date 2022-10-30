/**
 * Movie
 */
public class Movie {
    private String movieTitle;
    private enum ShowingStatus {COMING_SOON, PREVIEW, NOW_SHOWING};
    private String synopsis;
    private String director;
    private String cast;
    private Review review; 
    public Movie(){
    }
}