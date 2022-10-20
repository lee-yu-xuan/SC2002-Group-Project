import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

//to update the seatTaken, can concatenate to the String then update the line
public class layoutController {
    private static int noOfRows = 0;
    private static int noOfColumns = 0;
    public static ArrayList<String> seatsTaken = new ArrayList<String>();

    public static void main(String[] args) { 
        String path = "CSV/seatBooked.csv";
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            
            while((line=br.readLine())!=null){
                String[] data = line.split(",");
                int number = 1;
                int lengthOfLine = data.length;
                
                //if the line stores the data of that cinema, then store the data into relevant variables
                if(data[0].equals("6787A")){
                    noOfRows = Integer.parseInt(data[++number]);
                    noOfColumns = Integer.parseInt(data[++number]);
                    number++;
                    //store the booked seats into seatsTaken ArrayList
                    while(number<lengthOfLine){
                        seatsTaken.add(data[number]);
                        number++;
                    }

                    
                //end of storing into variable
                break;
                }
            }
            br.close();
            
            printLayout();

        } catch (Exception e) {
            System.out.println("Errow with reading the file!");
        
        }
    }

    public static void printLayout(){
           //print the layout
           char[][] Layout = new char[noOfRows][noOfColumns];
           for(int i=0; i<noOfRows; i++) {
               //System.out.println(number);number++;
               for(int j=0; j<noOfColumns; j++) {
                   Layout[i][j] = '0';
               }
           }
           for(int i=0; i<seatsTaken.size(); i++) {
               String[] seat = seatsTaken.get(i).split("&");
               int row = Integer.parseInt(seat[0])-1;
               int column = Integer.parseInt(seat[1])-1;
               Layout[row][column] = '1';
           }
           seatsTaken.clear();

           //print the layout
            int number=1;
            for(int i=0; i<noOfRows; i++) {
                //System.out.print(number+" ");number++;
                for(int j=0; j<noOfColumns; j++) {
                    System.out.print(Layout[i][j] + "  ");
                }
                System.out.println();
        }
    }
   
}
