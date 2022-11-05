public class MovieGoer extends ConstructUser
{
	private int age;
	
	public MovieGoer()
	{
		this.type = userType.MOVIEGOER;
		this.age = 0;
		this.name = "";
		this.username = "";
		this.password = "";
	}
	
	public MovieGoer(String name, String username, String password, int age)
	{
		this.type = userType.MOVIEGOER;
		this.name = name;
		this.username = username;
		this.password = password;
		this.age = age;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public int getAge()
	{
		return age;
	}
}
