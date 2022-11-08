package src.main.java.movie;
/**
 * A MovieListing Class.
 * @author Lee Yu Xuan
 * @version 1.0
 * @since 2022-11-01
 */
public class Sales
{
	private String movieID;
	private int totalSales;
	
	/**
	* Constructor of Review class.
	*/
	public Sales()
	{
		this.movieID = "";
		this.totalSales = 0;
	}
	/**
  * Constructor of Review class.
  * @param movieID String movie ID
	* @param totalSales	Int total sales of the movie
  */	
	public Sales(String movieID, int totalSales)
	{
		this.movieID = movieID;
		this.totalSales = totalSales;
	}
	/**
	 * @param movieID String movie ID
	 */
	public void setmovieID(String movieID)
	{
		this.movieID = movieID;
	}
	/**
	 * @param totalSales int total sales
	 */
	public void setSales(int totalSales)
	{
		this.totalSales = totalSales;
	}
	/**
	 * increases the total sales by 1
	 */
	public void addSales(){
		this.totalSales++;
	}
	/**
	 * @return the movie id
	 */
	public String getMovieID()
	{
		return movieID;
	}
	/**
	 * @return return the totalSales
	 */
	public int getTotalSales()
	{
		return totalSales;
	}
}
