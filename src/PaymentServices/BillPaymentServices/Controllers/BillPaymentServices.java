package PaymentServices.BillPaymentServices.Controllers;

import InstapayApplication.Entities.Bills.Bill;
import InstapayApplication.Entities.User.Account;
import PaymentServices.BillPaymentServices.Views.BillPaymentView;
import PaymentServices.IPaymentServices;
import Providers.AccountProviders.IProvider;
import Providers.BillProviders.BillProvider;

public class BillPaymentServices implements IPaymentServices {
    @Override
    public void Pay(Account account, IProvider provider) {
        BillProvider billProvider = BillPaymentView.BillSelection();
        if(billProvider==null){
            return;
        }
        Bill bill=BillPaymentView.CheckBill(billProvider);
        if(bill!=null){
            bill.PrintBillDetails();
            boolean choice = BillPaymentView.ConfirmPayment();
            if(choice) {
                // Reduce the amount from the wallet
                if (account.getAmount() >= bill.getTotalAmount()) {
                    if(billProvider.PayBill(bill)){
                        provider.Withdraw(account, bill.getTotalAmount());
                        System.out.println("Bill Payed Successfully");
                    }else{
                        System.out.println("Error In Payment");
                    }
                } else {
                    System.out.println("No Sufficient Money");
                }
            }
        }
    }
}
