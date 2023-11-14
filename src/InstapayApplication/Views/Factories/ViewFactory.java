package InstapayApplication.Views.Factories;

import Entities.User.Account;
import InstapayApplication.Views.MainMenu.BanckAccountView;
import InstapayApplication.Views.MainMenu.MainMenu;
import InstapayApplication.Views.MainMenu.WalletAccountView;


public class ViewFactory {
    public static MainMenu CreateMainMenu(Account account) {
        return switch (account.getClass().getSimpleName()) {
            case "BankAccount" -> new BanckAccountView();
            case "WalletAccount" -> new WalletAccountView();
            default -> null;
        };
    }
}
