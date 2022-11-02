import java.time.LocalDateTime;
import java.util.Scanner;
public class StaffUI {
	int no=0;
	Scanner sc = new Scanner(System.in);
	public StaffUI(){
		
	};
	
	
	public void UI() {
		StaffManager SM = new StaffManager();
		System.out.println("Please enter your option");
		System.out.println("1) Add Movie");
		System.out.println("2) Remove Movie");
		System.out.println("3) List top 5 movie");
		System.out.println("4) Add ShowTime");
		System.out.println("5) Remove ShowTime");
		no=sc.nextInt();
		switch(no) {
			case 1: SM.addMovie();
			break;
			case 2: SM.removeMovie();
			break;
			case 3: SM.topFiveMovies();
			break;
			case 4: SM.addShowTimes();
			break;
			case 5: SM.removeShowTimes();
			break;
			default: System.out.println("Wrong choice");
		}
	}
	
	
}
