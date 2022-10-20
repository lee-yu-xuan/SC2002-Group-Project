import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.opencsv.*;


//to update the seatTaken, can concatenate to the String then update the line
public class File_IO {
  
    public static ArrayList<String> seatsTaken = new ArrayList<String>();
    
    public static List<String[]> readFile(String pathName) { 
        
        String path = "CSV/"+pathName+".csv";
        String line = "";
        List<String[]> twoDlist = new ArrayList<String[]>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            
            while((line=br.readLine())!=null){
                String[] data = line.split(",");
                twoDlist.add(data);
            }
            br.close();

        } catch (Exception e) {
            System.out.println("Error with reading the file!");
        
        }
        return twoDlist;
    }

    public static void writeFile(List<String[]>  twoDList, String pathName){
        String path = "CSV/"+pathName+".csv";
        File file = new File(path);
        

        try {
            FileWriter outputfile = new FileWriter(file); 
            CSVWriter writer = new CSVWriter(outputfile, CSVWriter.DEFAULT_SEPARATOR , CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
            writer.writeAll(twoDList);
           

            writer.close();
        } catch (Exception e) {
            System.out.println("Error with writing the file!");
        }
    }
   
}
