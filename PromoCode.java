import java.time.LocalDateTime;

public class PromoCode {
    private String promoCode;
    private int count;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private PromoCodeStatus promoCodeStatus;
    
    public PromoCode(String promoCode,int count,LocalDateTime startTime,LocalDateTime endTime,PromoCodeStatus promoCodeStatus){
        this.promoCode = promoCode;
        this.count = count;
        this.startTime = startTime;
        this.endTime = endTime;
        this.promoCodeStatus = promoCodeStatus;
    }

    public PromoCode(String promoCode,int count,LocalDateTime startTime,LocalDateTime endTime){
        this.promoCode = promoCode;
        this.count = count;
        this.startTime = startTime;
        this.endTime = endTime;
        this.promoCodeStatus = PromoCodeStatus.READY;
    }

    
}