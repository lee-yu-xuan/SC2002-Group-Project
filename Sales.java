package SC2002_2;

public class Sales
{
	private String movieName;
	private String totalSales;
	
	public Sales()
	{
		this.movieName = "";
		this.totalSales = "";
	}
	
	public Sales(String movieName, String totalSales)
	{
		this.movieName = movieName;
		this.totalSales = totalSales;
	}
	
	public void setMovieName(String movieName)
	{
		this.movieName = movieName;
	}
	
	public void setSales(String totalSales)
	{
		this.totalSales = totalSales;
	}
	
	public String getMovieName()
	{
		return movieName;
	}
	
	public String getTotalSales()
	{
		return totalSales;
	}
}
