//yj

import java.util.ArrayList;
import java.util.List;

public class MovieTicketController {
public static List<String[]>  storage;
public static ArrayList<MovieTicket> tickets = new ArrayList<MovieTicket>();


public static void createInstances(List<String[]> movieTicket){
    storage = movieTicket;

   //loop to create instances

   for(int h=1; h<movieTicket.size(); h++){
       String ticketID = movieTicket.get(h)[0];
       String movieID = movieTicket.get(h)[1];
       String date = movieTicket.get(h)[2];
       String time = movieTicket.get(h)[3];
       int cinemaID = Integer.parseInt(movieTicket.get(h)[4]);
       String seatNo = movieTicket.get(h)[5];
       TypeOfTicket ticketType = TypeOfTicket.valueOf(movieTicket.get(h)[6]);
       Restriction restriction = Restriction.valueOf(movieTicket.get(h)[7]);
       
       tickets.add(new MovieTicket(ticketID, movieID, date, time, cinemaID, seatNo, ticketType, restriction));
   }
}

public static void remove(String ticketID){


    //find the corresponding ticketID and remove it from the 2D array
    for(int h=0; h<storage.size(); h++){
        if(storage.get(h)[0].equals(ticketID)){
            storage.remove(h);
        }
    }
}


public static void exportToCSV(){
    //export according to the storage original 2d array
    File_IO.writeFile(storage, "movieTicket");
}



}
