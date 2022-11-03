import java.time.LocalDateTime;

public class Price {
    // holiday, day_of_week, time_of_day, age
    public double basePrice;
    public int day_of_week, time_of_day, holiday, age, threeD, cinemaClass;

    // default constructor
    public Price() {
        basePrice = 8.5d;
        day_of_week = 7; // Sunday
        time_of_day = 1; // 1 - after 6pm, 0 - before 6pm
        holiday = 1; // default public holiday
        age = 0; // age of buyer default is 0 - adult, 1 - student, 2 - senior
        threeD = 0; // 2D or 3D
    }

    // constructor
    public Price(double basePrice, String date, String yearsold, int three, int cinemaClass ) {
        try {
            // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime dateTime = LocalDateTime.parse(date, _DateTimeFormatter.formatter);
            this.basePrice = basePrice;
            day_of_week = dateTime.getDayOfWeek().getValue();
            time_of_day = (dateTime.getHour() >= 18) ? 1 : 0;
            age = (Integer.valueOf(yearsold) > 18) ? (Integer.valueOf(yearsold) < 65) ? 0 : 2 : 1;
            threeD = three;
            holiday = (Holiday.isHoliday(date)) ? 1 : 0;
            this.cinemaClass = cinemaClass;

        } catch (Exception e) {
            System.out.println("Error!!" + e.getMessage());
        }
    }

    public double getPrice() {
        // System.out.println("day of week: " + day_of_week);
        // System.out.println("ph: " + holiday);
        if (day_of_week > 5 || holiday == 1)
            return basePrice + 4.5 + threeD * 4;
        double price = basePrice + time_of_day * 2.5 + threeD * 4;
        if (time_of_day == 0)
            price -= age * 2;
        if (day_of_week == 5 && age != 1 && age != 2)
            price += 1;
        return price * cinemaClass;
    }

    // public Price(int day,int time,int holiday,int age,int threeD){
    //     this.day_of_week = day;
    //     this.time_of_day = time;
    //     this.holiday = holiday;
    //     this.age = age;
    //     this.threeD = threeD;
    // }

    // public void setDay(int day) {
    // 	this.day_of_week=day;
    // }
    // public void setTime(int time) {
    // 	this.time_of_day=time;
    // }
    // public void setHoliday(int holiday) {
    // 	this.holiday=holiday;
    // }
    // public void setAge(int age) {
    // 	this.age=age;
    // }
    // public void setThreeD(int threeD) {
    // 	this.threeD=threeD;
    // }
    
    // public int getDay() {
    // 	return day_of_week;
    // }
    // public int getTime() {
    // 	return time_of_day;
    // }
    // public int getHoliday() {
    // 	return holiday;
    // }
    // public int getAge() {
    // 	return age;
    // }
    // public int getThreeD() {
    // 	return threeD;
    // }
   
    // public static void main(String[] args){
    //     SystemConfig test = new SystemConfig("2022-12-29 17:59", "20", 0);
    //     float cost = test.getPrice();
    //     System.out.println(cost);
    // }


}
