package Bills;
public class ElectricityBill extends Bill {

    private double usageInKWh;
    public ElectricityBill(int billId, String username, double amount, boolean isPaid, double usageInKWh){
        super(billId, username, amount ,isPaid);
        this.usageInKWh = usageInKWh;
    }
    public ElectricityBill(){}
    public void setUsage(double usage){
        this.usageInKWh = usage;

    }

    @Override
    public void PrintBillDetails() {
        System.out.println("Electricity Bill");
        System.out.println("Usage: " + this.usageInKWh + " kWh");
        System.out.println("Total Amount: " + this.totalAmount);
        System.out.println("Is Paid: " + this.isPaid);
    }

}