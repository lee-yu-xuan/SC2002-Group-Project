
import java.time.LocalDateTime;
import java.util.Scanner;
public class StaffUI {
	static int no=0;
	static Scanner sc = new Scanner(System.in);
	
	
	
	public static void UI() {
		StaffManager SM = new StaffManager();
		System.out.println("Please enter your option");
		System.out.println("1) Add Movie");
		System.out.println("2) Remove Movie");
		System.out.println("3) Update Movie");
		System.out.println("4) List top 5 movie");
		System.out.println("5) Add ShowTime");
		System.out.println("6) Remove ShowTime");
		no=sc.nextInt();
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
			default: System.out.println("Wrong choice");
		}
	}
	
	
}
