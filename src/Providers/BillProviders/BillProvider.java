package Providers.BillProviders;

import Bills.Bill;

public interface BillProvider {
    public Bill GetBill(int BillId);
    public boolean UpdateBill(Bill bill);
}
