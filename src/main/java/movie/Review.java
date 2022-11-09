package src.main.java.movie;

/**
 * A MovieListing Class.
 * @author Yong Jian Loke
 * @version 1.0
 * @since 2022-11-01
 */

public class Review implements Comparable{
    private int rating;
    private String review;
    private String movieID;
     /**
     * compareTo method for Review Comparable.
     */
    public int compareTo(Object o){
        if(o == null){
            return -1;
        }
        else if(!(o instanceof Review)){
            return -1;
        }
        else{
            Review inputReview = (Review) o;
            int diff = this.movieID.compareTo(inputReview.movieID);
            if(diff!=0){
                return diff;
            }else{
                return this.rating - inputReview.rating;
            }
        }
    }

    /**
     * Constructor of Review class.
     * @param movieID String movie ID
     */
    public Review(String movieID){
        this.movieID = movieID;
        rating = 0;
        review = "";
    }

     /**
     * Constructor of Review class.
     * @param movieID String movie ID
     * @param rating rating of movie
     * @param review review of movie
     */
    public Review(String movieID, int rating, String review){
        this.movieID = movieID;
        this.rating = rating;
        this.review = review;
    }
    /**
     * @return rating of the movie
     */
    public int getRating() {
        return rating;
    }
    /**
     * @return review of the movie
     */
    public String getReview() {
        return review;
    }
    /**
     * @return id of the movie
     */
    public String getMovieID() {
        return movieID;
    }
    /**
     * set the review of the movie
     * @param review review of the movie
     */
    public void setReview(String review) {
        this.review = review;
    }
    /**
     * set the rating of the movie
     * @param rating review of the movie
     */
    public void setRating(int rating) {
        this.rating = rating;
    }
    /**
     * set the id of the movie
     * @param movieID id of the movie
     */
    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }
}
