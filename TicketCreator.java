//yj

import java.util.List;

public class TicketCreator {
    public static void main(String[] args) {
        //method name will be changed to ticket_loader() in the future
        //responsible for creating instances of MovieTicket class based on data stored in the CSV file

        String pathName = "movieTicket";
        List<String[]>  movieTicket = File_IO.readFile(pathName);
        
        //loop to create instances
        MovieTicket[] tickets = new MovieTicket[movieTicket.size()+1];

        for(int h=1; h<movieTicket.size(); h++){
            String ticketID = movieTicket.get(h)[0];
            String movieID = movieTicket.get(h)[1];
            String date = movieTicket.get(h)[2];
            String time = movieTicket.get(h)[3];
            int cinemaID = Integer.parseInt(movieTicket.get(h)[4]);
            String seatNo = movieTicket.get(h)[5];
            TypeOfTicket ticketType = TypeOfTicket.valueOf(movieTicket.get(h)[6]);
            Restriction restriction = Restriction.valueOf(movieTicket.get(h)[7]);
            
            tickets[h] = new MovieTicket(ticketID, movieID, date, time, cinemaID, seatNo, ticketType, restriction);
        }
           

    }
}
