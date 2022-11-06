package src.main.java.user;

import src.main.java.enums.*;

/**
 * MovieGoer class.
 * @author Yu Xuan Ng
 * @version 1.0
 * @since 2022-11-01
 */
public class MovieGoer extends ConstructUser
{	
	/**
	 * The age of the MovieGoer.
	 */
	private int age;
	
	/**
	 * Default constructor for MovieGoer.
	 */
	public MovieGoer()
	{
		this.type = UserType.MOVIEGOER;
		this.age = 0;
		this.name = "";
		this.username = "";
		this.password = "";
	}
	
	/**
	 * Constructor for MovieGoer with name, username, hashed password and age.
	 * @param name MovieGoer's name.
	 * @param username MovieGoer's username.
	 * @param password MovieGoer's hashed password.
	 * @param age MovieGoer's age.
	 */
	public MovieGoer(String name, String username, String password, int age)
	{
		this.type = UserType.MOVIEGOER;
		this.name = name;
		this.username = username;
		this.password = password;
		this.age = age;
	}
	
	/**
	 * Set name for MovieGoer.
	 * @param name MovieGoer's name.
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Set username for MovieGoer.
	 * @param username MovieGoer's username.
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	/**
	 * Set Age for MovieGoer.
	 * @param age MovieGoer's age.
	 */
	public void setAge(int age)
	{
		this.age = age;
	}
	
	/**
	 * Set hashed password for MovieGoer.
	 * @param password MovieGoer's hashed password.
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	/**
	 * Get name for MovieGoer.
	 * @return MovieGoer's name.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Get username for MovieGoer.
	 * @return MovieGoer's username.
	 */
	public String getUsername()
	{
		return username;
	}


	/**
	 * Get hashed password for MovieGoer.
	 * @return MovieGoer's hashed password.
	 */	
	public String getPassword()
	{
		return password;
	}
	
	/**
	 * Get age for MovieGoer.
	 * @return MovieGoer's age.
	 */
	public int getAge()
	{
		return age;
	}
}
