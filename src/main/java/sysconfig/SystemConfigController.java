import java.util.*;

public class SystemConfigController {
    
    public static List<String[]> syscon;

    public SystemConfigController(){}

    public static void load(){
        syscon = File_IO.readFile("SystemConfig");
    }

    public static double getBasePrice(){
        return Double.valueOf(syscon.get(0)[0]);
    }

    public static void setBasePrice(double bp){
        syscon.get(0)[0] = String.valueOf(bp);
    }

    public static String[] getClassMultiplier(){
        return syscon.get(1);
    }

    public static void setClassMultiplier(int plat, int gold, int silv){
        syscon.get(1)[1] = String.valueOf(plat);
        syscon.get(1)[3] = String.valueOf(gold);
        syscon.get(1)[5] = String.valueOf(silv);
    }

    public static int getClassMulti(String x){
        load();
        if (x.equals(syscon.get(1)[0])) return Integer.valueOf(syscon.get(1)[1]);
        else if (x.equals(syscon.get(1)[2])) return Integer.valueOf(syscon.get(1)[3]);
        else if (x.equals(syscon.get(1)[4])) return Integer.valueOf(syscon.get(1)[5]);
        else return -1;
    }

    public static void save(){
        File_IO.writeFile(syscon, "SystemConfig");
    }
}
