package Providers.BillProviders;

import Entities.Bills.Bill;

public  interface BillProvider {
    Bill GetBill(int billId);
    boolean PayBill(Bill updateBill);

}
