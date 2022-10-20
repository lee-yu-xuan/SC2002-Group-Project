import java.util.List;
import java.util.Set;

public class MovieController {
    public static void main(String[] args) {
        String pathName = "movieList";
        List<String[]>  movieList = File_IO.readFile(pathName);

        //to print
        System.out.print(movieList.get(2)[2]);
        //to change
        movieList.get(2)[2] = "umbrella";
        File_IO.writeFile(movieList, pathName);
    }
}
