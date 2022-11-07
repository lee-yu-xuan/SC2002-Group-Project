package src.main.java.helper;
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

    public static String checkForAlphabet(){
        Scanner scanner = new Scanner(System.in);
        String str = "";
        try{
            str = scanner.nextLine();
            //check if str is alphabet
            if(str.matches("[a-zA-Z]+")){
                throw new InputMismatchException();
            }
        }catch(InputMismatchException e){
            System.out.println("You did not enter an alphabet.");
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

        while(num<0 || num>upperBound){
            System.out.println("Please enter a number between 0 and "+upperBound);
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
