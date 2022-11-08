package src.main.java.payment;

import java.time.LocalDateTime;
import src.main.java.enums.*;
import src.main.java.helper.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * A List class to store all available promo code.
 * @author Boon Hian Lim
 * @version 1.0
 * @since 2022-11-01
 */
public class PromoCodeList {
    private static List<PromoCode> promoCodeList;
    private static List<String[]> promoCodeCSV;

    /**
     * Sort the promo code order.
     */
    private static void sortAfterAppend()
	{
        int position = promoCodeList.size() - 1;
        Comparable key = promoCodeList.get(promoCodeList.size() -1);
        while (position > 0 && key.compareTo(promoCodeList.get(position-1)) < 0)
        {
            Collections.swap(promoCodeList, position, position-1);
            position--;
        }
	}

    /**
     * Get List of promo codes.
     * @return Get List of all PromoCode in the system.
     */
    public static List<PromoCode> getPromoCodeList(){
        refresh();

        return promoCodeList;
    }

    /**
     * Get List of all available promo codes.
     * @return Get list of all available PromoCode in the system.
     */
    public static List<PromoCode> getAvailableCodeList(){
        List<PromoCode> returnPromoList = new ArrayList<PromoCode>();
        
        refresh();

        for(int i = 0;i< promoCodeList.size(); i++){
            if(promoCodeList.get(i).getPromoCodeStatus() == PromoCodeStatus.AVAILABLE){
                returnPromoList.add(promoCodeList.get(i));
            }
        }

        return returnPromoList;
    }

    /**
     * Check the value of a particular promo code.
     * @param promoCode String representation of a promo code.
     * @return Value of the promo code.
     */
    public static double checkPromoCode(String promoCode){

        refresh();

        for(int i = 0; i < promoCodeList.size();i++){
            if(promoCodeList.get(i).getPromoCode().equals(promoCode) &&
                promoCodeList.get(i).getPromoCodeStatus() == PromoCodeStatus.AVAILABLE)
            {
                return promoCodeList.get(i).getOffer();
            }
        }
        return -1;
    }

    /**
     * Add a new promocode to the system.
     * @param promoCode PromoCode to be added.
     */
    public static void add(PromoCode promoCode){
        if(promoCodeList == null){
            promoCodeList = new ArrayList<PromoCode>();
        }
        promoCodeList.add(promoCode);
        sortAfterAppend();
        refresh();
    }   

    /**
     * Function to use a particular promo code.
     * @param promoCode String representation of a promo code.
     */
    public static void usePromoCode(String promoCode){
        for(int i = 0;i< promoCodeList.size(); i++){
            if(promoCodeList.get(i).getPromoCode().equals(promoCode)){
                promoCodeList.get(i).useOne();
            }
        }
        refresh();
    }

    /**
     * Remove a promo code from the system.
     * @param promoCode String representation of promo code to be removed.
     */
    public static void removePromoCodeByCode(String promoCode){
        for(int i = 0;i< promoCodeList.size(); i++){
            if(promoCodeList.get(i).getPromoCode().equals(promoCode)){
                promoCodeList.get(i).setCount(i);;
                break;
            }
        }
    }

    /**
     * Update the number of promo code.
     * @param promoCode PromoCode to be updated.
     * @param count Count for the PromoCode.
     */
    public static void updateCountByCode(String promoCode, int count){
        for(int i = 0;i< promoCodeList.size();i++){
            if(promoCodeList.get(i).getPromoCode().equals(promoCode)){
                promoCodeList.get(i).setCount(count);
                break;
            }
        }
    }

    /**
     * Update the status of a promo code.
     * @param promoCode PromoCode to be updated.
     * @param promoCodeStatus PromoCode enum status.
     */
    public static void updateStatusByCode(String promoCode, PromoCodeStatus promoCodeStatus){
        for(int i = 0;i< promoCodeList.size();i++){
            if(promoCodeList.get(i).getPromoCode().equals(promoCode)){
                promoCodeList.get(i).setPromoCodeStatus(promoCodeStatus);
                break;
            }
        }
    }

    /**
     * Update the availability period for a promocode.
     * @param promoCode PromoCode to be updated.
     * @param starTime Start date time for the promo.
     * @param endTime End date time for the promo.
     */
    public static void updateTimeByCode(String promoCode, LocalDateTime starTime, LocalDateTime endTime){
        for(int i = 0;i< promoCodeList.size();i++){
            if(promoCodeList.get(i).getPromoCode().equals(promoCode)){
                promoCodeList.get(i).setStartTime(starTime);
                promoCodeList.get(i).setEndTime(endTime);
                break;
            }
        }
    }

    /**
     * Function to remove outdated promo and update availble promo.
     */
    public static void refresh(){
        //get current time
        LocalDateTime now = LocalDateTime.now();
        
        for(int i = 0; i < promoCodeList.size();i++){
            //set to valid for incoming promocode
            if(now.isAfter(promoCodeList.get(i).getStartTime()) && 
            (promoCodeList.get(i).getPromoCodeStatus() != PromoCodeStatus.BLOCKED)){
                promoCodeList.get(i).setPromoCodeStatus(PromoCodeStatus.AVAILABLE);
            }
            //remove outdated promocode
            if(now.isAfter(promoCodeList.get(i).getEndTime()) 
                || promoCodeList.get(i).getCount() <= 0){
                promoCodeList.remove(i);
                i--;
            }
        }
    }

    /**
     * Load all the Promocode.
     */
    public static void load(){
        if(promoCodeList == null){
            //System.out.println("The movieList is empty");
            promoCodeList = new ArrayList<PromoCode>();
        }

        promoCodeCSV = File_IO.readFile("promoCode");

        for(int i =0;i<promoCodeCSV.size();i++){
            String promoCode = promoCodeCSV.get(i)[0];
            double offer = Double.parseDouble(promoCodeCSV.get(i)[1]);
            int count = Integer.parseInt(promoCodeCSV.get(i)[2]);
            String startTime = promoCodeCSV.get(i)[3];
            String endTime = promoCodeCSV.get(i)[4];
            PromoCodeStatus showingStatus = PromoCodeStatus.valueOf(promoCodeCSV.get(i)[5]);
            PromoCode tempPromoCode = new PromoCode(promoCode, 
                                        offer,
                                        count,
                                        LocalDateTime.parse(startTime,_DateTimeFormatter.formatter),
                                        LocalDateTime.parse(endTime,_DateTimeFormatter.formatter),
                                        showingStatus);
            promoCodeList.add(tempPromoCode);
        }

        refresh(); //update the promoCodeList
    }

    /**
     * Save all Promo code in system to database before closing app.
     */
    public static void save(){
        List<String[]> writeBackCSV = new ArrayList<String[]>();
        
        for(int i =0;i<promoCodeList.size();i++){
            List<String> tempCodeList = new ArrayList<String>();

            tempCodeList.add(promoCodeList.get(i).getPromoCode());

            tempCodeList.add(Double.toString(promoCodeList.get(i).getOffer()));

            tempCodeList.add(Integer.toString(promoCodeList.get(i).getCount()));

            LocalDateTime startTime = promoCodeList.get(i).getStartTime();
            tempCodeList.add(startTime.format(_DateTimeFormatter.formatter));

            LocalDateTime endTime = promoCodeList.get(i).getEndTime();
            tempCodeList.add(endTime.format(_DateTimeFormatter.formatter));

            PromoCodeStatus promoCodeStatus = promoCodeList.get(i).getPromoCodeStatus();
            tempCodeList.add(promoCodeStatus.toString());

            writeBackCSV.add(tempCodeList.toArray(new String[0]));
        }

        File_IO.writeFile(writeBackCSV, "promoCode");
    }
}
