//yj

import java.util.ArrayList;
import java.util.List;


public class CinemaController {
    public static List<String[]>  storage;
    public static int totalNumberOfInstances;
    public static ArrayList<Cinema> cinemas = new ArrayList<Cinema>();

    public static ArrayList<Cinema> createInstances(List<String[]> cinema){
        storage = cinema;
        
        //loop to create instances

        for(int h=1; h<cinema.size(); h++){
            int cinemaID = Integer.parseInt(cinema.get(h)[0]);
            int numberOfSeats = Integer.parseInt(cinema.get(h)[1]);
            ClassOfCinema classOfCinema = ClassOfCinema.valueOf(cinema.get(h)[2]);
            Layout layout = Layout.valueOf(cinema.get(h)[3]);
            
            cinemas.add(new Cinema(cinemaID, numberOfSeats, classOfCinema, layout));
            totalNumberOfInstances++;
        }
        
        return cinemas;
    }

public static void remove(String cinemaID){
    //find the corresponding ticketID and remove it from the 2D array
    //no point deleting it from the class

    System.out.println("\nCinemaController.remove() is called\n");
    for(int h=0; h<storage.size(); h++){
        if(storage.get(h)[0].equals(cinemaID)){
            System.out.println("inside");
            storage.remove(h);
            totalNumberOfInstances--;
        }
    }

    //print storage
    for(int h=0; h<storage.size(); h++){
        for(int i=0; i<storage.get(h).length; i++){
            System.out.print(storage.get(h)[i] + " ");
        }
        System.out.println();
    }
}

public static void updateNumberOfSeats(ArrayList<Cinema> cinemas, String cinemaID, String numberOfSeats){
    //find the corresponding ticketID and update it from the 2D array
    int location = 0;

    for(int h=0; h<storage.size(); h++){
        if(storage.get(h)[0].equals(cinemaID)){
            //find the location in 2D array
            storage.get(h)[1] = numberOfSeats;  //update the seats in the 2d array
            location = h;
        }
    }

    cinemas.get(location).setNumberOfSeats(Integer.parseInt(numberOfSeats));
}


public static void exportToCSV(){
    //export according to the storage original 2d array
    File_IO.writeFile(storage, "cinema");
}


}
