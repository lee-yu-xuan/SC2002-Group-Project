package src.main.java.movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import src.main.java.helper.*;

/**
 * A ReviewList Class.
 * @author Yong Jian Loke
 * @version 1.0
 * @since 2022-11-01
 */

public class ReviewList {
    private static List<Review> reviewList;
    private static List<String[]> reviewCSV;
    /**
	 * Create instance of File_IO.
	 */
    private static File_IOInterface file_IO = new CSVFile_IO();
    
    /*
     * sort the list after inserting new review
     */
    private static void sortAfterAppend()
	{
        int position = reviewList.size() - 1;
        Comparable key = reviewList.get(reviewList.size() -1);
        while (position > 0 && key.compareTo(reviewList.get(position-1)) < 0)
        {
            Collections.swap(reviewList, position, position-1);
            position--;
        }
	}
    /**
     * get the average rating of a certain movie
     * @param movieID id of movie
     * @return average rating of a certain movie
     */
    public static double getAvgRating(String movieID) {
        double total = 0;
        int ratingCount = 0;
        for(int i = 0;i<reviewList.size();i++){
            if(movieID.equals(reviewList.get(i).getMovieID())){
                while(i < reviewList.size() && movieID.equals(reviewList.get(i).getMovieID())){
                    total += reviewList.get(i).getRating();
                    ratingCount++;
                    i++;
                }
                return (double) total / ratingCount;
            }
        }
        //not found
        //System.out.println("MovieID not found!");
        return -1.0;
    }
    /**
     * get the list of review of a certain movie
     * @param movieID id of movie
     * @return the list of review of a certain movie
     */
    public static List<Review> getReviewByID(String movieID){
        List<Review> returnMovieList = new ArrayList<Review>();
        for(int i = 0;i<reviewList.size();i++){
            if(movieID.equals(reviewList.get(i).getMovieID())){
                while(i < reviewList.size() && reviewList.get(i).getMovieID().equals(movieID)){
                    returnMovieList.add(reviewList.get(i));
                }
                break;
            }
        }
        return returnMovieList;
    }

    /**
     * @param movieID id of a movie
     * @param review review of a movie
     * @param rating rating of a movie
     * inserts a new review and rating into a certain movie
     */
    public static void addRatingReview(String movieID, String review, int rating){
        if(reviewList == null){
            reviewList = new ArrayList<Review>();
        }
        reviewList.add(new Review(movieID, rating, review));
        sortAfterAppend();
    }
    /**
     * delete a specific rating
     * @param index index of the rating
     */
    public static void delRatingByIndex(int index){
        reviewList.remove(index);
    }

    /**
     * @return a list of reviews
     */
    public static List<Review> getReview(){
        return reviewList;
    }
    /**
     * Load the content of review list CSV into the system
     */ 
    public static void load(){
        if(reviewList == null){
            reviewList = new ArrayList<Review>();
        }
        reviewCSV = file_IO.readFile("movieReview");

        for(int i = 0;i<reviewCSV.size();i++){
            reviewList.add(new Review(reviewCSV.get(i)[0],
                                        Integer.parseInt(reviewCSV.get(i)[1]),
                                        reviewCSV.get(i)[2]));
        }
        
    }  

    /**
     * Save the content of the system into the review list CSV
     */
    public static void save(){
        List<String[]> writeBackReview = new ArrayList<String[]>();

        for(int i =0;i<reviewList.size();i++){
            List<String> tempReview = new ArrayList<String>();

            tempReview.add(reviewList.get(i).getMovieID());
            tempReview.add(Integer.toString(reviewList.get(i).getRating()));
            tempReview.add(reviewList.get(i).getReview());
            writeBackReview.add(tempReview.toArray(new String[0]));
        }

        file_IO.writeFile(writeBackReview, "movieReview");
    }
}
