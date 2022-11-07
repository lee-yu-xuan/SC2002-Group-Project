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
        while(paymentDone == 0){
            PaymentMethodInterface paymentMethod;
            fare = Price.getPrice();
            System.out.format("Your price for the movie is: %.2f\n",fare);
            System.out.println("Select your payment method:");

            //Choices of payment method:
            System.out.println("1. Paylah");
            System.out.println("2. Credit Card");

            int choice = ExceptionHandling.IntegerScannerRangeOfFunction(2);
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
