package src.main.java.helper;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling {
    public static int IntegerScanner() {
        Scanner scanner = new Scanner(System.in);
        int num=0;
        try {
            num = scanner.nextInt();
            //System.out.println("You entered: " + num);
        } catch (InputMismatchException e) {
            System.out.println("You did not enter an integer.");
        }

        return num;
    }


    public static LocalDateTime checkDateTime(){
        Scanner sc = new Scanner(System.in);
        String temp = "";
        LocalDateTime dateTime;
        try {
            temp = sc.nextLine();
            //convert string to datetime
            dateTime = LocalDateTime.parse(temp, _DateTimeFormatter.formatter);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Please enter according to the format 'yyyy-MM-dd HH:mm'!");
            dateTime = ExceptionHandling.checkDateTime();
        }
        return dateTime;
    }

    public static String checkForAlphabet(int option){
        //2 means expect characters, 1 means expect alphabets
        Scanner scanner = new Scanner(System.in);
        String str = "";
        
        switch (option) {
            case 1:
            try{
                //check if str is character
                str = scanner.nextLine();
                if(!str.matches("[a-zA-Z]+")){
                    throw new InputMismatchException();
                }
            }catch(InputMismatchException e){
                System.out.println("Please enter the correct character.");
                str = ExceptionHandling.checkForAlphabet(1);
            }
                break;
            
            case 2:
            try{
                //check if str is alphabet
                str = scanner.nextLine();
                if(str.matches("[a-zA-Z]+")){
                    throw new InputMismatchException();
                }
            }catch(InputMismatchException e){
                System.out.println("You did not enter numerical number.");
                str = ExceptionHandling.checkForAlphabet(2);
            }
                break;
            default:
                break;
        }

        return str;
    }

    public static int IntegerScannerRangeOfFunction(int upperBound){
        Scanner scanner = new Scanner(System.in);
        int num=0;
        try {
            num = scanner.nextInt();
            //System.out.println("You entered: " + num);
        } catch (InputMismatchException e) {
            System.out.println("You did not enter an integer.");
        }

        while(num<=0 || num>upperBound){
            System.out.println("Please enter a number between 1 and "+upperBound);
            num = scanner.nextInt();
        }

        return num;
    }

    public static String StringScanner(){
	Scanner scanner = new Scanner(System.in);
	String str="";
	try {
	     str = scanner.nextLine();
             //System.out.println("You typed in: " + str);
	} catch (InputMismatchException e) {
         System.out.println("You did not enter a string.");
    }

    return str;
}

}
