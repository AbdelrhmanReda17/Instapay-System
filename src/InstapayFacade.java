import Bills.Bill;
import Controllers.BankTransferController;
import Controllers.InstapayTransferController;
import Controllers.TransferController;
import Controllers.WalletTransferController;
import FacadeCollection.FacadeSingleton;
import FacadeCollection.UserFacade;
import Factories.BillProvidersFactory;
import Providers.BillProviders.BillProvider;
import User.User ;
import User.BankAccount;

import java.util.Set;

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
            int choice = FacadeSingleton.TakeInput(Integer.class, "" , "");
            switch (choice) {
                case 1:
//                    WalletTransfer();
                    break;
                case 2:
                    PayBill();
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
        transferController = new WalletTransferController();
        System.out.print("Please enter the mobile number: ");
        String mobileNumber = FacadeSingleton.TakeInput(String.class, "" , "");
        System.out.print("Please enter the amount: ");
        double amount = FacadeSingleton.TakeInput(Double.class, "" , "");
        if (transferController.Transfer(user , mobileNumber , amount)) {    
            System.out.println("Transfer completed successfully");
        }
    }
    void InstapayTransfer(){
        transferController = new InstapayTransferController();
        System.out.print("Please enter the instapay account number : ");
        String accountNumber = FacadeSingleton.TakeInput(String.class, "" , "");
        System.out.print("Please enter the amount: ");
        double amount = FacadeSingleton.TakeInput(Double.class, "" , "");
        if (transferController.Transfer(user , accountNumber , amount)) {    
            System.out.println("Transfer completed successfully");
        }
    }
    void  PayBill(){
        BillProvider billProvider=BillSelection();
        if(billProvider==null){
            return;
        }
        System.out.println("Please Enter the Id");
        int billId = FacadeSingleton.TakeInput(Integer.class , "" ,"Invalid Id");
        Bill bill=billProvider.GetBill(billId);
        if(bill!=null){
            if(bill.isPaid()){
                System.out.println("Paid");
            }else{
                bill.PrintBillDetails();
                System.out.println("Do you Want To Pay ");
                System.out.println("1. Yes");
                System.out.println("2. No");
                int choice=FacadeSingleton.TakeInput(Integer.class , "","Invalid choice");
                if(choice==1){
                    //reduce the amount from the wallet
                    if(user.getAccount().getAmount()>=bill.getTotalAmount()){
                        user.getAccount().getProvider().Withdraw(user.getAccount(),bill.getTotalAmount());
                        bill.setPaid(true);
                        billProvider.PayBill(bill);
                    }else{
                        System.out.println("You Havent Sufficient Money to Pay");
                    }

                }else if(choice==2){
                    return;
                }else{
                    System.out.println("Invalid Input");
                }
            }
        }else{
            return;
        }

    }
     BillProvider BillSelection(){
        System.out.println("Please Select your Bill To Pay : ");
        BillProvidersFactory billProvidersFactory=new BillProvidersFactory();
        Set<String> billProvidersFactoryArray = billProvidersFactory.GetBillProviders();
        for (int i = 1; i < billProvidersFactoryArray.size() + 1; i++){
            System.out.println(i + ". " + billProvidersFactoryArray.toArray()[i - 1]);
        }
        System.out.println("0. Exit");
        System.out.print("Please select an option [0 - "+ billProvidersFactoryArray.size() +"]: ");

        while (true){
            int choice = FacadeSingleton.TakeInput(Integer.class , "","" );
            if (choice == 0) {
                return  null;
            }
            else if (choice > 0 && choice <= billProvidersFactoryArray.size()) {
                return BillProvidersFactory.CreateBillProvider(billProvidersFactoryArray.toArray()[choice - 1].toString());
            }
            else {
                System.out.println("Invalid input, please enter a number between [0 - "+ billProvidersFactoryArray.size() +"]: ");
            }
        }

    }

    void BankTransfer(){
        transferController = new BankTransferController();
        System.out.print("Please enter the account number number: ");
        String accountNumber = FacadeSingleton.TakeInput(String.class, "" , "");
        System.out.print("Please enter the amount: ");
        double amount = FacadeSingleton.TakeInput(Double.class, "" , "");
        if (transferController.Transfer(user , accountNumber , amount)) {    
            System.out.println("Transfer completed successfully");
        }
    }

}
