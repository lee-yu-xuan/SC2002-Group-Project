package src.main.java.booking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import src.main.java.enums.*;
import src.main.java.helper.*;

/**
 * A MovieTicketController class.
 * 
 * @author Yong Jian Loke
 * @version 1.0
 * @since 2022-11-01
 */
public class MovieTicketController {
    public static List<MovieTicket> ticketList;
    public static List<String[]> ticketCSV;

    /**
     * Load all tickets that has been booked.
     */
    public static void load() {
        if (ticketList == null) {
            // System.out.println("The ticketList is empty");
            ticketList = new ArrayList<MovieTicket>();
        }

        ticketCSV = File_IO.readFile("movieTicket");

        for (int h = 0; h < ticketCSV.size(); h++) {
            String ticketID = ticketCSV.get(h)[0];
            String movieID = ticketCSV.get(h)[1];
            String dateTime = ticketCSV.get(h)[2];
            String cinemaID = ticketCSV.get(h)[3];
            String seatNo = ticketCSV.get(h)[4];
            TypeOfTicket ticketType = TypeOfTicket.valueOf(ticketCSV.get(h)[5]);
            Restriction restriction = Restriction.valueOf(ticketCSV.get(h)[6]);

            ticketList
                    .add(new MovieTicket(ticketID, movieID, LocalDateTime.parse(dateTime, _DateTimeFormatter.formatter),
                            cinemaID, seatNo, ticketType, restriction));
        }
    }

    /**
     * Add ticket to list of movie tickets.
     */
    public static void add(MovieTicket ticket) {
        if (ticketList == null) {
            // System.out.println("The ticketList is empty");
            ticketList = new ArrayList<MovieTicket>();
        }
        ticketList.add(ticket);
    }

    /**
     * Remove a Ticket.
     * 
     * @param ticketID Ticket ID to be removed.
     * @return Status of deletion.
     */
    public static int deleteByID(String ticketID) {

        for (int h = 0; h < ticketList.size(); h++) {
            if (ticketList.get(h).getTicketID() == (ticketID)) {
                ticketList.remove(h);
                return 1;
            }
        }
        return 0;
    }

    /**
     * Get the ticket type of a particular movie.
     * 
     * @param movieID ID of the movie.
     * @return String of the ticketType.
     */
    public static String getTicketType(String movieID) {
        String ticketType = "";
        for (int h = 0; h < ticketList.size(); h++) {
            if (ticketList.get(h).getMovieID() == (movieID)) {
                ticketType = ticketList.get(h).getTicketType().toString();
            }
        }
        return ticketType;
    }

    /**
     * Save changes made to ticket list to database.
     */
    public static void save() {
        List<String[]> tempCSV = new ArrayList<String[]>();

        for (int i = 0; i < ticketList.size(); i++) {
            String[] temp = new String[7];
            temp[0] = ticketList.get(i).getTicketID();
            temp[1] = ticketList.get(i).getMovieID();
            LocalDateTime dateTime = ticketList.get(i).getDateTime();
            temp[2] = dateTime.format(_DateTimeFormatter.formatter);
            temp[3] = ticketList.get(i).getcinemaID();
            temp[4] = ticketList.get(i).getSeatNo();
            temp[5] = ticketList.get(i).getTicketType().toString();
            temp[6] = ticketList.get(i).getRestriction().toString();
            tempCSV.add(temp);
        }
        File_IO.writeFile(tempCSV, "movieTicket");
    }

}
