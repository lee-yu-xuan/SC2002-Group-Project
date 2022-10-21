//yj

import java.util.ArrayList;
import java.util.List;

public class Cineplex {
    //input attributes
    private List<Cinema> cinemaList;
    private List<Movie> movieList;

    //constructor
    public Cineplex(List<Cinema> cinemaList, List<Movie> movieList) {
        this.cinemaList = cinemaList;
        this.movieList = movieList;
    }

    //getter
    public List<Cinema> getCinemaList() {
        return cinemaList;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    //setter

    public void setCinemaList(List<Cinema> cinemaList) {
        this.cinemaList = cinemaList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}
