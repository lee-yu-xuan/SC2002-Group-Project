package src.main.java.ui;

import java.util.Scanner;
import src.main.java.helper.*;
import src.main.java.user.*;

/**
 * User Interface for Staff.
 * @author Lester Lee
 * @version 1.0
 * @since 2022-11-01
 */
public class StaffUI {
	static int no=0;
	
	
	
	/**
	 * Display User Interface for Staff.
	 */
	public static void UI() {
		do{
			StaffManager SM = new StaffManager();
			System.out.println("Please enter your option");
			System.out.println("1) Add Movie");
			System.out.println("2) Remove Movie");
			System.out.println("3) Update Movie");
			System.out.println("4) List top 5 movie");
			System.out.println("5) Add ShowTime");
			System.out.println("6) Remove ShowTime");
			System.out.println("7) View Promo Codes");
			System.out.println("8) Add Promo Codes");
			System.out.println("9) Edit System Configuration");
			System.out.println("10) Log out of staff account");
			no=ExceptionHandling.IntegerScannerRangeOfFunction(10);
			switch(no) {
				case 1: StaffManager.addMovie();
				break;
				case 2: StaffManager.removeMovie();
				break;
				case 3: StaffManager.update();
				break;
				case 4: StaffManager.topFiveMovies();
				break;
				case 5: StaffManager.addShowTimes();
				break;
				case 6: StaffManager.removeShowTimes();
				break;
				case 7: StaffManager.viewAllPromo();
				break;
				case 8: StaffManager.addPromo();
				break;
				case 9: StaffManager.editSysCon();
				break;
				default: System.out.println("Logging out of Staff account ...");
			}
		}while( no > 0 && no < 10);
		
	}
	
	
}
