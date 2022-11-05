package src.main.java.movie;

public class Review implements Comparable{
    private int rating;
    private String review;
    private String movieID;

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
    public Review(String movieID){
        this.movieID = movieID;
        rating = 0;
        review = "";
    }

    public Review(String movieID, int rating, String review){
        this.movieID = movieID;
        this.rating = rating;
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }
    
    public String getMovieID() {
        return movieID;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }
}
