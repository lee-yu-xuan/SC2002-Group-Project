package src.main.java.payment;

import java.util.Scanner;
import src.main.java.helper.*;

public class PaymentBankCard implements PaymentMethodInterface{
    private int validationCount;
    private String bankCardNumber; 
    private String CVV;
    private String expiredDate;

    public int pay(double fare) {
       
        validationCount = 0;

        while(validationCount < 2){ //User have 2 chances to payByPayLah
            System.out.println("Enter your bank card details:");
            System.out.println();
            System.out.format("Your bank card number:");
            bankCardNumber = ExceptionHandling.StringScanner();
            System.out.format("CVV number:");
            CVV = ExceptionHandling.StringScanner();
            System.out.format("Expired Date:");
            expiredDate = ExceptionHandling.StringScanner();

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
        if(bankCardNumber != null && CVV != null && expiredDate != null){
            return 1;
        }

        return 1;
    }
}
