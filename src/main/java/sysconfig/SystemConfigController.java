package src.main.java.sysconfig;

import java.util.*;
import src.main.java.helper.*;

/**
 * System Configuration Controller Class.
 * @author Boon Hian Lim
 * @version 1.0
 * @since 2022-11-01
 */
public class SystemConfigController {
    
    /**
     * All System information.
     */
    public static List<String[]> syscon;
    /**
	 * Create instance of File_IO.
	 */
	private static File_IOInterface file_IO = new CSVFile_IO();
    public SystemConfigController(){}

    /**
     * Load all information pertaining to system configuration into the program.
     */
    public static void load(){
        syscon = file_IO.readFile("SystemConfig");
    }

    /**
     * Get the base price of the system currently.
     * @return Base Price of ticket.
     */
    public static double getBasePrice(){
        return Double.valueOf(syscon.get(0)[0]);
    }

    /**
     * Set the base price for the system.
     * @param bp base price to be implemented.
     */
    public static void setBasePrice(double bp){
        syscon.get(0)[0] = String.valueOf(bp);
    }

    /**
     * Get the Price multiplier for the different classes.
     * @return String array of the class multiplier.
     */
    public static String[] getClassMultiplier(){
        return syscon.get(1);
    }

    /**
     * Set the price difference for every Class of Cinema.
     * @param plat Price multiplier for Platinum Cinema.
     * @param gold Price multiplier for Gold Cinema.
     * @param silv Price multiplier for Silver Cinema.
     */
    public static void setClassMultiplier(int plat, int gold, int silv){
        syscon.get(1)[1] = String.valueOf(plat);
        syscon.get(1)[3] = String.valueOf(gold);
        syscon.get(1)[5] = String.valueOf(silv);
    }

    /**
     * Get the Class Multiplier for a particular class.
     * @param x Class of cinema to get the price difference for.
     * @return Price multiplier for that particular class.
     */
    public static int getClassMulti(String x){
        load();
        if (x.equals(syscon.get(1)[0])) return Integer.valueOf(syscon.get(1)[1]);
        else if (x.equals(syscon.get(1)[2])) return Integer.valueOf(syscon.get(1)[3]);
        else if (x.equals(syscon.get(1)[4])) return Integer.valueOf(syscon.get(1)[5]);
        else return -1;
    }

    /**
     * Save all System Configuration.
     */
    public static void save(){
        file_IO.writeFile(syscon, "SystemConfig");
    }
}
