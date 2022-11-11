package src.main.java.helper;

import java.util.List;
/**
 * A File_IO Interface.
 * @author Boon Hian Lim
 * @version 1.0
 * @since 2022-11-01
 */

public interface File_IOInterface {
    public List<String[]> readFile(String pathName);
    public void writeFile(List<String[]> twoDList,String pathName);
} 
