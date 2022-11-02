import java.util.Scanner;

public class Payment_UI {
    public static void display_UI(String userName, String ticketID){

        if(userName.equals("Guest")){
            System.out.println("Please enter your email address, so that we can send you the ticket after the payment.");
        }

        int paymentDone = 0;
        while(paymentDone == 0){
            PaymentMethodInterface paymentMethod;
            double fare = Price.getFare();
            System.out.format("Your price for the movie is: %.2f\n",fare);
            System.out.println("Select your payment method:");

            //Choices of payment method:
            System.out.println("1. Paylah");
            System.out.println("2. Credit Card");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
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

        
    }
}
