package src.main.java.ui;

import java.util.List;
import java.util.Scanner;
import src.main.java.movie.*;
import src.main.java.helper.*;

/**
 * User Interface for Review Class.
 * @author Lester Lee
 * @version 1.0
 * @since 2022-11-01
 */
public class Review_UI {
    /**
     * Display User Interface to Add Review.
     * @param movieID The ID for a particular movie getting reviewed.
     */
    public static void addReview(String movieID){
        String review = "";
        int rating;
        
        
			System.out.println("Please enter your review");
            review = ExceptionHandling.StringScanner();
            

			System.out.println("Please enter your rating (1-5)");
            rating = ExceptionHandling.IntegerScannerRangeOfFunction(5);
		
        
        ReviewList.addRatingReview(movieID, review, rating);
        ReviewList.save();
    }
    /**
     * Display User Interface for Showing Review.
     * @param movieID The ID for a particular movie showing review.
     */
    public static void displayReview(String movieID){
        
        List<Review> reviewList = ReviewList.getReviewByID(movieID);
        if(reviewList.size() <= 0){
            System.out.println("No review found!");
            return;
        }
        System.out.format("\nAverage Rating: %.2f\n\n",ReviewList.getAvgRating(movieID));
        for(int i = 0; i<reviewList.size() ;i++){
            System.out.format("Review " + i + " :\n");
            System.out.println(reviewList.get(i).getReview());
            System.out.println("Rating:");
            System.out.println(reviewList.get(i).getRating());
            System.out.println();
        }
        System.out.println("Press Enter to exit:");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
}
