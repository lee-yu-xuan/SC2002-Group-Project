//yj

import java.util.ArrayList;
import java.util.List;


public class CinemaController {
    public static List<Cinema> cinemaList;
    public static List<String[]> cinemaCSV;

    public static void load(){
        if(cinemaList == null){
            System.out.println("The cinemaList is empty");
            cinemaList = new ArrayList<Cinema>();
        }
    
        cinemaCSV = File_IO.readFile("cinema");

        for(int h=0; h<cinemaCSV.size(); h++){
            int cinemaID = Integer.parseInt(cinemaCSV.get(h)[0]);
            int numberOfSeats = Integer.parseInt(cinemaCSV.get(h)[1]);
            ClassOfCinema classOfCinema = ClassOfCinema.valueOf(cinemaCSV.get(h)[2]);
            Layout layout = Layout.valueOf(cinemaCSV.get(h)[3]);
            
            cinemaList.add(new Cinema(cinemaID, numberOfSeats, classOfCinema, layout));
        }
    }

public static int deleteByID(String cinemaID){
 
    for(int h=0; h<cinemaList.size(); h++){
        if(cinemaList.get(h).getCinemaID() == Integer.parseInt(cinemaID)){
            cinemaList.remove(h); //id found
            return 1;
        }
    }
    return 0;
}

public static void updateNumberOfSeats(ArrayList<Cinema> cinemas, String cinemaID, String numberOfSeats){
    //update the cinemaList

    for(int h=0; h<cinemas.size(); h++){
        if(cinemas.get(h).getCinemaID() == Integer.parseInt(cinemaID)){
            cinemas.get(h).setNumberOfSeats(Integer.parseInt(numberOfSeats));
        }
    }
}


public static void exportToCSV(){
    List<String[]> tempCSV = new ArrayList<String[]>();
        
        for(int i =0;i<cinemaList.size();i++){
            String[] temp = new String[4];
            temp[0] = String.valueOf(cinemaList.get(i).getCinemaID());
            temp[1] = String.valueOf(cinemaList.get(i).getNumberOfSeats());
            temp[2] = cinemaList.get(i).getClassOfCinema().toString();
            temp[3] = cinemaList.get(i).getLayout().toString();
            tempCSV.add(temp);
        }
        File_IO.writeFile(tempCSV, "cinema");
}


}