package PaymentServices.BillPaymentServices.Controllers;

import Entities.Bills.Bill;
import Entities.User.Account;
import InstapayApplication.Utilites.InstapayUtilites;
import PaymentServices.BillPaymentServices.Views.BillPaymentView;
import PaymentServices.IPaymentServices;
import Providers.AccountProviders.IProvider;
import Providers.BillProviders.BillProvider;

public class BillPaymentServices implements IPaymentServices {
    public void Pay(Account account, IProvider provider) {
        BillProvider billProvider = BillPaymentView.BillSelection();
        if(billProvider==null){
            return;
        }
        System.out.println("Please Enter the Id");
        int billId = InstapayUtilites.TakeInput(Integer.class , "" ,"Invalid Id");
        Bill bill=billProvider.GetBill(billId);
        if(bill==null){
            System.out.println("Bill Not Found");
            return;
        }
        if(bill.isPaid()){
            System.out.println("Bill Already Paid");
        }else{
            bill.PrintBillDetails();
            System.out.println("Do you want to pay the bill ?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int choice = InstapayUtilites.TakeInput(Integer.class , "","Invalid choice");
            if(choice == 1){
                // Reduce the amount from the wallet
                if(account.getAmount()>=bill.getTotalAmount()){
                    provider.Withdraw(account,bill.getTotalAmount());
                    bill.setPaid(true);
                    billProvider.PayBill(bill);  // why PayBill is Boolean ?!??
                    System.out.println("Bill Payed Successfully");
                }else{
                    System.out.println("You Haven't Sufficient Money to Pay");
                }

            }else if(choice == 2){
                return;
            }else{
                System.out.println("Invalid Input");
            }
        }
    }
}
