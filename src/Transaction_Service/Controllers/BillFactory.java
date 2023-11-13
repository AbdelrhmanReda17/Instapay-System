package Transaction_Service.Controllers;


import Transaction_Service.Bills.Bill;
import Transaction_Service.Bills.ElectricityBills;
import Transaction_Service.Bills.GasBills;
import Transaction_Service.Bills.WaterBills;

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
