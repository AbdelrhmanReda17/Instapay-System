import Controllers.TransferController;
import FacadeCollection.FacadeSingleton;
import FacadeCollection.UserFacade;
import User.User ;
import User.BankAccount;

public class InstapayFacade {
    public UserFacade userFacade;
    public User user;
    public TransferController transferController;
    public InstapayFacade() {
        user = new User();
        userFacade = new UserFacade();
    }
    void StartApplication () {
        FacadeSingleton.DisplayStartMessage();
        while(true){
            user = userFacade.MainMenu();
            if(user == null){
                FacadeSingleton.DisplayExitMessage();
                return;
            }
            System.out.println("Welcome " + user.getUsername());
            StartMenu();
        }
    }

    void StartMenu() {
        boolean isBankAccount = false;
        if(user.getAccount() instanceof BankAccount) {
            isBankAccount = true;
        }
        while(true){
            System.out.println("1. Inquire about his balance");
            System.out.println("2. Pay Bill");
            System.out.println("3. Transfer to Wallet using the mobile number");
            System.out.println("4. Transfer to Another instapay account");
            if(isBankAccount)
                System.out.println("5. Transfer to Bank Account");
            System.out.println("0. Log out");
            System.out.print("Please select an option [0 - 4]: ");
            int choice = FacadeSingleton.TakeInput(Integer.class, "" );
            switch (choice) {
                case 1:
//                    WalletTransfer();
                    break;
                case 2:
//                    InstapayTransfer();
                    break;
                case 3:
                  WalletTransfer();
                    break;
                case 4:
                  InstapayTransfer();
                    break;
                case 0:
                    return;
                case 5:
                    if(isBankAccount){
                        BankTransfer();
                        break;
                    }
                default:
                    System.out.println("Invalid input, please enter a number between 0 and 4.");
                    break;
            }
        }
    }

    void WalletTransfer(){
        transferController = new Controllers.WalletTransferController();
        System.out.print("Please enter the mobile number: ");
        String mobileNumber = FacadeSingleton.TakeInput(String.class, "");
        System.out.print("Please enter the amount: ");
        double amount = FacadeSingleton.TakeInput(Double.class, "");
        if (transferController.Transfer(user , mobileNumber , amount)) {    
            System.out.println("Transfer completed successfully");
        }
    }
    void InstapayTransfer(){
        System.out.print("Please enter the instapay account number : ");
        String accountNumber = FacadeSingleton.TakeInput(String.class, "");
        System.out.print("Please enter the amount: ");
        double amount = FacadeSingleton.TakeInput(Double.class, "");
        if (transferController.Transfer(user , accountNumber , amount)) {    
            System.out.println("Transfer completed successfully");
        }
    }

    void BankTransfer(){
        System.out.print("Please enter the account number number: ");
        String accountNumber = FacadeSingleton.TakeInput(String.class, "");
        System.out.print("Please enter the amount: ");
        double amount = FacadeSingleton.TakeInput(Double.class, "");
        if (transferController.Transfer(user , accountNumber , amount)) {    
            System.out.println("Transfer completed successfully");
        }
    }

}
