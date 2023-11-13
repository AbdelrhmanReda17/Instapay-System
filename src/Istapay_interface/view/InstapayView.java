package Istapay_interface.view;

public class InstapayView {

    public static int MainMenu() {
        while(true){
            System.out.println("1. Login with existing account");
            System.out.println("2. Register new account");
            System.out.println("0. Exit");
            System.out.print("Please select an option [0 - 2]: ");
            return  Main.InstapayUtilites.TakeInput(Integer.class , "[0-2]" , "Invalid input, please enter a number between 0 and 2.");
        }
    }


    public static void DisplayExitMessage() {
        System.out.println("----------------------------------");
        System.out.println("       Thank you for using        ");
        System.out.println("----------------------------------");
    }

    public static void DisplayStartMessage() {
        System.out.println("----------------------------------");
        System.out.println("       Welcome to Instapay        ");
        System.out.println("----------------------------------");
    }
}
