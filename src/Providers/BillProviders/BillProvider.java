package Providers.BillProviders;

import Entities.Bills.Bill;

public  interface BillProvider {
    public Bill GetBill(int billId);
    public boolean PayBill(Bill updateBill);

}
