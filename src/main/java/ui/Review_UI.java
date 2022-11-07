package src.main.java.ui;

import java.util.Scanner;
import src.main.java.movie.*;
import src.main.java.helper.*;

public class Review_UI {
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
