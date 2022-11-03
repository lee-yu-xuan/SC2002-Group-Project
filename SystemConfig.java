package oodp;
import java.time.LocalDateTime;
import java.util.*;
import java.util.ArrayList;

public class SystemConfig {
	List<String[]> days = new ArrayList<>();
	private static List<Holiday> holidayList;
	private static List<String[]> holidayCSV;
	private static double basePrice = 8.5;
    // constructor
    public SystemConfig(){}

    // in yyyy-MM-dd;
	/*
	 * public void Add(String date){ String start = date + " 00:00"; String end =
	 * date + " 23:59"; String[] day = new String[2]; System.out.println(start +
	 * "\\" + end); day[0] = start; day[1] = end; days.add(day); }
	 */
    
    public static List<Holiday> getHolidayList(){
        return holidayList;
    }
    
    public static void setBasePrice(double price) {
    	basePrice = price;
    }
    
    public static double getBasePrice() {
    	return basePrice;
    }
    
    public static void addHoliday(LocalDateTime start,LocalDateTime end,double modifier) {
    	if(holidayList == null){
            System.out.println("The holidayList is empty");
            holidayList = new ArrayList<Holiday>();
        }
    	Holiday H = new Holiday(start,end,modifier);
    	
    	holidayList.add(H);
    }
     
	/*
	 * public static void add(Price price){ if(basePriceList == null){
	 * System.out.println("The showTimeList is empty"); basePriceList = new
	 * ArrayList<Price>(); } basePriceList.add(price); }
	 * 
	 * public static void load(){ if(basePriceList == null){
	 * System.out.println("The basePriceList is empty"); basePriceList = new
	 * ArrayList<Price>(); } basePriceCSV = File_IO.readFile("BasePrice");
	 * 
	 * for(int i = 0;i< basePriceCSV.size();i++){ String days =
	 * basePriceCSV.get(i)[0]; String times = basePriceCSV.get(i)[1]; String
	 * Holidays = basePriceCSV.get(i)[2]; String ages = basePriceCSV.get(i)[3];
	 * String threeDs = basePriceCSV.get(i)[4];
	 * 
	 * int day,time, holiday,age,threeD;
	 * 
	 * day = Integer.valueOf(days); time = Integer.valueOf(times); holiday =
	 * Integer.valueOf(Holidays); age = Integer.valueOf(ages); threeD =
	 * Integer.valueOf(threeDs);
	 * 
	 * Price price = new Price(day,time,holiday,age,threeD); //create the class
	 * basePriceList.add(price); } } public static void save(){ List<String[]>
	 * writeBackCSV = File_IO.readFile("BasePrice");
	 * 
	 * for(int i =0;i<basePriceList.size();i++){ List<String> tempTimeList = new
	 * ArrayList<String>();
	 * 
	 * tempTimeList.add(String.valueOf(basePriceList.get(i).getDay()));
	 * 
	 * tempTimeList.add(String.valueOf(basePriceList.get(i).getTime()));
	 * 
	 * tempTimeList.add(String.valueOf(basePriceList.get(i).getHoliday()));
	 * 
	 * tempTimeList.add(String.valueOf(basePriceList.get(i).getAge()));
	 * 
	 * tempTimeList.add(String.valueOf(basePriceList.get(i).getThreeD()));
	 * 
	 * writeBackCSV.add(tempTimeList.toArray(new String[0])); }
	 * 
	 * File_IO.writeFile(writeBackCSV, "BasePrice"); }
	 */
    
    public void updateCSV(){
        File_IO.writeFile(days, "PublicHoliday");
    }
   
   

    // public static void main (String[] args){
    //     AddPublicHoliday test_add = new AddPublicHoliday();
    //     test_add.Add("2022-12-25");
    //     test_add.Add("2022-12-31");
    //     test_add.updateCSV();
    // }
}
