import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Holiday {

	static String start;
	static String end;
	static List<String[]> days;
	// double modifier;

	public Holiday() {
	}

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

	public static void loadHoliday() {
		days = File_IO.readFile("PublicHoliday");
	}

	public static void removeHoliday() {
		days = new ArrayList<>();
	}

	public static void printHoliday() {
		for (String[] hol : days) {
			if (hol.length != 2)
				continue;
			System.out.print("Start of Holiday: " + hol[0]);
			System.out.println(" End of Holiday: " + hol[1]);
		}
	}

	public static boolean isHoliday(LocalDateTime date){
		for (String[] var : days){
			// LocalDateTime dateTime = LocalDateTime.parse(date, _DateTimeFormatter.formatter);
			// if it is a public holiday or eve of ph return true
			if (date.isAfter(LocalDateTime.parse(var[0], _DateTimeFormatter.formatter).minusDays(1)) &&
				date.isBefore(LocalDateTime.parse(var[1], _DateTimeFormatter.formatter))) return true;
	
		}return false;
	}

	public static void save() {
		File_IO.writeFile(days, "PublicHoliday");
	}

}
