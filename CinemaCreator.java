import java.util.List;


public class CinemaCreator {
    public static void main(String[] args) {
        //method name will be changed to ticket_loader() in the future
        //responsible for creating instances of Cinema class based on data stored in the CSV file

        String pathName = "cinema";
        List<String[]>  cinema = File_IO.readFile(pathName);
        
        //loop to create instances
        Cinema[] cinemas = new Cinema[cinema.size()+1];

        for(int h=1; h<cinema.size(); h++){
            int cinemaID = Integer.parseInt(cinema.get(h)[0]);
            int numberOfSeats = Integer.parseInt(cinema.get(h)[1]);
            ClassOfCinema classOfCinema = ClassOfCinema.valueOf(cinema.get(h)[2]);
            Layout layout = Layout.valueOf(cinema.get(h)[3]);
            
            cinemas[h] = new Cinema(cinemaID, numberOfSeats, classOfCinema, layout);
        }
           

    }
}
