package Transaction_Service.view;

public class WalletAccView implements TransactionMenu {

    public int ViewMenu(){
        System.out.println("1. Inquire about his balance");
        System.out.println("2. Pay Bill");
        System.out.println("3. Transfer to Wallet using the mobile number");
        System.out.println("4. Transfer to Another instapay account");
        System.out.println("0. Log out");
        System.out.print("Please select an option [0 - 4]: ");
        return Main.InstapayUtilites.TakeInput(Integer.class, "[0-4]" , "");
    }
}