import java.time.LocalDateTime;

public class ShowTime implements Comparable{
    private String movieID;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private ClassOfCinema classOfCinema;
    private double price;
    
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

    public ShowTime(String movieID, LocalDateTime startTime, LocalDateTime endTime, ClassOfCinema classOfCinema, double price){
        this.movieID = movieID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.classOfCinema = classOfCinema;
        this.price = Math.round(price * 100.0) / 100.0;
    }

    public ShowTime(String movieID, String startTime, String endTime, ClassOfCinema classOfCinema, double price){
        this(movieID,
            LocalDateTime.parse(startTime,_DateTimeFormatter.formatter),
            LocalDateTime.parse(endTime,_DateTimeFormatter.formatter),
            classOfCinema,
            price);
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

    public void setPrice(double price){
        //double decimal place guard
        this.price = Math.round(price * 100.0) / 100.0;
    }

    public String getMovieID() {
        return movieID;
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

    public double getPrice() {
        return price;
    }
}
