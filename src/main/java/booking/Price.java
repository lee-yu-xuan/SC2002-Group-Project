package src.main.java.booking;

import java.time.LocalDateTime;
import src.main.java.sysconfig.*;

/**
 * A Price class.
 * @author Yong Jian Loke
 * @version 1.0
 * @since 2022-11-01
 */
public class Price {
    // holiday, day_of_week, time_of_day, age
    public static double basePrice;
    public static int day_of_week, time_of_day, holiday, age, threeD, cinemaClass, row;

    /**
     * Default constructor for price class.
     */
    // default constructor
    public Price() {
        basePrice = 8.5d;
        day_of_week = 7; // Sunday
        time_of_day = 1; // 1 - after 6pm, 0 - before 6pm
        holiday = 1; // default public holiday
        age = 0; // age of buyer default is 0 - adult, 1 - student, 2 - senior
        threeD = 0; // 2D or 3D
        row = 0;
    }

    /**
     * Constructor for price class.
     * @param date Date of the movie.
     * @param yearsold Age of the moviegoer.
     * @param three Int represenation if movie is 3D.
     * @param CinemaClass Class of the movie show.
     * @param rowNo Row number of the seat.
     */
    // constructor
    public Price(LocalDateTime date, String yearsold, int three, int CinemaClass , int rowNo) {
        try {
            // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            // LocalDateTime dateTime = LocalDateTime.parse(date, _DateTimeFormatter.formatter);
            basePrice = SystemConfigController.getBasePrice();
            day_of_week = date.getDayOfWeek().getValue();
            time_of_day = (date.getHour() >= 18) ? 1 : 0;
            age = (Integer.valueOf(yearsold) > 18) ? (Integer.valueOf(yearsold) < 65) ? 0 : 2 : 1;
            threeD = three;
            holiday = (Holiday.isHoliday(date)) ? 1 : 0;
            cinemaClass = CinemaClass;
            row = rowNo;

        } catch (Exception e) {
            System.out.println("Error!!" + e.getMessage());
        }
    }

    /**
     * Get price for the ticket.
     * @return Price of the ticket.
     */
    public static double getPrice() {
        // System.out.println("day of week: " + day_of_week);
        // System.out.println("ph: " + holiday);
        int discount = (row < 3) ? 2 : 0;
        if (day_of_week > 5 || holiday == 1)
            return basePrice + 4.5 + threeD * 4;
        double price = basePrice + time_of_day * 2.5 + threeD * 4;
        if (time_of_day == 0)
            price -= age * 2;
        if (day_of_week == 5 && age != 1 && age != 2)
            price += 1;
        return ((price * cinemaClass) - discount);
    }

}
