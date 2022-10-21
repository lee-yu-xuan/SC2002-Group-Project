package SC2002Project;

public class Booking
{
	private String transactionID;
	private String name;
	private String mobileNumber;
	
	public Booking(String transactionID, String name, String mobileNumber)
	{
		this.transactionID = transactionID;
		this.name = name;
		this.mobileNumber = mobileNumber;
		//File IO into database
	}
}
