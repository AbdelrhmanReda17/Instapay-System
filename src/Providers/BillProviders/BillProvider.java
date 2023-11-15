package Providers.BillProviders;

import InstapayApplication.Entities.Bills.Bill;

public  interface BillProvider {
    Bill GetBill(int billId);
    boolean PayBill(Bill updateBill);

}
