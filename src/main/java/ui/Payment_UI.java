package src.main.java.ui;

import java.util.Scanner;
import src.main.java.payment.*;
import src.main.java.booking.*;
import src.main.java.helper.*;

public class Payment_UI {
    public static double display_UI(String userName, String ticketID){


        String email = "";
        if(userName.equals("Guest")){
            System.out.println("Please enter your email address, so that we can send you the ticket after the payment.");
            email = ExceptionHandling.StringScanner();
        }

        double fare=0;
        int paymentDone = 0;
        int choice = 0;
        while(paymentDone == 0){

            PaymentMethodInterface paymentMethod;
            fare = Price.getPrice();
                
            do{
                System.out.format("Your price for the movie is: %.2f\n",fare);
                System.out.println("Do you want to claim the promo code? (1: No, 2: Yes)");
                choice = ExceptionHandling.IntegerScannerRangeOfFunction(2);

                if(choice == 0){
                    break;
                }
                
                System.out.println("Enter your promo code:");
                String promoCode = ExceptionHandling.StringScanner();

                double offer = PromoCodeList.checkPromoCode(promoCode);
                if(offer < 0){
                    System.out.println("The promo code is invalid!");
                }else{
                    //Current Approach: Only one promo code is allowed.
                    fare -= offer;
                    PromoCodeList.usePromoCode(promoCode);
                    System.out.format("Your price for the movie is updated: %.2f\n",fare);
                    break; //remove this to allow multiple promo code
                }
                
            }while(choice == 1);
           
            
            System.out.println("Select your payment method:");

            //Choices of payment method:
            System.out.println("1. Paylah");
            System.out.println("2. Credit Card");
            
            choice = ExceptionHandling.IntegerScannerRangeOfFunction(2);
            switch(choice){
                case 1:
                    paymentMethod = new PaymentPayLah();
                    break;
                case 2:
                default:
                    paymentMethod = new PaymentBankCard();
            }
            paymentDone = paymentMethod.pay(fare);
            if(paymentDone == 1){
                System.out.println("The payment is successful!");
            }else{
                System.out.println("The payment is unsucessful. Re-pick a payment method.");
            }
        }
        System.out.println("Payment successful! Your ticket ID is: "+ticketID);
        
        if(userName.equals("Guest")){
            System.out.println("Dear "+userName+",");
            System.out.println("We will send the details to "+email+" , please present it at the ticket counter.");
        }
        else{
            System.out.println("Dear "+userName+",");
            System.out.println("Please view your details in the 'My Booking History' tab and present it at the ticket counter.");
        }


        return fare;
    } 
}
