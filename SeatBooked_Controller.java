import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SeatBooked_Controller {
public static List<SeatBooked> seatBookedList;
public static List<String[]> seatBookedCSV;

public static void load(){ 
    if(seatBookedList == null){
        System.out.println("The seatBookedList is empty");
        seatBookedList = new ArrayList<SeatBooked>();
    }

    seatBookedCSV = File_IO.readFile("seatBooked");

   for(int h=0; h<seatBookedCSV.size(); h++){
       String cinemaID = seatBookedCSV.get(h)[0];
       String layoutType = seatBookedCSV.get(h)[1];
       int noOfRows = Integer.parseInt(seatBookedCSV.get(h)[2]);
       int noOfColumns = Integer.parseInt(seatBookedCSV.get(h)[3]);
       String seatsTaken = seatBookedCSV.get(h)[4];
       String time = seatBookedCSV.get(h)[5];

       SeatBooked seatBooked = new SeatBooked(cinemaID,
                                             layoutType,
                                             noOfRows,
                                             noOfColumns,
                                             seatsTaken,
                                             LocalDateTime.parse(time,_DateTimeFormatter.formatter));
       //LocalDateTime timing = LocalDateTime.parse(time,_DateTimeFormatter.formatter);
       
       seatBookedList.add(seatBooked);
   }

}

public static void updateSeatBooked(int newBookedSeats_row, int newBookedSeats_column, String cinemaID, LocalDateTime timing){
    String oldBookedSeat = ""; int location = 0;
    
    for(int i=0; i<seatBookedList.size(); i++){
        if(seatBookedList.get(i).getCinemaID().equals(cinemaID) && seatBookedList.get(i).getTiming().compareTo(timing)==0){
            oldBookedSeat = seatBookedList.get(i).getSeatsTaken();
            location = i;
        }
    }

    //convert int to string
    String row = Integer.toString(newBookedSeats_row);
    String col = Integer.toString(newBookedSeats_column);

    //append the newBookedSeats to the oldBookedSeat String
    String updatedBookedSeats = oldBookedSeat + "&" + row + "!" + col;

    //update the seatBookedList
    seatBookedList.get(location).setSeatsTaken(updatedBookedSeats);
        
}

public static List<SeatBooked> getSeatBooked(){
    return seatBookedList;
}

public static void save(){
    List<String[]> tempCSV = new ArrayList<String[]>();
    
    for(int i =0;i<seatBookedList.size();i++){
        String[] temp = new String[6];
        temp[0] = seatBookedList.get(i).getCinemaID();
        temp[1] = seatBookedList.get(i).getLayoutType();
        temp[2] = Integer.toString(seatBookedList.get(i).getNoOfRows());
        temp[3] = Integer.toString(seatBookedList.get(i).getNoOfColumns());
        temp[4] = seatBookedList.get(i).getSeatsTaken();
        temp[5] = seatBookedList.get(i).getTiming().toString();
        tempCSV.add(temp);
    }
    File_IO.writeFile(tempCSV, "seatBookedList");
}
}
