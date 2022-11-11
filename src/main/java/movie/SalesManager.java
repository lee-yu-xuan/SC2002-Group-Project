package src.main.java.movie;

import java.util.ArrayList;
import java.util.List;
import src.main.java.helper.*;
/**
 * A SalesManager Class.
 * @author Yu Xuan Lee
 * @version 1.0
 * @since 2022-11-01
 */
public class SalesManager
{
	private static List<Sales> salesList;
	private static List<String[]> salesCSV;
	/**
	 * Create instance of File_IO.
	 */
	private static File_IOInterface file_IO = new CSVFile_IO();
	
	/**
	 * @return a list of movie sales
	 */
	public static List<Sales> getSalesList()
	{
		return salesList;
	}
	/**
	 * increase the sale of a specific movie by ID
	 * @param movieID String of movieID
	 */
	public static void addSalesByID(String movieID){
		if(salesList == null){
            System.out.println("The salesList is empty");
            salesList = new ArrayList<Sales>();
        }

		for(int i=0 ; i<salesList.size() ; i++)
		{
			if(salesList.get(i).getMovieID().equals(movieID))
			{
				salesList.get(i).addSales();
				return;
			}
		}
		
		//Movie haven't made any sales, create new entries and + 1
		salesList.add(new Sales(movieID,1));
	}
	/**
	 * increase the sale of a specific movie by ID
	 * @param movieID String of movieID
	 * @return the number of sales from a specific movie
	 */
	public static int getSalesByID(String movieID){
		if(salesList == null){
            return -1;
        }
		for(int i=0 ; i<salesList.size() ; i++)
		{
			if(salesList.get(i).getMovieID().equals(movieID))
			{
				return salesList.get(i).getTotalSales();
			}
		}
        return -1;
	}
	/** 
	//a function to add Sales by Name. Deprecated for now.
	public static void addByName(Sales sales)
	{
		if(salesList == null)
		{
			System.out.println("The salesList is empty");
			salesList = new ArrayList<Sales>();
		}
		
		for(int i=0 ; i<salesList.size() ; i++)
		{
			if(salesList.get(i).getMovieName() == sales.getMovieName())
			{
				int currentSales = Integer.parseInt(salesList.get(i).getTotalSales());
				currentSales += Integer.parseInt(salesList.get(i).getTotalSales());
				salesList.get(i).setSales(String.valueOf(currentSales));
				return;
			}
		}
		
		salesList.add(sales); //if no match found, create a new entry
	}
	**/
	  /**
     * Load the content of sale list CSV into the system
     */ 
	public static void load()
	{
		if(salesList == null)
		{
			//System.out.println("The salesList is empty");
			salesList = new ArrayList<Sales>();
		}
		
		salesCSV = file_IO.readFile("movieSales");
		
		for(int i=0 ; i<salesCSV.size() ; i++) //search for existing entry and update total sales
		{
			String movieID = salesCSV.get(i)[0];
			int totalSale = Integer.parseInt(salesCSV.get(i)[1]);
			salesList.add(new Sales(movieID, totalSale));
		}
	}
	/**
  * Save the content of the system into the sale list CSV
  */	
	public static void save()
	{
		List<String[]> tempCSV = new ArrayList<String[]>();
		
		for(int i=0 ; i<salesList.size(); i++)
		{
			String[] temp = new String[2];
			temp[0] = salesList.get(i).getMovieID();
			temp[1] = Integer.toString(salesList.get(i).getTotalSales());
			tempCSV.add(temp);
		}
		file_IO.writeFile(tempCSV, "movieSales");
	}
}
