package src.main.java.payment;

import java.util.Scanner;
import src.main.java.helper.*;

/**
 * A PaymentBankCard Class.
 * @author Boon Hian Lim
 * @version 1.0
 * @since 2022-11-01
 */
public class PaymentBankCard implements PaymentMethodInterface {
    private int validationCount;
    private String bankCardNumber;
    private String CVV;
    private String expiredDate;

    /**
     * Payment method for bank card.
     * @param fare Price for the ticket.
     * @return Integer representation of payment status.
     */
    public int pay(double fare) {

        validationCount = 0;

        while (validationCount < 2) { // User have 2 chances to payByPayLah
            System.out.println("Enter your bank card details:");
            System.out.println();
            System.out.format("Your bank card number:");
            bankCardNumber = ExceptionHandling.StringScanner();
            System.out.format("CVV number:");
            CVV = ExceptionHandling.StringScanner();
            System.out.format("Expired Date:");
            expiredDate = ExceptionHandling.StringScanner();

            if (validation() == 1) {
                // payment successful
                return 1;
            } else {
                validationCount++;
                System.out.println("Payment Unsuccessful. Try again");
            }
        }
        // payment unsuccessful
        return -1;
    }
    /**
     * Validation function to check if payment is successful.
     * @return Integer representation of payment validation.
     */
    public int validation() {
        // go to API and check if the payment go through
        // We assume it is always successful here.
        if (bankCardNumber != null && CVV != null && expiredDate != null) {
            return 1;
        }

        return 1;
    }
}
