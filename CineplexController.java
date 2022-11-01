import java.util.ArrayList;
import java.util.List;


public class CineplexController {
    public static List<Cineplex> cineplexList;
    public static List<String[]> cineplexCSV;

    public static void load(){
        if(cineplexList == null){
            System.out.println("The cinemaList is empty");
            cineplexList = new ArrayList<Cineplex>();
        }
    
        cineplexCSV = File_IO.readFile("cinema");

        for(int h=0; h<cineplexCSV.size(); h++){
            String cineplexName = cineplexCSV.get(h)[0];
            List<Cinema> cinemaList = CinemaController.getCinemaListByCineplex(cineplexName);
            List<Movie> movieList = MovieListing.getMovieList();//we assume that all branches will have the same movielist, unlike in real life some movies only available in selected cinemas only
          
            cineplexList.add(new Cineplex(cineplexName, cinemaList, movieList));
        }
    }

    public static void exportToCSV(){
        cineplexCSV = new ArrayList<String[]>();
        for(int h=0; h<cineplexList.size(); h++){
            String[] cineplex = new String[1];
            cineplex[0] = cineplexList.get(h).getCineplexName();
            cineplexCSV.add(cineplex);
        }
        File_IO.writeFile(cineplexCSV, "cineplex");
    }
}
