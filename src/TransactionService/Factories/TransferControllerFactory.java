package TransactionService.Factories;

import TransactionService.ApplicationTransactionService.Controllers.InstapayTransferController;
import TransactionService.BankTransactionService.Controllers.BankTransferController;
import TransactionService.TransferController;
import TransactionService.WalletTransactionService.Controllers.WalletTransferController;

public class TransferControllerFactory {
    public static TransferController CreateTransferController(int choice) {
        return switch(choice) {
            case 3 -> new WalletTransferController();
            case 4 -> new InstapayTransferController();
            case 5 -> new BankTransferController();
            default -> null;
        };
    }
}
