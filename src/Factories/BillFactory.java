package Factories;


import Bills.Bill;
import Bills.ElectricityBills;
import Bills.GasBills;
import Bills.WaterBills;

public class BillFactory {
    public static Bill CreateBill(String type){
        return switch (type) {
            case "Gas" -> new GasBills();
            case "Water" -> new WaterBills();
            case "Electricity" -> new ElectricityBills();

            default -> null;
        };

    }
}
