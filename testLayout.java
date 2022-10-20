import java.util.*;

public class testLayout {
    static Scanner sc = new Scanner(System.in);
    private static int noOfRows = 9;
    private static int noOfColumns = 17;

    public static void main(String[] args) {
        System.out.println("<<Cinema layout>>");
        System.out.println("X: Seats that are blocked");
        System.out.println("0: Seats that are currently free");
        System.out.println("1: Seats that are currently taken");
        //System.out.println("1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17");
        System.out.println(" ");

        //add the seats that have already been taken
        //the next step this info will come from file I/O
        ArrayList<String> seatsTaken = new ArrayList<String>();
        seatsTaken.add("8,3");
        seatsTaken.add("4,3");

        //add the seats that are not abled to be booked in nature
        ArrayList<String> blockedSeats = new ArrayList<String>();
        blockedSeats.add("0,0");
        blockedSeats.add("0,1");
        blockedSeats.add("1,0");
        blockedSeats.add("1,1");
        blockedSeats.add("2,0");
        blockedSeats.add("2,1");


        //create the layout
        char[][] firstLayout = new char[noOfRows][noOfColumns];
        for(int i=0; i<noOfRows; i++) {
            //System.out.println(number);number++;
            for(int j=0; j<noOfColumns; j++) {
                firstLayout[i][j] = '0';
            }
        }

        //mark the blocked seats
        for(int i=0; i<blockedSeats.size(); i++) {
            String[] temp = blockedSeats.get(i).split(",");
            int row = Integer.parseInt(temp[0]);
            int column = Integer.parseInt(temp[1]);
            firstLayout[row][column] = 'x';
        }

        //mark the seats taken
        for(int i=0; i<seatsTaken.size(); i++) {
            String[] seat = seatsTaken.get(i).split(",");
            int row = Integer.parseInt(seat[0]);
            int column = Integer.parseInt(seat[1]);
            firstLayout[row][column] = '1';
        }
        seatsTaken.clear();

    

        //print the layout
        int number=0;
        for(int i=0; i<noOfRows; i++) {
            System.out.print(number+" ");number++;
            for(int j=0; j<noOfColumns; j++) {
                System.out.print(firstLayout[i][j] + "  ");
            }
            System.out.println();
        }

        //ask user to select a seats
        char row;
        char column;
        System.out.println("Please select a seat");
        System.out.println("Enter the row number");
        row = sc.next().charAt(0);
        System.out.println("Enter the column number");
        column = sc.next().charAt(0);
        String tmp = row + "," + column;
        seatsTaken.add(tmp);

        //mark the seats taken
        for(int i=0; i<seatsTaken.size(); i++) {
            String[] seat = seatsTaken.get(i).split(",");
            int row_t = Integer.parseInt(seat[0]) - 1;
            int column_t = Integer.parseInt(seat[1]) - 1;
            firstLayout[row_t][column_t] = '1';
        }

        number = 0;
        //print the new layout
        for(int i=0; i<noOfRows; i++) {
            System.out.print(number+" ");number++;
            for(int j=0; j<noOfColumns; j++) {
                System.out.print(firstLayout[i][j] + "  ");
            }
            System.out.println();
        }

    }
}
