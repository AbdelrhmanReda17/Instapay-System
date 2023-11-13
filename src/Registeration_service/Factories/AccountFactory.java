package Registeration_service.Factories;
import User.model.Account;
import User.model.BankAccount;
import User.model.WalletAccount;
public class AccountFactory {

    public Account CreateAccount(String type) {
        return switch (type) {
            case "Bank" -> new BankAccount();
            case "Wallet" -> new WalletAccount();
            default -> null;
        };
    }

}