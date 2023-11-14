package Entities.Bills.Factories;


import Entities.Bills.Bill;
import Entities.Bills.ElectricityBills;
import Entities.Bills.GasBills;
import Entities.Bills.WaterBills;

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
