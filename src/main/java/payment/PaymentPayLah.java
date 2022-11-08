package src.main.java.payment;

import java.util.Scanner;

/**
 * A Paylah Payment class.
 * @author Boon Hian Lim
 * @version 1.0
 * @since 2022-11-01
 */
public class PaymentPayLah implements PaymentMethodInterface{
    private int validationCount;

    /**
     * Payment method for bank card.
     * @param fare Price for the ticket.
     * @return Integer representation of payment status.
     */
    public int pay(double fare) {
        Scanner sc = new Scanner(System.in);
        validationCount = 0;

        while(validationCount < 2){ //User have 2 chances to payByPayLah
            System.out.println("Please scan the QR code below");
            System.out.println();
            System.out.println("==================================");
            System.out.println("QR CODE ARE SUPPOSED TO SHOW HERE");
            System.out.println("==================================");
            System.out.println();
            System.out.println("Press Enter after you have made the transaction...");
            sc.nextLine();
            if(validation() == 1){
                //payment successful
                return 1;
            }else{
                validationCount++;
                System.out.println("Payment Unsuccessful. Try again");
            }
        }
        //payment unsuccessful
        return -1;
    }
    
    /**
     * Validation function to check if payment is successful.
     * @return Integer representation of payment validation.
     */
    public int validation(){
        //go to API and check if the payment go through
        //We assume it is always successful here.
        return 1;
    }
}
