//yj

import java.util.ArrayList;
import java.util.List;

public class MovieTicketController {
public static List<MovieTicket> ticketList;
public static List<String[]> ticketCSV;



public static void load(){ 
    if(ticketList == null){
        System.out.println("The ticketList is empty");
        ticketList = new ArrayList<MovieTicket>();
    }

    ticketCSV = File_IO.readFile("movieTicket");


   for(int h=0; h<ticketCSV.size(); h++){
       String ticketID = ticketCSV.get(h)[0];
       String movieID = ticketCSV.get(h)[1];
       String date = ticketCSV.get(h)[2];
       String time = ticketCSV.get(h)[3];
       String cinemaID = ticketCSV.get(h)[4];
       String seatNo = ticketCSV.get(h)[5];
       TypeOfTicket ticketType = TypeOfTicket.valueOf(ticketCSV.get(h)[6]);
       Restriction restriction = Restriction.valueOf(ticketCSV.get(h)[7]);
       
       ticketList.add(new MovieTicket(ticketID, movieID, date, time, cinemaID, seatNo, ticketType, restriction));
   }
}

public static int deleteByID(String ticketID){

    for(int h=0; h<ticketList.size(); h++){
        if(ticketList.get(h).getTicketID()==(ticketID)){
            ticketList.remove(h);
            return 1;
        }
    }
    return 0;
    }



public static void save(){
    List<String[]> tempCSV = new ArrayList<String[]>();
    
    for(int i =0;i<ticketList.size();i++){
        String[] temp = new String[8];
        temp[0] = ticketList.get(i).getTicketID();
        temp[1] = ticketList.get(i).getMovieID();
        temp[2] = ticketList.get(i).getDate();
        temp[3] = ticketList.get(i).getTime();
        temp[4] = ticketList.get(i).getcinemaID();
        temp[5] = ticketList.get(i).getSeatNo();
        temp[6] = ticketList.get(i).getTicketType().toString();
        temp[7] = ticketList.get(i).getRestriction().toString();
        tempCSV.add(temp);
    }
    File_IO.writeFile(tempCSV, "movieTicket");
}

}
