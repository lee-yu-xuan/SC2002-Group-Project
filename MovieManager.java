import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    private static List<Movie> movieList;
    private static List<String[]> movieCSV;

    public static void addMovie(String moviename, String Synopsis,String director,String Cast,String time){
        
    }

    public static void removeMovieByID(String movieID){

    }

    public static void viewMovieList(){}

    public static void viewRating(){
        
    }

    public static void addMovie(List<String[]> temp){
        File_IO.writeFile(temp, "testMovieList");
    }

    public static void load(){
        movieCSV = File_IO.readFile("movieList");
        System.out.println(movieCSV.size());
        System.out.println();
        for(int i =0;i<movieCSV.size();i++){
            System.out.println(movieCSV.get(i).length);
            for(int j = 0;j<movieCSV.get(i).length;j++){
                System.out.println(movieCSV.get(i)[j]);
                if(movieCSV.get(i)[0].charAt(0) == '\"'){
                    movieCSV.get(i)[0].length();
                }
            }
        }
    }
}
