package src.main.java.user;

import src.main.java.enums.*;
/**
 * 
 * Staff Class.
 * @author Yao Xian Zhang
 * @version 1.0
 * @since 2022-11-01
 */
public class Staff extends ConstructUser
{ 
	/**
	 * Staff Constructor.
	 * @param Name Staff's name.
	 * @param Username Staff's username.
	 * @param Password Staff's password.
	 */
	public Staff(String Name, String Username, String Password)
	 {
		 this.type = UserType.STAFF;
		 this.name = Name;
		 this.username = Username;
		 this.password = Password;
	 }
	
	 /**
	  * Get Staff's name.
	  * @return Staff's name.
	  */
	public String getName() {
		return name;
	}

	/**
	 * Get Staff's Username.
	 * @return Staff's Username.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Get Staff's hashed password.
	 * @return Staff's hashed password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set Staff's name.
	 * @param name Staff's name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Set Staff's username.
	 * @param username Staff's username.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Set Staff's hashed password.
	 * @param password Staff's hashed password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}