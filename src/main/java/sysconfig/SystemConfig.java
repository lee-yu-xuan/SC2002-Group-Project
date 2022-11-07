package src.main.java.sysconfig;

import java.util.*;
import java.util.ArrayList;
import src.main.java.enums.*;

/**
 * System Configuration Class for the program.
 * @author Boon Hian Lim
 * @version 1.0
 * @since 2022-11-01
 */
public class SystemConfig {
	/**
	 * List of all the Holidays.
	 */
	List<String[]> days = new ArrayList<>();
    // constructor
	/**
	 * Default Constructor for System Configuration.
	 */
    public SystemConfig(){}
    
	/**
	 * Display the holidays recorded in system configuration.
	 */
    public static void printHolidayList(){
        Holiday.printHoliday();
    }

	/**
	 * Remove the holidays in system configuration.
	 */
	public static void removeHolidays(){
		Holiday.removeHoliday();
	}
    
	/**
	 * Add Holiday for a System configuration.
	 * @param start Start date of the holiday.
	 * @param end End date of the holiday.
	 */
	public static void addHoliday(String start,String end) {
    	Holiday.Add(start, end);
    }

	/**
	 * Set base price for the movie tickets.
	 * @param price base price to be changed to.
	 */
    public static void setBasePrice(double price) {
    	SystemConfigController.setBasePrice(price);
    }
    
	/**
	 * Get base price for the movie tickets.
	 * @return base price of the movie tickets currently.
	 */
    public static double getBasePrice() {
    	return SystemConfigController.getBasePrice();
    }
    
	/**
	 * Get the price difference between different Class of Cinema.
	 * @return The price difference for every Class of Cinema.
	 */
	public static String[] getClassWeight(){
		return SystemConfigController.getClassMultiplier();
	}

	/**
	 * Get the price Multipier for a particular class.
	 * @param x A particular Class of Cinema.
	 * @return Multiplier of that particular class.
	 */
	public static int getClass(ClassOfCinema x){
		return SystemConfigController.getClassMulti(x.toString());
	}
	
	/**
	 * Set the Price Difference for the different classes.
	 * @param plat Multiplier of Platinum class.
	 * @param gold Multiplier of Gold class.
	 * @param silv Multiplier of Silver class.
	 */
	public static void setClassWeight(int plat, int gold, int silv){
		SystemConfigController.setClassMultiplier(plat, gold, silv);
	}
	
}
