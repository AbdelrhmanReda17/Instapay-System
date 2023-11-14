package InstapayApplication.Views.MainMenu;


import InstapayApplication.Utilites.InstapayUtilites;

public class BankAccountView implements MainMenu {
    public int DisplayMenu(){
        System.out.println("1. Inquire about his balance");
        System.out.println("2. Pay Bill");
        System.out.println("3. Transfer to Wallet using the mobile number");
        System.out.println("4. Transfer to Another instapay account");
        System.out.println("5. Transfer to Bank Account");
        System.out.println("0. Log out");
        System.out.print("Please select an option [0 - 5]: ");
        return   InstapayUtilites.TakeInput(Integer.class, "[0-5]" , "Invalid input, please try again enter a number between  [0 - 5]:");
    }
}
