package src.main.java.booking;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * A Layout Controller class.
 * @author Yong Jian Loke
 * @version 1.0
 * @since 2022-11-01
 */
//to update the seatTaken, can concatenate to the String then update the line
public class LayoutController {
    private static int noOfRows = 0;
    private static int noOfColumns = 0;

    /**
     * Print the layout of the cinema of a particular movie.
     * @param cinemaID CinemaID of the movie.
     * @param timing DateTime of the movie.
     */
    // public void displayLayout
    public static void displayLayout(String cinemaID, LocalDateTime timing) {

        List<SeatBooked> movieList = SeatBooked_Controller.getSeatBooked();
        String seatsTaken = "";
        int flag = 0;

        for (int i = 0; i < movieList.size(); i++) {
            // get the 2 variable: cinemaID and timing of the movie
            LocalDateTime dt1 = movieList.get(i).getTiming();
            LocalDateTime dt2 = timing;
            String tmpCinemaID = movieList.get(i).getCinemaID();

            if (tmpCinemaID.compareTo(cinemaID) == 0 && dt1.compareTo(dt2) == 0) {
                noOfRows = movieList.get(i).getNoOfRows();
                noOfColumns = movieList.get(i).getNoOfColumns();
                seatsTaken = movieList.get(i).getSeatsTaken();
         
                List<String> items = Arrays.asList(seatsTaken.split("&"));

                // initialize layout
                char[][] Layout = new char[noOfRows][noOfColumns];
                for (i = 0; i < noOfRows; i++) {
                    // System.out.println(number);number++;
                    for (int j = 0; j < noOfColumns; j++) {
                        Layout[i][j] = '0';
                    }
                }

                // mark the layout with the seats taken
                if(seatsTaken.equals("")){
                    int continued = 1;
                }else{
                    for (i = 0; i < items.size(); i++) {
                        String[] temp = items.get(i).split("!");
                        int row = Integer.parseInt(temp[0]) - 1;
                        int column = Integer.parseInt(temp[1]) - 1;
                        Layout[row][column] = 'X';
                    }
                }
                

                // print layout
                System.out.println("\nCinema layout");
                System.out.println("--------------------");
                System.out.print("col:\t");
                for (i = 1; i <= Layout.length; i++)
                    System.out.printf("  %d ", i);
                System.out.println();
                for (i = 0; i < noOfRows; i++) {
                    System.out.printf("row: %d\t|", i + 1);
                    for (int j = 0; j < noOfColumns; j++) {
                        System.out.print(" " + Layout[i][j] + " |");
                    }
                    System.out.println();
                }

                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println("No such movie or timing");
        }
    }

    /**
     * Check if the seat has been previously booked.
     * @param row Row of the seat.
     * @param column Col of the seat.
     * @param cinemaID CinemaID of the booking.
     * @param timing DateTime of the movie.
     * @return True, False of seat status.
     */
    public static boolean checkIfDuplicateSeats(int row, int column, String cinemaID, LocalDateTime timing) {
        // check if duplicate seats
        List<SeatBooked> movieList = SeatBooked_Controller.getSeatBooked();
        String seatsTaken = "";
        for (int i = 0; i < movieList.size(); i++) {
            // get the 2 variable: cinemaID and timing of the movie
            String tmpCinemaID = movieList.get(i).getCinemaID();
            LocalDateTime dt1 = movieList.get(i).getTiming();
            if (tmpCinemaID.compareTo(cinemaID) == 0 && dt1.compareTo(timing) == 0) {
                seatsTaken = movieList.get(i).getSeatsTaken();
                if(seatsTaken.equals("")){
                    return false;
                }
                List<String> items = Arrays.asList(seatsTaken.split("&"));
                for (int j = 0; j < items.size(); j++) {
                    String[] temp = items.get(j).split("!");
                    int tmpRow = Integer.parseInt(temp[0]);
                    int tmpColumn = Integer.parseInt(temp[1]);
                    if (tmpRow == row && tmpColumn == column) {
                        System.out.println("Seat already taken");
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

