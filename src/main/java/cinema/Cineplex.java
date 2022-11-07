package src.main.java.cinema;

import java.util.List;
import src.main.java.movie.*;

public class Cineplex {
    //input attributes
    private String cineplexName;
    private List<Cinema> cinemaList;
    private List<Movie> movieList;

    //constructor
    public Cineplex(String cineplexName, List<Cinema> cinemaList, List<Movie> movieList) {
        this.cineplexName = cineplexName;
        this.cinemaList = cinemaList;
        this.movieList = movieList;
    }

    //getter
    public String getCineplexName() {
        return cineplexName;
    }

    public List<Cinema> getCinemaList() {
        return cinemaList;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    //setter
    public void setCineplexName(String cineplexName) {
        this.cineplexName = cineplexName;
    }

    public void setCinemaList(List<Cinema> cinemaList) {
        this.cinemaList = cinemaList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}
