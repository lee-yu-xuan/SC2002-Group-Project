import java.util.*;
import java.util.ArrayList;

public class SystemConfig {
	List<String[]> days = new ArrayList<>();
    // constructor
    public SystemConfig(){}
    
    public static void printHolidayList(){
        Holiday.printHoliday();
    }

	public static void removeHolidays(){
		Holiday.removeHoliday();
	}
    
	public static void addHoliday(String start,String end) {
    	Holiday.Add(start, end);
    }

    public static void setBasePrice(double price) {
    	SystemConfigController.setBasePrice(price);
    }
    
    public static double getBasePrice() {
    	return SystemConfigController.getBasePrice();
    }
    
	public static String[] getClassWeight(){
		return SystemConfigController.getClassMultiplier();
	}

	public static int getClass(ClassOfCinema x){
		return SystemConfigController.getClassMulti(x.toString());
	}
	
	public static void setClassWeight(int plat, int gold, int silv){
		SystemConfigController.setClassMultiplier(plat, gold, silv);
	}
	
}
