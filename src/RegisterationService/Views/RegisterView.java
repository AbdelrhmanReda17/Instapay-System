package RegisterationService.Views;
import InstapayApplication.Utilites.InstapayUtilites;

import java.util.Set;

public class RegisterView {

    public static int RegisterMenu(){
        System.out.println("1. Register by Bank Account ");
        System.out.println("2. Register by Wallet ");
        System.out.println("0. Exit ");
        System.out.print("Please select an option [0 - 2]: ");
        return InstapayUtilites.TakeInput(Integer.class , "[0-2]" , "" );
    }

    public static int ProviderMenu(Set<String> Array){
        System.out.println("Please Select your provider : ");
        for (int i = 1; i < Array.size() + 1; i++){
            System.out.println(i + ". " + Array.toArray()[i - 1]);
        }
        System.out.println("0. Exit");
        System.out.print("Please select an option [0 - "+ Array.size() +"]: ");
        return InstapayUtilites.TakeInput(Integer.class , "[0-"+Array.size()+"]" , "Invalid input, please enter a number between [0 - "+ Array.size() +"]: " );
    }
    public static boolean VerfiyView(int OTP,int counter){
        System.out.println("23ml nfsk el OTP GALK W HOWA [ " + OTP + " ] ");
        System.out.print("Please enter the OTP sent to your mobile number : ");
        int userOTP = InstapayUtilites.TakeInput(Integer.class , "" , "" );
        while (userOTP != OTP && counter < 3 ){
            System.out.print("OTP is incorrect. You have " + (3 - counter) + " attempts left: ");
            userOTP = InstapayUtilites.TakeInput(Integer.class , "" , "" );
            counter++;
        }
        if(counter == 3 && userOTP != OTP){
            System.out.println("OTP is incorrect , Please try again later");
            return false;
        }
        System.out.println("Account Verified Successfully");
        return true;
    }
    public static String Takeusername(){
            System.out.println("Please enter your username - Exit to close : ");
           return InstapayUtilites.TakeInput(String.class  , "^[a-zA-Z0-9_\\.]{3,20}$" , "Username must be between 3 and 20 characters long and can only contain letters, numbers, underscores and dots." );
    }
    public static String TakeuserDetails(){
        System.out.println("Please enter your password - Exit to close : ");
       return InstapayUtilites.TakeInput(String.class  , "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$" , "Password must be at least 8 characters long and contain at least one lowercase letter, one uppercase letter, one digit and one special character." );
    }
}

