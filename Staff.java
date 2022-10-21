package SC2002Project;

import java.util.List;

public class Staff extends constructUser
{ 
	MovieController MC = new MovieController();
	 public Staff(String name, String username, String password)
	 {
		 this.type = userType.STAFF;
		 this.name = name;
		 this.username = username;
		 this.password = password;
	 }
	 public void addMovie(String transactionID, String mobileNumber)
	{
			//MC.add(String MovieName, Enum status, String Synopsis,String director,String Cast,double rating, String reviews);
	}
	 
	 public void removeMovie(String transactionID, String mobileNumber)
	 {
		 //MC.remove(String MovieName);
	 }
	 public void checkRating(String transactionID, String mobileNumber)
	 {
		 //MC.getRating(String Moviename);
	 }
}
