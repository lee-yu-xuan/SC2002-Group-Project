// Relation with Movie -> Deck and Card relationsip
// MovieListing -> Deck
// Movie -> Card
import java.util.ArrayList;
import java.util.List;

public class MovieListing {
    private static List<Movie> movieList;
    private static List<String[]> movieCSV;

    public static List<Movie> getMovieList(){
        return movieList;
    }

    public static String getMovieName(String movieID){
        for(int i=0; i<movieList.size(); i++){
            if(movieList.get(i).getMovieID().equals(movieID)){
                return movieList.get(i).getMovieTitle();
            }
        }
        return "Movie not found";
    }

    public static void add(Movie movie){
        if(movieList == null){
            //System.out.println("The movieList is empty");
            movieList = new ArrayList<Movie>();
        }
        movieList.add(movie);
    }

    public static int getMovieIndexByTitle(String movieTitle){ 
        for(int i = 0;i<movieList.size();i++){ 
            if(movieTitle.equalsIgnoreCase(movieList.get(i).getMovieTitle())){ 
                return i; 
            } 
        } 
        //movieTitle not found 
        return -1; 
    }

    public static int getMovieIndexByID(String movieID){
        for(int i = 0;i<movieList.size();i++){
            if(movieID.equals(movieList.get(i).getMovieID())){
                return i;
            }
        }
        //movieID not found
        return -1;
    }

    public static void getMovieDetails(String movieID){
        int index = getMovieIndexByID(movieID);
        if(index != 1){
            Movie movie = movieList.get(index);

            System.out.println(movie.getMovieTitle());
            System.out.println(movie.getSynopsis());
            System.out.println(movie.getType());
            System.out.println(movie.getDirector());
            System.out.println(movie.getCast());
            System.out.println(movie.getRating());
        }
    }

    public static int deleteByName(String title){
        for(int i = 0;i< movieList.size();i++){
            if(movieList.get(i).getMovieTitle() == title){
                movieList.remove(i); //title found
                return 1;
            }
        }
        return 0; //unable to find title
    }

    public static String getMovieID(String title){
        for(int i = 0;i< movieList.size();i++){
            if(movieList.get(i).getMovieTitle().equals(title)){
                return movieList.get(i).getMovieID(); //title found
            }
        }
        return null; //unable to find title
    }

    public static int deleteByID(String id){
        for(int i = 0;i< movieList.size();i++){
            if(movieList.get(i).getMovieID() == id){
                movieList.remove(i); //id found
                return 1;
            }
        }
        return 0; //unable to find id
    }
    public static void load(){
        if(movieList == null){
            //System.out.println("The movieList is empty");
            movieList = new ArrayList<Movie>();
        }

        movieCSV = File_IO.readFile("movieList");

        for(int i =0;i<movieCSV.size();i++){
            String movieTitle = movieCSV.get(i)[0];
            ShowingStatus showingStatus = ShowingStatus.valueOf(movieCSV.get(i)[1]);
            String synopsis = movieCSV.get(i)[2];
            String type = movieCSV.get(i)[3];
            String director = movieCSV.get(i)[4];
            String cast = movieCSV.get(i)[5];
            String rating = movieCSV.get(i)[6];
            String movieID = movieCSV.get(i)[7];
            movieList.add(new Movie(movieTitle, showingStatus,synopsis, type, director, cast, rating, movieID));
        }
    }

    public static void save(){
        List<String[]> tempCSV = new ArrayList<String[]>();
        
        for(int i =0;i<movieList.size();i++){
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
        File_IO.writeFile(tempCSV, "movieList");
    }
}
