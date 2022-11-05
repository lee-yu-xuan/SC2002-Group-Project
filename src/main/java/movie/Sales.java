public class Sales
{
	private String movieID;
	private int totalSales;
	
	public Sales()
	{
		this.movieID = "";
		this.totalSales = 0;
	}
	
	public Sales(String movieID, int totalSales)
	{
		this.movieID = movieID;
		this.totalSales = totalSales;
	}
	
	public void setmovieID(String movieID)
	{
		this.movieID = movieID;
	}
	
	public void setSales(int totalSales)
	{
		this.totalSales = totalSales;
	}
	
	public void addSales(){
		this.totalSales++;
	}
	
	public String getMovieID()
	{
		return movieID;
	}
	
	public int getTotalSales()
	{
		return totalSales;
	}
}
