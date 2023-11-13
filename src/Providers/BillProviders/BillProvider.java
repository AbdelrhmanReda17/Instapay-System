package Providers.BillProviders;

import Bills.Bill;
import Bills.ElectricityBills;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public  interface BillProvider {
    public Bill GetBill(int billId);
    public boolean PayBill(Bill updateBill);

}
