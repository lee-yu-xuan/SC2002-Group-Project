package SC2002_2;

import java.util.ArrayList;
import java.util.List;

public class SalesManager
{
	private static List<Sales> salesList;
	private static List<String[]> salesCSV;
	
	public static List<Sales> getSalesList()
	{
		return salesList;
	}
	
	public static void add(Sales sales)
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
	
	public static void load()
	{
		if(salesList == null)
		{
			System.out.println("The salesList is empty");
			salesList = new ArrayList<Sales>();
		}
		
		salesCSV = File_IO.readFile("movieSalesRanking");
		
		for(int i=0 ; i<salesCSV.size() ; i++) //search for existing entry and update total sales
		{
			String movieName = salesCSV.get(i)[0];
			String totalSale = salesCSV.get(i)[1];
			salesList.add(new Sales(movieName, totalSale));
		}
	}
	
	public static void save()
	{
		List<String[]> tempCSV = new ArrayList<String[]>();
		
		for(int i=0 ; i<salesList.size(); i++)
		{
			String[] temp = new String[2];
			temp[0] = salesList.get(i).getMovieName();
			temp[1] = salesList.get(i).getTotalSales();
			tempCSV.add(temp);
		}
		File_IO.writeFile(tempCSV, "movieSalesRanking");
	}
}
