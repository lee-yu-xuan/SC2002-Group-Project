package src.main.java.cinema;

import java.util.List;
import src.main.java.movie.*;

/**
 * Cinema Class.
 * @author Yong Jian loke
 * @version 1.0
 * @since 2022-11-01
 */

public class Cineplex {

    private String cineplexName;
    private List<Cinema> cinemaList;
    private List<Movie> movieList;

    /**
     * @param cineplexName the name of the cineplex
     * @param cinemaList the list of cinema objects
     * @param movieList the list of movie objects 
     */
    public Cineplex(String cineplexName, List<Cinema> cinemaList, List<Movie> movieList) {
        this.cineplexName = cineplexName;
        this.cinemaList = cinemaList;
        this.movieList = movieList;
    }

    /**
     * Get the name of the cineplex
     * @return the name of the cineplex
     */
    public String getCineplexName() {
        return cineplexName;
    }

    /**
     * Get the list of cinema objects
     * @return the list of cinema objects
     */
    public List<Cinema> getCinemaList() {
        return cinemaList;
    }

    /**
     * Get the list of movie objects
     * @return the list of movie objects
     */
    public List<Movie> getMovieList() {
        return movieList;
    }

    /**
     * Set the name of the cineplex
     * @param cineplexName the name of the cineplex
     */
    public void setCineplexName(String cineplexName) {
        this.cineplexName = cineplexName;
    }

    /**
     * Set the list of cinema objects
     * @param cinemaList the list of cinema objects
     */
    public void setCinemaList(List<Cinema> cinemaList) {
        this.cinemaList = cinemaList;
    }

    /**
     * Set the list of movie objects
     * @param movieList the list of movie objects
     */
    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}
