package Entities.User.Factories;
import Entities.User.Account;
import Entities.User.BankAccount;
import Entities.User.WalletAccount;
public class AccountFactory {
    public Account CreateAccount(String type) {
        return switch (type) {
            case "Bank" -> new BankAccount();
            case "Wallet" -> new WalletAccount();
            default -> null;
        };
    }

}