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
	
	public static void load()
	{
		if(salesList == null)
		{
			System.out.println("The salesList is empty");
			salesList = new ArrayList<Sales>();
		}
		
		salesCSV = File_IO.readFile("movieSales");
		
		for(int i=0 ; i<salesCSV.size() ; i++) //search for existing entry and update total sales
		{
			String movieID = salesCSV.get(i)[0];
			int totalSale = Integer.parseInt(salesCSV.get(i)[1]);
			salesList.add(new Sales(movieID, totalSale));
		}
	}
	
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
		File_IO.writeFile(tempCSV, "movieSales");
	}
}
