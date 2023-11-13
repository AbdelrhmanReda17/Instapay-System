package Transaction_Service.Controllers;

import Istapay_interface.view.InstapayView;
import User.model.User;
import Transaction_Service.view.transactionsView;
public class Transcation_Service
{
    User user;
    public Transcation_Service(User user){
        this.user=user;
    }

    public void transaction(User user){
       while(true){
       int choice=  transactionsView.transactionsMenu(user);
           switch (choice) {
                case 1:
                    WalletTransfer();
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
                    BankTransfer();
                    break;
                default:
                    break;
            }
        }
    }

    void WalletTransfer(){
        transferController = new WalletTransferController();
        System.out.print("Please enter the mobile number: ");
        String mobileNumber = InstapayView.TakeInput(String.class, "" , "");
        System.out.print("Please enter the amount: ");
        double amount = InstapayView.TakeInput(Double.class, "" , "");
        if (transferController.Transfer(user , mobileNumber , amount)) {
            System.out.println("Transfer completed successfully");
        }
    }
    void InstapayTransfer(){
        transferController = new InstapayTransferController();
        System.out.print("Please enter the instapay account number : ");
        String accountNumber = InstapayView.TakeInput(String.class, "" , "");
        System.out.print("Please enter the amount: ");
        double amount = InstapayView.TakeInput(Double.class, "" , "");
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
        int billId = InstapayView.TakeInput(Integer.class , "" ,"Invalid Id");
        Bill bill=billProvider.GetBill(billId);
        if(bill!=null){
            if(bill.isPaid()){
                System.out.println("Paid");
            }else{
                bill.PrintBillDetails();
                System.out.println("Do you Want To Pay ");
                System.out.println("1. Yes");
                System.out.println("2. No");
                int choice= InstapayView.TakeInput(Integer.class , "","Invalid choice");
                if(choice==1){
                    //reduce the amount from the wallet
                    if(user.getAccount().getAmount()>=bill.getTotalAmount()){
                        user.getAccount().getProvider().Withdraw(user.getAccount(),bill.getTotalAmount());
                        bill.setPaid(true);
                        billProvider.PayBill(bill);
                        System.out.println("Bill Payed Sucessfully");

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
            int choice = InstapayView.TakeInput(Integer.class , "","" );
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
        String accountNumber = Main.InstapayUtilites.TakeInput(String.class, "" , "");
        System.out.print("Please enter the amount: ");
        double amount = Main.InstapayUtilites.TakeInput(Double.class, "" , "");
        if (transferController.Transfer(user , accountNumber , amount)) {
            System.out.println("Transfer completed successfully");
        }
    }
}