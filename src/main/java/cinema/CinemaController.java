package src.main.java.cinema;
import java.util.ArrayList;
import java.util.List;
import src.main.java.enums.*;
import src.main.java.helper.*;

/**
 * Cinema Controller Class.
 * @author Yong Jian loke
 * @version 1.0
 * @since 2022-11-01
 */


public class CinemaController {
    public static List<Cinema> cinemaList;
    public static List<String[]> cinemaCSV;
    /**
	 * Create instance of File_IO.
	 */
    private static File_IOInterface file_IO = new CSVFile_IO();
    /**
     * Load function. Use the date from the CSV file to create the cinema objects.
     */
    public static void load(){
        if(cinemaList == null){
            //System.out.println("The cinemaList is empty");
            cinemaList = new ArrayList<Cinema>();
        }
    
        cinemaCSV = file_IO.readFile("cinema");

        for(int h=0; h<cinemaCSV.size(); h++){
            String cinemaID = cinemaCSV.get(h)[0];
            String cineplexName = cinemaCSV.get(h)[1];
            int numberOfSeats = Integer.parseInt(cinemaCSV.get(h)[2]);
            ClassOfCinema classOfCinema = ClassOfCinema.valueOf(cinemaCSV.get(h)[3]);
            Layout layout = Layout.valueOf(cinemaCSV.get(h)[4]);
            
            cinemaList.add(new Cinema(cinemaID, cineplexName, numberOfSeats, classOfCinema, layout));
        }
    }

    /**
     * Add new cinema to the cinema class(used by admin).
     * @param cinema cinema objects that the admin has typed in.
     */
    public static void add(Cinema cinema) {
        if (cinemaList == null) {
            // System.out.println("The movieList is empty");
            cinemaList = new ArrayList<Cinema>();
        }
        cinemaList.add(cinema);
    }

    /**
     * Get the list of cinema objects
     * @return the list of cinema objects
     */
    public static List<Cinema> getCinemaList(){
        return cinemaList;
    }

    /**
     * Get the list of cinemas that are belong to the cineplex
     * @param cineplexName that is linked to the cinema
     * @return List of cinema object related to the cineplex
     */
    public static List<Cinema> getCinemaListByCineplex(String cineplexName){
        List<Cinema> cinemaListByCineplex = new ArrayList<Cinema>();
        for(int i=0; i<cinemaList.size(); i++){
            if(cinemaList.get(i).getCineplexName().equals(cineplexName)){
                cinemaListByCineplex.add(cinemaList.get(i));
            }
        }
        return cinemaListByCineplex;
    }    

/**
 * For admin to delete the cinema by cinemaID.
 * @param cinemaID cinemaID that admin has typed in
 * @return Integer representation of deletion status.
 */
public static int deleteByID(String cinemaID){
 
    for(int h=0; h<cinemaList.size(); h++){
        if(cinemaList.get(h).getCinemaID().equals(cinemaID)){
            cinemaList.remove(h); //id found
            return 1;
        }
    }
    return 0;
}

/**
 * Check the size of the cinema
 * @param cinemaID cinemaID that the user has chosen
 * @return the number of rows and columns of the cinema 
 */
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

/**
 * Update the number of seats in the cinema (By the admin).
 * @param cinemas cinamas array that the function will search through
 * @param cinemaID cinemaID that the admin has chosen
 * @param numberOfSeats number of seats that the admin wants to update
 */
public static void updateNumberOfSeats(ArrayList<Cinema> cinemas, String cinemaID, String numberOfSeats){
    //update the cinemaList

    for(int h=0; h<cinemas.size(); h++){
        if(cinemas.get(h).getCinemaID().equals(cinemaID)){
            cinemas.get(h).setNumberOfSeats(Integer.parseInt(numberOfSeats));
        }
    }
}

/**
 * Return true if cinemaID exist in the CSV file.
 * @param cinemaID
 * @return success of finding cinemaID in arrayList
 */
public static boolean checkIfExist(String cinemaID){
    for(int h=0; h<cinemaList.size(); h++){
        if(cinemaList.get(h).getCinemaID().equals(cinemaID)){
            return true;
        }
    }
    return false;
}

/**
 * Check the class of cinema(Admin function)
 * @param cinemaID
 * @return
 */
public static ClassOfCinema getClassOfCinema(String cinemaID){
    ClassOfCinema classOfCinema = null;
    for(int h=0; h<cinemaList.size(); h++){
        if(cinemaList.get(h).getCinemaID().equals(cinemaID)){
            classOfCinema = cinemaList.get(h).getClassOfCinema();
        }
    }
    return classOfCinema;
}

/**
* Save function. Save the cinema objects to the CSV file.
*/
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
        file_IO.writeFile(tempCSV, "cinema");
}


}
