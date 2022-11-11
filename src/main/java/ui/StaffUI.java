package src.main.java.ui;

import java.util.Scanner;

import src.main.java.cinema.CinemaController;
import src.main.java.cinema.CineplexController;
import src.main.java.helper.*;
import src.main.java.movie.MovieListing;
import src.main.java.movie.ShowTimeController;
import src.main.java.movie.ShowTimeList;
import src.main.java.payment.PromoCodeList;
import src.main.java.sysconfig.SystemConfig;
import src.main.java.sysconfig.SystemConfigController;
import src.main.java.user.*;

/**
 * User Interface for Staff.
 * 
 * @author Lester Lee
 * @version 1.0
 * @since 2022-11-01
 */
public class StaffUI {
	static int no = 0;

	/**
	 * Display User Interface for Staff.
	 */
	public static void UI() {
		do {
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
			System.out.println("10) Add new cinema");
			System.out.println("11) Remove cinema");
			System.out.println("12) Add new cineplex");
			System.out.println("13) Remove cineplex");
			System.out.println("14) Log out of staff account");
			no = ExceptionHandling.IntegerScannerRangeOfFunction(14);
			switch (no) {
				case 1:
					StaffManager.addMovie();
					MovieListing.save();
					break;
				case 2:
					StaffManager.removeMovie();
					MovieListing.save();
					break;
				case 3:
					StaffManager.update();
					MovieListing.save();
					break;
				case 4:
					StaffManager.topFiveMovies();
					break;
				case 5:
					StaffManager.addShowTimes();
					ShowTimeList.save();
					break;
				case 6:
					StaffManager.removeShowTimes();
					ShowTimeList.save();
					break;
				case 7:
					StaffManager.viewAllPromo();
					break;
				case 8:
					StaffManager.addPromo();
					PromoCodeList.save();
					break;
				case 9:
					StaffManager.editSysCon();
					SystemConfigController.save();
					break;
				case 10:
					StaffManager.addCinema();
					CinemaController.save();
					break;
				case 11:
					StaffManager.removeCinema();
					CinemaController.save();
					break;
				case 12:
					StaffManager.addCineplex();
					CineplexController.save();
					break;
				case 13:
					StaffManager.removeCineplex();
					CineplexController.save();
					break;
				default:
					System.out.println("Logging out of Staff account ...");
			}
		} while (no > 0 && no < 12);

	}

}
