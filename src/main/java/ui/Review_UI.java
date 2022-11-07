package src.main.java.ui;

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
     * Display User Interface for Review class.
     * @param movieID The ID for a particular movie getting reviewed.
     */
    public static void display_UI(String movieID){
        String review = "";
        int rating;
        
        
			System.out.println("Please enter your review");
            review = ExceptionHandling.StringScanner();
            

			System.out.println("Please enter your rating (1-5)");
            rating = ExceptionHandling.IntegerScannerRangeOfFunction(5);
		
        
        ReviewList.addRatingReview(movieID, review, rating);
    }
}
