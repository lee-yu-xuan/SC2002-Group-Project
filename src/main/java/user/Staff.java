package src.main.java.user;

import src.main.java.enums.*;

public class Staff extends ConstructUser
{ 
	public Staff(String Name, String Username, String Password)
	 {
		 this.type = UserType.STAFF;
		 this.name = Name;
		 this.username = Username;
		 this.password = Password;
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