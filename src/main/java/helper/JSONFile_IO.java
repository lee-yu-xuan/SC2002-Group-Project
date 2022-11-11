package src.main.java.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
//import java.nio.file.*;

/**
 * A File input output class.
 * @author Yong Jian Loke
 * @version 1.0
 * @since 2022-11-01
 */
//to update the seatTaken, can concatenate to the String then update the line
public class JSONFile_IO implements File_IOInterface{

    /**
     * Function to read file of records in .JSON format.
     * @param pathName name of the file.
     * @return List of String Array stored in JSON file.
     */
    public List<String[]> readFile(String pathName) {

        //String cwd = Path.of("").toAbsolutePath().toString();
        String path = "src/main/java/csv/" + pathName + ".json";
        String line = "";
        List<String[]> twoDlist = new ArrayList<String[]>();

        return twoDlist;
    }

    /**
     * Function to write file of records in .JSON format.
     * @param twoDList List of String Array to be recorded and saved.
     * @param pathName Csv file name.
     */
    public void writeFile(List<String[]> twoDList, String pathName) {
        String path = "src/main/java/csv/" + pathName + ".json";
        File file = new File(path);
    }

}
