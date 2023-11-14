package Transaction_Service.Controllers;

import InstapayApplication.Utilites.InstapayUtilites;
import Providers.BillProviders.BillProvider;
import Entities.User.User;
import Entities.Bills.Bill;
import Transaction_Service.view.transactionsView;
import Transaction_Service.view.Transfer.TransferViewFactory;

public class TranscationService
{
    User user;
    TransferController transferController;
    public TranscationService(User user){
        this.user=user;
    }

    public void transaction(User user){
        while(true){
            int choice =  transactionsView.transactionsMenu(user);
            switch (choice) {
                case 1:
                    
                    break;
                case 2:
                    PayBill();
                    break;
                case 3,4,5:
                    TransferViewFactory.CreateTransferViewMenu(choice).Transfer(transferController, user);
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        }
    }

    void  PayBill(){
        BillProvider billProvider = transactionsView.BillSelection();
        if(billProvider==null){
            return;
        }
        System.out.println("Please Enter the Id");
        int billId = InstapayUtilites.TakeInput(Integer.class , "" ,"Invalid Id");
        Bill bill=billProvider.GetBill(billId);
        if(bill!=null){
            if(bill.isPaid()){
                System.out.println("Paid");
            }else{
                bill.PrintBillDetails();
                System.out.println("Do you Want To Pay ");
                System.out.println("1. Yes");
                System.out.println("2. No");
                int choice = InstapayUtilites.TakeInput(Integer.class , "","Invalid choice");
                if(choice == 1){
                    //reduce the amount from the wallet
                    if(user.getAccount().getAmount()>=bill.getTotalAmount()){
                        user.getAccount().getProvider().Withdraw(user.getAccount(),bill.getTotalAmount());
                        bill.setPaid(true);
                        billProvider.PayBill(bill);
                        System.out.println("Bill Payed Sucessfully");

                    }else{
                        System.out.println("You Havent Sufficient Money to Pay");
                    }

                }else if(choice == 2){
                    return;
                }else{
                    System.out.println("Invalid Input");
                }
            }
        }else{
            return;
        }

    }

}
