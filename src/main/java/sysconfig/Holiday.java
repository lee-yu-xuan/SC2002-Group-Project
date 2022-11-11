package src.main.java.sysconfig;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import src.main.java.helper.*;

/**
 * A Holiday class to create Holiday object.
 * @author Boon Hian Lim
 * @version 1.0
 * @since 2022-11-01
 */
public class Holiday {

	/**
	 * Create instance of File_IO.
	 */
	private static File_IOInterface file_IO = new CSVFile_IO();
	/**
	 * Start of the holiday.
	 */
	static String start;
	/**
	 * End of the holiday.
	 */
	static String end;
	/**
	 * List of all the holiday added into the system.
	 */
	static List<String[]> days;
	// double modifier;
	
	/**
	 * Default constructor for Holiday object.
	 */
	public Holiday() {
	}

	/**
	 * Function to add a Holiday to the system.
	 * @param Start Start date of holiday.
	 * @param End	End date of holiday.
	 */
	// in yyyy-MM-dd;
	public static void Add(String Start, String End) {
		start = Start + " 00:00";
		end = End + " 23:59";
		String[] day = new String[2];
		day[0] = start;
		day[1] = end;
		days.add(day);
		System.out.println(start + " " + end + " holiday added.");
	}

	/**
	 * Function to read all the holiday in that year from database.
	 */
	public static void load() {
		days = file_IO.readFile("PublicHoliday");
	}

	/**
	 * Function to clear all the Holidays in the database.
	 */
	public static void removeHoliday() {
		days = new ArrayList<>();
	}

	/**
	 * Display all the Holidays that has been added into the database.
	 */
	public static void printHoliday() {
		for (String[] hol : days) {
			if (hol.length != 2)
				continue;
			System.out.print("Start of Holiday: " + hol[0]);
			System.out.println(" End of Holiday: " + hol[1]);
		}
	}

	/**
	 * Check if a particular data is a holiday.
	 * @param date Date to be checked.
	 * @return Boolean represetation if a date is a holiday.
	 */
	public static boolean isHoliday(LocalDateTime date){
		for (String[] var : days){
			// LocalDateTime dateTime = LocalDateTime.parse(date, _DateTimeFormatter.formatter);
			// if it is a public holiday or eve of ph return true
			if (date.isAfter(LocalDateTime.parse(var[0], _DateTimeFormatter.formatter).minusDays(1)) &&
				date.isBefore(LocalDateTime.parse(var[1], _DateTimeFormatter.formatter))) return true;
	
		}return false;
	}

	/**
	 * Save all the Holiday added into the database
	 */
	public static void save() {
		file_IO.writeFile(days, "PublicHoliday");
	}

}
