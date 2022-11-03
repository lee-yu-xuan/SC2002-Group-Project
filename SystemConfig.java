package oodp;
import java.util.*;
public class SystemConfig {
	List<String[]> days = new ArrayList<>();
    // constructor
    public SystemConfig(){}

    // in yyyy-MM-dd;
    public void Add(String date){
        String start = date + " 00:00";
        String end = date + " 23:59";
        String[] day = new String[2];
        System.out.println(start + "\\" + end);
        day[0] = start;
        day[1] = end;
        days.add(day);
    }

    public void updateCSV(){
        File_IO.writeFile(days, "PublicHoliday");
    }

    // public static void main (String[] args){
    //     AddPublicHoliday test_add = new AddPublicHoliday();
    //     test_add.Add("2022-12-25");
    //     test_add.Add("2022-12-31");
    //     test_add.updateCSV();
    // }
}
