package Transaction_Service.view;

import Entities.User.Account;
import Entities.User.User;
import Transaction_Service.view.Transfer.TransferView;

public class ViewFactory {
    public static TransactionMenu CreateTransactionMenu(Account account) {
        return switch (account.getClass().getName()) {
            case "BankAccount" -> new BanckAccVeiw();
            case "WalletAccount" -> new WalletAccView();
            default -> null;
        };
    }
}
