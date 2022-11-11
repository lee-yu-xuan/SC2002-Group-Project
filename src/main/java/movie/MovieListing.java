package src.main.java.movie;

// Relation with Movie -> Deck and Card relationsip
// MovieListing -> Deck
// Movie -> Card
import java.util.ArrayList;
import java.util.List;

import src.main.java.enums.ShowingStatus;
import src.main.java.helper.*;

/**
 * A MovieListing Class.
 * @author Boon Hian Lim
 * @version 1.0
 * @since 2022-11-01
 */
public class MovieListing {
    private static List<Movie> movieList;
    private static List<String[]> movieCSV;
    /**
	 * Create instance of File_IO.
	 */
    private static File_IOInterface file_IO = new CSVFile_IO();
    /**
     * Get a list of movie function.
     * @return List of Movie.
     */ 
    public static List<Movie> getMovieList() {
        return movieList;
    }
    /**
     * Get a list of available movie function.
     * @return List of Movie.
     */ 
    public static List<Movie> getAvailableMovieList() {
        List<Movie> tempList = new ArrayList<Movie>();
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getShowingStatus() == ShowingStatus.PREVIEW ||
                    movieList.get(i).getShowingStatus() == ShowingStatus.NOW_SHOWING) {
                tempList.add(movieList.get(i));
            }
        }
        return tempList;
    }
    /**
     * Get a list of movie of a specific ID.
     * @param movieID movie ID
     * @return List of specific movie.
     */ 
    public static String getMovieName(String movieID) {
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getMovieID().equals(movieID)) {
                return movieList.get(i).getMovieTitle();
            }
        }
        return "Movie not found";
    }
    /**
     * Add a new movie function.
     * @param movie Movie class object.
     */
    public static void add(Movie movie) {
        if (movieList == null) {
            // System.out.println("The movieList is empty");
            movieList = new ArrayList<Movie>();
        }
        movieList.add(movie);
    }
    /**
     * Get a index of movie of a specific name.
     * @param movieTitle String title of movie
     * @return index of movie.
     */ 
    public static int getMovieIndexByTitle(String movieTitle) {
        for (int i = 0; i < movieList.size(); i++) {
            if (movieTitle.equalsIgnoreCase(movieList.get(i).getMovieTitle())) {
                return i;
            }
        }
        // movieTitle not found
        return -1;
    }
    /**
     * Get a index of movie of a specific name.
     * @param movieID d of movie
     * @return index of movie.
     */ 
    public static int getMovieIndexByID(String movieID) {
        for (int i = 0; i < movieList.size(); i++) {
            if (movieID.equals(movieList.get(i).getMovieID())) {
                return i;
            }
        }
        // movieID not found
        return -1;
    }
    /**
     * Get a the showing status of a specific movie.
     * @param movieID d of movie
     * @return Enum showingStatus.
     */ 
    public static ShowingStatus getShowingStatus(String movieID) {
        int index = getMovieIndexByID(movieID);
        if (index != -1) {
            return movieList.get(index).getShowingStatus();
        }
        return null;
    }
    /**
     * Get the details of a specific movie.
     * @param movieID id of movie
     */ 
    public static void getMovieDetails(String movieID) {
        int index = getMovieIndexByID(movieID);
        if (index != 1) {
            Movie movie = movieList.get(index);

            System.out.println(movie.getMovieTitle());
            System.out.println(movie.getSynopsis());
            System.out.println(movie.getType());
            System.out.println(movie.getDirector());
            System.out.println(movie.getCast());
            System.out.println(movie.getRating());
        }
    }
    /**
     * Delete a movie by name.
     * @param title title of movie
     * @return success/failure.
     */ 
    public static int deleteByName(String title) {
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getMovieTitle() == title) {
                movieList.remove(i); // title found
                return 1;
            }
        }
        return 0; // unable to find title
    }
    /**
     * Get the id of a movie by name.
     * @param title title of movie
     * @return id of movie.
     */ 
    public static String getMovieID(String title) {
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getMovieTitle().equals(title)) {
                return movieList.get(i).getMovieID(); // title found
            }
        }
        return null; // unable to find title
    }
    /**
     * Get the status of a movie by name.
     * @param title title of movie
     * @return success of operation.
     */ 
    public static String getAvailableMovieID(String title) {
        List<Movie> tempList = getAvailableMovieList();
        for (int i = 0; i < tempList.size(); i++) {
            if (tempList.get(i).getMovieTitle().equals(title)) {
                return tempList.get(i).getMovieID(); // title found
            }
        }
        return null;
    }
    /**
     * Delete a movie by name.
     * @param id id of movie
     * @return success of operation.
     */ 
    public static int deleteByID(String id) {
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getMovieID() == id) {
                movieList.remove(i); // id found
                return 1;
            }
        }
        return 0; // unable to find id
    }

    /**
     * Load the content of movie list CSV into the system
     */ 
    public static void load() {
        try {
            if (movieList == null) {
                // System.out.println("The movieList is empty");
                movieList = new ArrayList<Movie>();
            }

            movieCSV = file_IO.readFile("movieList");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for (int i = 0; i < movieCSV.size(); i++) {
            String movieTitle = movieCSV.get(i)[0];
            ShowingStatus showingStatus = ShowingStatus.valueOf(movieCSV.get(i)[1]);
            String synopsis = movieCSV.get(i)[2];
            String type = movieCSV.get(i)[3];
            String director = movieCSV.get(i)[4];
            String cast = movieCSV.get(i)[5];
            String rating = movieCSV.get(i)[6];
            String movieID = movieCSV.get(i)[7];
            movieList.add(new Movie(movieTitle, showingStatus, synopsis, type, director, cast, rating, movieID));
        }
    }

    /**
     * Save the content of the system into the movie list CSV
     */ 
    public static void save() {
        List<String[]> tempCSV = new ArrayList<String[]>();

        for (int i = 0; i < movieList.size(); i++) {
            String[] temp = new String[8];
            temp[0] = movieList.get(i).getMovieTitle();
            temp[1] = movieList.get(i).getShowingStatus().toString();
            temp[2] = movieList.get(i).getSynopsis();
            temp[3] = movieList.get(i).getType();
            temp[4] = movieList.get(i).getDirector();
            temp[5] = movieList.get(i).getCast();
            temp[6] = movieList.get(i).getRating();
            temp[7] = movieList.get(i).getMovieID();
            tempCSV.add(temp);
        }
        file_IO.writeFile(tempCSV, "movieList");
    }
}
