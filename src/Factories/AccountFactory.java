package Factories;
import User.Account;
import User.BankAccount;
import User.WalletAccount;
public class AccountFactory {

    public Account CreateAccount(String type) {
        return switch (type) {
            case "Bank" -> new BankAccount();
            case "Wallet" -> new WalletAccount();
            default -> null;
        };
    }

}