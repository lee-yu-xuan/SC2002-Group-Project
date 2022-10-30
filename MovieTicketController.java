//yj

import java.util.ArrayList;
import java.util.List;

public class MovieTicketController {
public static List<String[]>  storage;

public static void createInstances(List<String[]> movieTicket){
    storage = movieTicket;

   //loop to create instances
   MovieTicket[] tickets = new MovieTicket[movieTicket.size()];

   for(int h=1; h<movieTicket.size(); h++){
       String ticketID = movieTicket.get(h)[0];
       String movieID = movieTicket.get(h)[1];
       String date = movieTicket.get(h)[2];
       String time = movieTicket.get(h)[3];
       int cinemaID = Integer.parseInt(movieTicket.get(h)[4]);
       String seatNo = movieTicket.get(h)[5];
       TypeOfTicket ticketType = TypeOfTicket.valueOf(movieTicket.get(h)[6]);
       Restriction restriction = Restriction.valueOf(movieTicket.get(h)[7]);
       
       tickets[h] = new MovieTicket(ticketID, movieID, date, time, cinemaID, seatNo, ticketType, restriction);
   }
}

public void remove(String ticketID){


    //find the corresponding ticketID and remove it from the 2D array
    for(int h=0; h<storage.size(); h++){
        if(storage.get(h)[0].equals(ticketID)){
            storage.remove(h);
        }
    }
}

//not the real version of exporting to csv
public void exportToCSV(){
    ArrayList<String> tmpHolder = new ArrayList<String>();
    for(int i=0; i<storage.size(); i++){
        for(int j=0; j<storage.get(i).length; j++){
            tmpHolder.add(storage.get(i)[j]);
        }
    }

    //convert the arraylist to string array
    String[] array = tmpHolder.toArray(new String[tmpHolder.size()]);

    //put all string[] into 2D array
    List<String[]> twoDlist = new ArrayList<String[]>();
    for(int i=0; i<array.length; i++){
        twoDlist.add(new String[]{array[i]});
    }
}



}
