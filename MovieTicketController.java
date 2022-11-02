//yj

import java.time.LocalDateTime;
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
       String dateTime = ticketCSV.get(h)[2];
       String cinemaID = ticketCSV.get(h)[3];
       String seatNo = ticketCSV.get(h)[4];
       TypeOfTicket ticketType = TypeOfTicket.valueOf(ticketCSV.get(h)[5]);
       Restriction restriction = Restriction.valueOf(ticketCSV.get(h)[6]);
       
       ticketList.add(new MovieTicket(ticketID, movieID, LocalDateTime.parse(dateTime,_DateTimeFormatter.formatter), cinemaID, seatNo, ticketType, restriction));
   }
}

public static void add(MovieTicket ticket){
    if(ticketList == null){
        System.out.println("The ticketList is empty");
        ticketList = new ArrayList<MovieTicket>();
    }
    ticketList.add(ticket);
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

public static TypeOfTicket getTicketType(String movieID){
    TypeOfTicket ticketType;
    for(int h=0; h<ticketList.size(); h++){
        if(ticketList.get(h).getMovieID()==(movieID)){
            ticketType = ticketList.get(h).getTicketType();
        }
    }
    return ticketType;
}

public static void save(){
    List<String[]> tempCSV = new ArrayList<String[]>();
    
    for(int i =0;i<ticketList.size();i++){
        String[] temp = new String[7];
        temp[0] = ticketList.get(i).getTicketID();
        temp[1] = ticketList.get(i).getMovieID();
        temp[2] = ticketList.get(i).getDateTime().formatted(_DateTimeFormatter.formatter);
        temp[3] = ticketList.get(i).getcinemaID();
        temp[4] = ticketList.get(i).getSeatNo();
        temp[5] = ticketList.get(i).getTicketType().toString();
        temp[6] = ticketList.get(i).getRestriction().toString();
        tempCSV.add(temp);
    }
    File_IO.writeFile(tempCSV, "movieTicket");
}

}
