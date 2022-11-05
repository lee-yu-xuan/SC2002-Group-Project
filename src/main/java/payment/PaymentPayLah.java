package src.main.java.payment;

import java.util.Scanner;

public class PaymentPayLah implements PaymentMethodInterface{
    private int validationCount;

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
    
    public int validation(){
        //go to API and check if the payment go through
        //We assume it is always successful here.
        return 1;
    }
}
