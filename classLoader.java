//yj

import java.util.List;

public class classLoader {

    public void LoadTicket() {
        String pathName = "movieTicket";
        List<String[]>  movieTicket = File_IO.readFile(pathName);

        //throw the 2darray to MovieTicketController
        MovieTicketController.createInstances(movieTicket);
    }

    public void LoadCinema(){
        String pathName = "cinema";
        List<String[]>  cinema = File_IO.readFile(pathName);
        
        //throw the 2darray to CinemaController
        CinemaController.createInstances(cinema);
    }

   
}
