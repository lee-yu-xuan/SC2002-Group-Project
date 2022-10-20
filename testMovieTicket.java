import java.io.BufferedReader;
import java.io.FileReader;

public class testMovieTicket {
    public static void main(String[] args) {
        String path = "/Users/yongjian/Documents/GitHub/cinema_booking_system/CSV/movieTicket.CSV";
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            
            while((line=br.readLine())!=null){
                String[] data = line.split(",");
                System.out.println(data[0]);
            }

        } catch (Exception e) {
            System.out.println("Errow with reading the file!");
        }

    }
}
