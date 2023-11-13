package Providers.BillProviders;

import Transaction_Service.Bills.Bill;

public  interface BillProvider {
    public Bill GetBill(int billId);
    public boolean PayBill(Bill updateBill);

}
