package Transaction_Service.view.Transfer;

/**
 * TransferViewFactory
 */
public class TransferViewFactory {
    public static TransferView CreateTransferViewMenu(int choice) {
        return switch(choice) {
            case 3 -> new WalletTransferView();
            case 4 -> new InstapayTransferView();
            case 5 -> new BankAccountTransferView(); 
            default -> null;
        };
    }
}