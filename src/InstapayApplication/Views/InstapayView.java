package InstapayApplication.Views;
import Utilites.InstapayUtilites;

public class InstapayView {
    public static int MainMenu() {
        InstapayUtilites.Splitter();
        System.out.println("1. Login with existing account");
        System.out.println("2. Register new account");
        System.out.println("0. Exit");
        System.out.print("Please select an option [0 - 2]: ");
        return InstapayUtilites.TakeInput(Integer.class , "[0-2]" , "Invalid input, please enter a number between 0 and 2.");
    }
    public static void DisplayExitMessage() {
        InstapayUtilites.Splitter();
        System.out.println("       Thank you for using        ");
        InstapayUtilites.Splitter();
    }
    public static void DisplayStartMessage() {
        InstapayUtilites.Splitter();
        System.out.println("       Welcome to Instapay        ");
    }
}
