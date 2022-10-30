//yj

import java.util.ArrayList;
import java.util.List;


public class CinemaController {
    public static List<String[]>  storage;
    public static int totalNumberOfInstances;
    public static Cinema[] createInstances(List<String[]> cinema){
        storage = cinema;
        
        //loop to create instances
        Cinema[] cinemas = new Cinema[cinema.size()];

        for(int h=1; h<cinema.size(); h++){
            int cinemaID = Integer.parseInt(cinema.get(h)[0]);
            int numberOfSeats = Integer.parseInt(cinema.get(h)[1]);
            ClassOfCinema classOfCinema = ClassOfCinema.valueOf(cinema.get(h)[2]);
            Layout layout = Layout.valueOf(cinema.get(h)[3]);
            
            cinemas[h] = new Cinema(cinemaID, numberOfSeats, classOfCinema, layout);
            totalNumberOfInstances++;
        }
        return cinemas;
    }

public void remove(String cinemaID){
    //find the corresponding ticketID and remove it from the 2D array
    //no point deleting it from the class
    for(int h=0; h<storage.size(); h++){
        if(storage.get(h)[0].equals(cinemaID)){
            storage.remove(h);
            totalNumberOfInstances--;
        }
    }
}

public void updateNumberOfSeats(Cinema[] cinemas, String cinemaID, String numberOfSeats){
    //find the corresponding ticketID and update it from the 2D array
    int location = 0;

    for(int h=0; h<storage.size(); h++){
        if(storage.get(h)[0].equals(cinemaID)){
            //find the location in 2D array
            location = h;
        }
    }

    //if we are also updating the instances, we need to do the following
    //but havent figure out how to access the object
    cinemas[location].setNumberOfSeats(Integer.parseInt(numberOfSeats));
}

//not the real version of exporting to csv
public void exportToCSV(Cinema[] cinemas){
    for(int i=0; i<totalNumberOfInstances; i++){
        //get instances from class
    }
}


}
