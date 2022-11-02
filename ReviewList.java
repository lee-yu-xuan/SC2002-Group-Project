import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.HashMap;

public class ReviewList {
    private static List<Review> reviewList;
    private static List<String[]> reviewCSV;

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

    public static double getAvgRating(String movieID){
        double total = 0;
        int ratingCount = 0;
        for(int i = 0;i<reviewList.size();i++){
            if(movieID.compareTo(reviewList.get(i).getMovieID()) == 0){
                while(i < reviewList.size() && movieID.compareTo(reviewList.get(i).getMovieID()) == 0){
                    total += reviewList.get(i).getRating();
                    ratingCount++;
                    i++;
                }
                return (double) total / ratingCount;
            }
        }
        //not found
        System.out.println("MovieID not found!");
        return -1.0;
    }

    public static List<Review> getReviewByID(String movieID){
        List<Review> returnMovieList = new ArrayList<Review>();
        for(int i = 0;i<reviewList.size();i++){
            if(reviewList.get(i).getMovieID() == movieID){
                while(i < reviewList.size() && reviewList.get(i).getMovieID() == movieID){
                    returnMovieList.add(reviewList.get(i));
                }
                break;
            }
        }
        return returnMovieList;
    }

    public static void addRatingReview(String movieID, String review, int rating){
        if(reviewList == null){
            reviewList = new ArrayList<Review>();
        }
        reviewList.add(new Review(movieID, rating, review));
        sortAfterAppend();
    }

    public static void delRatingByIndex(int index){
        reviewList.remove(index);
    }

    public static List<Review> getReview(){
        return reviewList;
    }

    public static void load(){
        if(reviewList == null){
            reviewList = new ArrayList<Review>();
        }
        reviewCSV = File_IO.readFile("movieReview");

        for(int i = 0;i<reviewCSV.size();i++){
            reviewList.add(new Review(reviewCSV.get(i)[0],
                                        Integer.parseInt(reviewCSV.get(i)[1]),
                                        reviewCSV.get(i)[2]));
        }
        
    }  


    public static void save(){
        List<String[]> writeBackReview = new ArrayList<String[]>();

        for(int i =0;i<reviewList.size();i++){
            List<String> tempReview = new ArrayList<String>();

            tempReview.add(reviewList.get(i).getMovieID());
            tempReview.add(Integer.toString(reviewList.get(i).getRating()));
            tempReview.add(reviewList.get(i).getReview());
            writeBackReview.add(tempReview.toArray(new String[0]));
        }

        File_IO.writeFile(writeBackReview, "movieReview");
    }
}
