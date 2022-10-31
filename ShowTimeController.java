import java.util.List;

public class ShowTimeController {
    public static List<ShowTime> showTimeByShowTime(String movieID){
        return ShowTimeList.getShowTimeByID(movieID);
    }
}
