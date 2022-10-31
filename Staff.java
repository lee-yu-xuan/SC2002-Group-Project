//package OODP;

import java.util.List;
import java.util.*;

public class Staff extends constructUser
{ 
	public Staff(String Name, String Username, String Password)
	 {
		 this.type = userType.STAFF;
		 this.name = name;
		 this.username = username;
		 this.password = password;
	 }
	
	public String getName() {
		return name;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}