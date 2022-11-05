import java.time.LocalDateTime;

public class ShowTime implements Comparable{
    private String movieID;
    private String cinemaID;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private ClassOfCinema classOfCinema;
    
    public int compareTo(Object o){
        if(o == null){
            return -1;
        }
        else if(!(o instanceof ShowTime)){
            return -1;
        }
        else{
            ShowTime inputShowTime = (ShowTime) o;
            int diff = this.movieID.compareTo(inputShowTime.movieID);
            if(diff!=0){
                return diff;
            }else{
                return this.startTime.compareTo(inputShowTime.startTime);
            }
        }
    }

    public ShowTime(String movieID, String cinemaID, LocalDateTime startTime, LocalDateTime endTime, ClassOfCinema classOfCinema){
        this.movieID = movieID;
        this.cinemaID = cinemaID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.classOfCinema = classOfCinema;
    }

    public ShowTime(String movieID, String cinemaID, String startTime, String endTime, ClassOfCinema classOfCinema){
        this(movieID,
            cinemaID,
            LocalDateTime.parse(startTime,_DateTimeFormatter.formatter),
            LocalDateTime.parse(endTime,_DateTimeFormatter.formatter),
            classOfCinema);
    }

    public void setCinemaID(String cinemaID) {
        this.cinemaID = cinemaID;
    }

    public void setMovieID(String movieID){
        this.movieID = movieID;
    }

    public void setStartTime(String startTime) {
        this.startTime = LocalDateTime.parse(startTime,_DateTimeFormatter.formatter);
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    
    public void setEndTime(String endTime) {
        this.startTime = LocalDateTime.parse(endTime,_DateTimeFormatter.formatter);
    }

    public void setEndTime(LocalDateTime endTime) {
        this.startTime = endTime;
    }

    public void setClassOfCinema(ClassOfCinema classOfCinema){
        this.classOfCinema = classOfCinema;
    }

    public String getMovieID() {
        return movieID;
    }

    public String getCinemaID() {
        return cinemaID;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public ClassOfCinema getClassOfCinema() {
        return classOfCinema;
    }
}
