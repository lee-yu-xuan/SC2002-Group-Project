import java.util.Scanner;

public class Review_UI {
    public static void display_UI(String movieID){
        String review = "";
        int rating;
        Scanner sc  = new Scanner(System.in);
        do{
			System.out.println("Please enter your review");
            try {
                review = sc.nextLine();
            }
            catch(NumberFormatException nfe) {
                System.out.println("Please enter in string!");
            }
		}while (review.isEmpty());

        do{
			System.out.println("Please enter your rating (1-5)");
            rating = sc.nextInt();
            if(rating < 0 && rating > 5){
                System.out.println("Your rating has to be within 1 to 5!");
            }
		}while (rating < 0 || rating > 5);
        
        ReviewList.addRatingReview(movieID, review, rating);
    }
}
