//yj

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//to update the seatTaken, can concatenate to the String then update the line
public class LayoutController {
    private static int noOfRows = 0;
    private static int noOfColumns = 0;
     
//public void displayLayout
    public void displayLayout(String cinemaID, String timing) {
        String pathName = "seatBooked";
        List<String[]>  movieList = File_IO.readFile(pathName);
        String seatsTaken = "";
        int flag = 0;

        for(int i = 0; i < movieList.size(); i++){
            //get the 2 variable: cinemaID and timing of the movie
            if(movieList.get(i)[0].equals(cinemaID) && movieList.get(i)[5].equals(timing)){
                noOfRows = Integer.parseInt(movieList.get(i)[2]);
                noOfColumns = Integer.parseInt(movieList.get(i)[3]);
                seatsTaken = movieList.get(i)[4];

                List<String> items = Arrays.asList(seatsTaken.split("&"));

           //initialize layout
           char[][] Layout = new char[noOfRows][noOfColumns];
           for(i=0; i<noOfRows; i++) {
               //System.out.println(number);number++;
               for(int j=0; j<noOfColumns; j++) {
                   Layout[i][j] = '0';
               }
           }

           //mark the layout with the seats taken
              for(i=0; i<items.size(); i++) {
                String[] temp = items.get(i).split("!");
                int row = Integer.parseInt(temp[0])-1;
                int column = Integer.parseInt(temp[1])-1;
                Layout[row][column] = 'X';
              }

            //print layout
            for(i=0; i<noOfRows; i++) {
                for(int j=0; j<noOfColumns; j++) {
                    System.out.print(Layout[i][j]+" ");
                }
                System.out.println();
            }


                flag = 1;
                break;
            }
        }
        if(flag==0){
            System.out.println("No such movie or timing");
        }
    }

   
   
}
