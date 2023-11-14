package TransactionService.Factories;

import TransactionService.ApplicationTransactionService.Views.InstapayTransferMenu;
import TransactionService.BankTransactionService.Views.BankAccountTransferMenu;
import TransactionService.TransferMenuView;
import TransactionService.WalletTransactionService.Views.WalletTransferTransferMenu;

/**
 * TransferViewFactory
 */
public class TransferMenuFactory {
    public static TransferMenuView CreateTransferViewMenu(int choice) {
        return switch(choice) {
            case 3 -> new WalletTransferTransferMenu();
            case 4 -> new InstapayTransferMenu();
            case 5 -> new BankAccountTransferMenu();
            default -> null;
        };
    }
}