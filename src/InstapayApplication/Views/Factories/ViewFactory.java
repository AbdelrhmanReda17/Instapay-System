package InstapayApplication.Views.Factories;

import Entities.User.Account;
import InstapayApplication.Views.MainMenu.*;



public class ViewFactory {
    public static MainMenu CreateMainMenu(Account account) {
        return switch (account.getClass().getSimpleName()) {
            case "BankAccount" -> new BankAccountView();
            case "WalletAccount" -> new WalletAccountView();
            default -> null;
        };
    }
}
