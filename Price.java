package oodp;
import java.time.LocalDateTime;
import java.util.List;

public class Price {

    // holiday, day_of_week, time_of_day, age
    public float basePrice = 8.5f;
    public int day_of_week, time_of_day, holiday, age, threeD;

    // default constructor
    public Price() {
        day_of_week = 7; // Sunday
        time_of_day = 1; // 1 - after 6pm, 0 - before 6pm
        holiday = 1; // default public holiday
        age = 0; // age of buyer default is 0 - adult, 1 - student, 2 - senior
        threeD = 0; // 2D or 3D
    }

    // constructor
    public Price(String date, String yearsold, int three) {
        try {
            // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime dateTime = LocalDateTime.parse(date, _DateTimeFormatter.formatter);
            day_of_week = dateTime.getDayOfWeek().getValue();
            time_of_day = (dateTime.getHour() >= 18) ? 1 : 0;
            age = (Integer.valueOf(yearsold) > 18) ? (Integer.valueOf(yearsold) < 65) ? 0 : 2 : 1;
            threeD = three;
            // Read PH csv
            List<String[]> ph = File_IO.readFile("PublicHoliday");
            for (String[] var : ph) {
                // System.out.println(dateTime);
                // System.out.println(LocalDateTime.parse(var[0], _DateTimeFormatter.formatter).minusDays(1));
                // System.out.println(LocalDateTime.parse(var[1], _DateTimeFormatter.formatter));
                if (dateTime.isAfter(LocalDateTime.parse(var[0], _DateTimeFormatter.formatter).minusDays(1)) &&
                        dateTime.isBefore(LocalDateTime.parse(var[1], _DateTimeFormatter.formatter))) {
                    holiday = 1;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error!!" + e.getMessage());
        }
    }

    public float getPrice() {
        // System.out.println("day of week: " + day_of_week);
        // System.out.println("ph: " + holiday);
        if (day_of_week > 5 || holiday == 1)
            return 11 + threeD * 4;
        float price = basePrice + (float) (time_of_day * 2.5) + threeD * 4;
        if (time_of_day == 0)
            price -= age * 1.5;
        if (day_of_week == 5 && age != 1 && age != 2)
            price += 1;
        return price;
    }

    // public static void main(String[] args){
    //     SystemConfig test = new SystemConfig("2022-12-29 17:59", "20", 0);
    //     float cost = test.getPrice();
    //     System.out.println(cost);
    // }


}
