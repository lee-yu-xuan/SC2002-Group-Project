import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) throws Exception {
        List<String[]> movieCSV = File_IO.readFile("testMovieList");
        System.out.println(movieCSV.size());
        System.out.println();
        for(int i =0;i<movieCSV.size();i++){
            System.out.println(movieCSV.get(i).length);
            for(int j = 0;j<movieCSV.get(i).length;j++){
                System.out.println(movieCSV.get(i)[j]);
            }
        }
    }
    public static void main4(String[] args) {
        
        List<String[]> temp = new ArrayList(); 
        while(true){
            String[] data = new String[2];
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Title");
            String input = sc.nextLine();
            if(input.charAt(0) == '#'){
                break;
            }
            data[0] = input;
            System.out.println("Enter Sypnosis");
            data[1] = sc.nextLine();
            temp.add(data);
        }
        MovieManager.addMovie(temp);
    }
}
