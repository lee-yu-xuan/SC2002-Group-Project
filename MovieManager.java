import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    public static void sortByTicketSales(){
        List<Movie> movieList = MovieListing.getMovieList();
        
    }

    public static void sortByRating(){
        List<Movie> movieList = MovieListing.getMovieList();
        
    }

    public static void _InsertionSort(List<Movie> movieList, String sortby){
        int min;
		for (int index = 1; index < list.length-1; index++)
		{
			min = index;
			for (int scan = index+1; scan < list.length; scan++)
				if (list[scan].compareTo(list[min]) < 0)
					min = scan;
			// Swap the values
			temp = list[min];
			list[min] = list[index];
			list[index] = temp;
		}
    }
}
