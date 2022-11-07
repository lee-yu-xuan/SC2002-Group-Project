import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class PromoCodeList {
    private static List<PromoCode> promoCodeList;
    private static List<String[]> promoCodeCSV;

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

    public static List<PromoCode> getPromoCodeList(){
        refresh();

        return promoCodeList;
    }

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

    public static boolean checkPromoCode(String promoCode){
        refresh();

        for(int i = 0; i < promoCodeList.size();i++){
            if(promoCodeList.get(i).getPromoCode().equals(promoCode) &&
                promoCodeList.get(i).getPromoCodeStatus() == PromoCodeStatus.AVAILABLE)
            {
                return true;
            }
        }
        return false;
    }

    public static void add(PromoCode promoCode){
        if(promoCodeList == null){
            promoCodeList = new ArrayList<PromoCode>();
        }
        promoCodeList.add(promoCode);
        sortAfterAppend();
        refresh();
    }   

    public static void removePromoCodeByCode(String promoCode){
        for(int i = 0;i< promoCodeList.size(); i++){
            if(promoCodeList.get(i).getPromoCode().equals(promoCode)){
                promoCodeList.remove(i);
            }
        }
    }

    public static void updateCountByCode(String promoCode, int count){
        for(int i = 0;i< promoCodeList.size();i++){
            if(promoCodeList.get(i).getPromoCode().equals(promoCode)){
                promoCodeList.get(i).setCount(count);
            }
        }
    }

    public static void updateStatusByCode(String promoCode, PromoCodeStatus promoCodeStatus){
        for(int i = 0;i< promoCodeList.size();i++){
            if(promoCodeList.get(i).getPromoCode().equals(promoCode)){
                promoCodeList.get(i).setPromoCodeStatus(promoCodeStatus);
            }
        }
    }

    public static void updateTimeByCode(String promoCode, LocalDateTime starTime, LocalDateTime endTime){
        for(int i = 0;i< promoCodeList.size();i++){
            if(promoCodeList.get(i).getPromoCode().equals(promoCode)){
                promoCodeList.get(i).setStartTime(starTime);
                promoCodeList.get(i).setEndTime(endTime);
            }
        }
    }
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

    public static void load(){
        if(promoCodeList == null){
            //System.out.println("The movieList is empty");
            promoCodeList = new ArrayList<PromoCode>();
        }

        promoCodeCSV = File_IO.readFile("promoCode");

        for(int i =0;i<promoCodeCSV.size();i++){
            String promoCode = promoCodeCSV.get(i)[0];
            int count = Integer.parseInt(promoCodeCSV.get(i)[1]);
            String startTime = promoCodeCSV.get(i)[2];
            String endTime = promoCodeCSV.get(i)[3];
            PromoCodeStatus showingStatus = PromoCodeStatus.valueOf(promoCodeCSV.get(i)[4]);
            PromoCode tempPromoCode = new PromoCode(promoCode, 
                                        count,
                                        LocalDateTime.parse(startTime,_DateTimeFormatter.formatter),
                                        LocalDateTime.parse(endTime,_DateTimeFormatter.formatter),
                                        showingStatus);
            promoCodeList.add(tempPromoCode);
        }

        refresh(); //update the promoCodeList
    }

    public static void save(){
        List<String[]> writeBackCSV = new ArrayList<String[]>();
        
        for(int i =0;i<promoCodeList.size();i++){
            List<String> tempCodeList = new ArrayList<String>();

            tempCodeList.add(promoCodeList.get(i).getPromoCode());

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
