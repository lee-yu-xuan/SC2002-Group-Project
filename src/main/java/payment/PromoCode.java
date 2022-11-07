package src.main.java.payment;

import java.time.LocalDateTime;
import src.main.java.enums.*;

public class PromoCode implements Comparable{
    private String promoCode;
    private int count;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private PromoCodeStatus promoCodeStatus;

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

    public PromoCode(String promoCode,int count,LocalDateTime startTime,LocalDateTime endTime,PromoCodeStatus promoCodeStatus){
        this.promoCode = promoCode;
        this.count = count;
        this.startTime = startTime;
        this.endTime = endTime;
        this.promoCodeStatus = promoCodeStatus;
    }

    public PromoCode(String promoCode,int count,LocalDateTime startTime,LocalDateTime endTime){
        this(promoCode, count, startTime, endTime, PromoCodeStatus.READY);
    }

    public int getCount() {
        return count;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
    public String getPromoCode() {
        return promoCode;
    }
    public PromoCodeStatus getPromoCodeStatus() {
        return promoCodeStatus;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    public void setPromoCodeStatus(PromoCodeStatus promoCodeStatus) {
        this.promoCodeStatus = promoCodeStatus;
    }
}