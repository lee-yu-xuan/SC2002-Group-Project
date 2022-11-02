import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        ShowTimeList.load();
        MovieListing.load();
        ShowTimeController.refresh();

    }
    public static void ShowTimeReadTestByID(String[] args) {
        ShowTimeList.load();
        List<ShowTime> timeList = ShowTimeList.getShowTimeByID("S0001");
        for(int j = 0;j < timeList.size();j++){
            System.out.println(timeList.get(j).getMovieID());
            System.out.println(timeList.get(j).getCinemaID());
            System.out.println(timeList.get(j).getStartTime());
            System.out.println(timeList.get(j).getEndTime());
            System.out.println(timeList.get(j).getClassOfCinema());
            System.out.println(timeList.get(j).getPrice());
        }
    }
    
    public static void ShowTimeReadTest(String[] args) {
        ShowTimeList.load();
        for(int j = 0;j < ShowTimeList.getShowTimeList().size();j++){
            System.out.println(ShowTimeList.getShowTimeList().get(j).getMovieID());
            System.out.println(ShowTimeList.getShowTimeList().get(j).getStartTime());
            System.out.println(ShowTimeList.getShowTimeList().get(j).getEndTime());
            System.out.println(ShowTimeList.getShowTimeList().get(j).getClassOfCinema());
            System.out.println(ShowTimeList.getShowTimeList().get(j).getPrice());
        }
    }
    public static void ShowTimeWriteTest(String[] args) {
        while(true){
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter MovieID");
            String movieID = sc.nextLine();
            if(movieID.charAt(0) == '#'){
                break;
            }

            System.out.println("Enter cinemaID");
            String cinemaID = sc.nextLine();

            System.out.println("Enter startTime");
            String startTime = sc.nextLine();
            
            System.out.println("Enter endTime");
            String endTime = sc.nextLine();

            System.out.println("Enter classOfCinema");
            ClassOfCinema classOfCinema = ClassOfCinema.valueOf(sc.nextLine());

            System.out.println("Enter price");
            double price = sc.nextDouble();

            ShowTimeList.add(new ShowTime(movieID, cinemaID,startTime, endTime, classOfCinema, price));
        }
        for(int j = 0;j < ShowTimeList.getShowTimeList().size();j++){
            System.out.println(ShowTimeList.getShowTimeList().get(j).getMovieID());
            System.out.println(ShowTimeList.getShowTimeList().get(j).getCinemaID());
            System.out.println(ShowTimeList.getShowTimeList().get(j).getStartTime());
            System.out.println(ShowTimeList.getShowTimeList().get(j).getEndTime());
            System.out.println(ShowTimeList.getShowTimeList().get(j).getClassOfCinema());
            System.out.println(ShowTimeList.getShowTimeList().get(j).getPrice());
        }
        ShowTimeList.save();
    }

    public static void RatingReviewReadTest(String[] args) {
        ReviewList.load();
        for(int j = 0;j < ReviewList.getReview().size();j++){
            System.out.println(ReviewList.getReview().get(j).getMovieID());
            System.out.println(ReviewList.getReview().get(j).getRating());
            System.out.println(ReviewList.getReview().get(j).getReview());
        }
    }
    public static void RatingReviewWriteTest(String[] args) {
        while(true){
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter MovieID");
            String movieID = sc.nextLine();
            if(movieID.charAt(0) == '#'){
                break;
            }

            System.out.println("Enter review");
            String review = sc.nextLine();
            
            System.out.println("Enter rating");
            int rating = sc.nextInt();

            ReviewList.addRatingReview(movieID,review,rating);
        }
        for(int j = 0;j < ReviewList.getReview().size();j++){
            System.out.println(ReviewList.getReview().get(j).getMovieID());
            System.out.println(ReviewList.getReview().get(j).getRating());
            System.out.println(ReviewList.getReview().get(j).getReview());
        }
        ReviewList.save();
    }
    public static void testCaseForReadMovie(String[] args) throws Exception {
        MovieListing.load();
        List<Movie> movieList = MovieListing.getMovieList();
        for(int i =0;i<movieList.size();i++){
            System.out.println(movieList.get(i).getMovieTitle());
            System.out.println(movieList.get(i).getShowingStatus());
            System.out.println(movieList.get(i).getSynopsis());
            System.out.println(movieList.get(i).getType());
            System.out.println(movieList.get(i).getDirector());
            System.out.println(movieList.get(i).getCast());
            System.out.println(movieList.get(i).getRating());
            System.out.println(movieList.get(i).getMovieID());
        }
    }
    public static void testCaseForWriteMovie(String[] args) {
        while(true){
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Title");
            String movieTitle = sc.nextLine();
            if(movieTitle.charAt(0) == '#'){
                break;
            }

            System.out.println("Enter Sypnosis");
            String sypnosis = sc.nextLine();
            
            System.out.println("Enter type");
            String type = sc.nextLine();

            System.out.println("Enter director");
            String director = sc.nextLine();

            System.out.println("Enter cast (seperate by comma -> ',' )");
            String cast = sc.nextLine();

            System.out.println("Enter rating");
            String rating = sc.nextLine();
            
            System.out.println("Enter movieID");
            String movieID = sc.nextLine();

            MovieListing.add(new Movie(movieTitle, sypnosis, type, director, cast, rating, movieID));
        }
        MovieListing.save();
    }
}