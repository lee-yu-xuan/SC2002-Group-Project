package src.main.java.cinema;

import java.util.ArrayList;
import java.util.List;
import src.main.java.enums.*;
import src.main.java.helper.*;


public class CinemaController {
    public static List<Cinema> cinemaList;
    public static List<String[]> cinemaCSV;

    public static void load(){
        if(cinemaList == null){
            //System.out.println("The cinemaList is empty");
            cinemaList = new ArrayList<Cinema>();
        }
    
        cinemaCSV = File_IO.readFile("cinema");

        for(int h=0; h<cinemaCSV.size(); h++){
            String cinemaID = cinemaCSV.get(h)[0];
            String cineplexName = cinemaCSV.get(h)[1];
            int numberOfSeats = Integer.parseInt(cinemaCSV.get(h)[2]);
            ClassOfCinema classOfCinema = ClassOfCinema.valueOf(cinemaCSV.get(h)[3]);
            Layout layout = Layout.valueOf(cinemaCSV.get(h)[4]);
            
            cinemaList.add(new Cinema(cinemaID, cineplexName, numberOfSeats, classOfCinema, layout));
        }
    }

    public static void add(Cinema cinema) {
        if (cinemaList == null) {
            // System.out.println("The movieList is empty");
            cinemaList = new ArrayList<Cinema>();
        }
        cinemaList.add(cinema);
    }

    public static List<Cinema> getCinemaList(){
        return cinemaList;
    }

    public static List<Cinema> getCinemaListByCineplex(String cineplexName){
        List<Cinema> cinemaListByCineplex = new ArrayList<Cinema>();
        for(int i=0; i<cinemaList.size(); i++){
            if(cinemaList.get(i).getCineplexName().equals(cineplexName)){
                cinemaListByCineplex.add(cinemaList.get(i));
            }
        }
        return cinemaListByCineplex;
    }    

public static int deleteByID(String cinemaID){
 
    for(int h=0; h<cinemaList.size(); h++){
        if(cinemaList.get(h).getCinemaID().equals(cinemaID)){
            cinemaList.remove(h); //id found
            return 1;
        }
    }
    return 0;
}

public static String[] checklayout(String cinemaID){
    String[] rowColumn = new String[2];
    for(int h=0; h<cinemaList.size(); h++){
        if(cinemaList.get(h).getCinemaID().equals(cinemaID)){
            Layout layout = cinemaList.get(h).getLayout();
            if(layout==Layout.small){
                rowColumn[0] = "5";
                rowColumn[1] = "5";
            }
            else if(layout==Layout.medium){
                rowColumn[0] = "10";
                rowColumn[1] = "10";
            }
            else if(layout==Layout.large){
                rowColumn[0] = "15";
                rowColumn[1] = "15";
            }
        }
    }
    return rowColumn;
}

public static void updateNumberOfSeats(ArrayList<Cinema> cinemas, String cinemaID, String numberOfSeats){
    //update the cinemaList

    for(int h=0; h<cinemas.size(); h++){
        if(cinemas.get(h).getCinemaID().equals(cinemaID)){
            cinemas.get(h).setNumberOfSeats(Integer.parseInt(numberOfSeats));
        }
    }
}


public static void save(){
    List<String[]> tempCSV = new ArrayList<String[]>();
        
        for(int i =0;i<cinemaList.size();i++){
            String[] temp = new String[5];
            temp[0] = String.valueOf(cinemaList.get(i).getCinemaID());
            temp[1] = cinemaList.get(i).getCineplexName();
            temp[2] = String.valueOf(cinemaList.get(i).getNumberOfSeats());
            temp[3] = cinemaList.get(i).getClassOfCinema().toString();
            temp[4] = cinemaList.get(i).getLayout().toString();
            tempCSV.add(temp);
        }
        File_IO.writeFile(tempCSV, "cinema");
}


}
