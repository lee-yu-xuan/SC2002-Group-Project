package src.main.java.payment;

import java.time.LocalDateTime;
import src.main.java.enums.*;

/**
 * A PromoCode Class.
 * @author Boon Hian Lim
 * @version 1.0
 * @since 2022-11-01
 */
public class PromoCode implements Comparable{
    private String promoCode;
    private int count;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private PromoCodeStatus promoCodeStatus;
    private double offer;

    /**
     * compareTo method for Promocode Comparable.
     */
    public int compareTo(Object o){
        if(o == null){
            return -1;
        }
        else if(!(o instanceof PromoCode)){
            return -1;
        }
        else{
            PromoCode inputPromoCode = (PromoCode) o;
            int diff = this.getStartTime().compareTo(inputPromoCode.getStartTime());
            if(diff!=0){
                return diff;
            }else{
                return this.getCount() - inputPromoCode.getCount();
            }
        }
    }

    /**
     * Constructor of PromoCode class.
     * @param promoCode String represent of the promo code.
     * @param offer Price discount.
     * @param count Number of remaining available promo.
     * @param startTime Start date of the promo code.
     * @param endTime   End date of the promo code.
     * @param promoCodeStatus Promo code status.
     */
    public PromoCode(String promoCode,double offer,int count,LocalDateTime startTime,LocalDateTime endTime,PromoCodeStatus promoCodeStatus){
        this.promoCode = promoCode;
        this.count = count;
        this.startTime = startTime;
        this.endTime = endTime;
        this.offer = offer;
        this.promoCodeStatus = promoCodeStatus;
    }

    /**
     * Constructor of PromoCode Class.
     * @param promoCode String represent of the promo code.
     * @param offer Price discount.
     * @param count Number of remaining available promo.
     * @param startTime Start date of the promo code.
     * @param endTime   End date of the promo code.
     */
    public PromoCode(String promoCode,double offer,int count,LocalDateTime startTime,LocalDateTime endTime){
        this(promoCode,offer, count, startTime, endTime, PromoCodeStatus.READY);
    }

    /**
     * Get count function.
     * @return Number of count for promo code left.
     */
    public int getCount() {
        return count;
    }

    /**
     * Get start time of promo code.
     * @return Return start time of the promo code.
     */
    public LocalDateTime getStartTime() {
        return startTime;
    }

    /**
     * Get end time of promo code.
     * @return Return end time of the promo code.
     */
    public LocalDateTime getEndTime() {
        return endTime;
    }

    /**
     * Get promocode string representation.
     * @return String of promo code.
     */
    public String getPromoCode() {
        return promoCode;
    }

    /**
     * Get the status of promocode.
     * @return Enum of the promocode status.
     */
    public PromoCodeStatus getPromoCodeStatus() {
        return promoCodeStatus;
    }

    /**
     * Get the price of discount.
     * @return Discount value.
     */
    public double getOffer(){
        return offer;
    }

    /**
     * Set the number of available count for a particular promo code.
     * @param count Number of available promo code.
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Set the start time for a promo code.
     * @param startTime Start time of a promo.
     */
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    /**
     * Set the end time for a promo code.
     * @param endTime End time of a promo.
     */
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    /**
     * Set the offer value for a promo code.
     * @param offer Value of offer.
     */
    public void setOffer(double offer){
        this.offer = offer;
    }

    /**
     * Set the status of a promo code.
     * @param promoCodeStatus Enum of Promo code status.
     */
    public void setPromoCodeStatus(PromoCodeStatus promoCodeStatus) {
        this.promoCodeStatus = promoCodeStatus;
    }

    /**
     * Reduce the count of a promo code by one.
     */
    public void useOne(){
        this.count--;
    }
}