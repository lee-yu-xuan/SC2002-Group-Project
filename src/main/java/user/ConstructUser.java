package src.main.java.user;

import src.main.java.enums.*;
/**
 * User Class, superclass for both Staff and MovieGoer.
 * @author Lester Lee
 * @version 1.0
 * @since 2022-11-01
 */
public abstract class ConstructUser
{
	/**
	 * Default constructor for user.
	 */
	// constructor
	public ConstructUser() {
	}

	/**
	 * The name of user.
	 */
	protected String name;
	/**
	 * The username of user.
	 */
	protected String username;
	/**
	 * The hashed password of user.
	 */
	protected String password;
	/**
	 * The type of user, Staff or MovieGoer.
	 */
	protected UserType type;
}
