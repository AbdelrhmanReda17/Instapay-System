package Bills;
public class WaterBills extends Bill {
    private double usageInGallons;
    public WaterBills(int billId, String username, double amount , boolean isPaid, double usageInGallons){
        super( billId, username, amount , isPaid );
        this.usageInGallons = usageInGallons;
    }
    public WaterBills(){}
    public void setUsage(double usage){
        this.usageInGallons = usage;
    }


    @Override
    public void PrintBillDetails() {
        System.out.println("Water Bill");
        System.out.println("Usage: " + this.usageInGallons + " gallons");
        System.out.println("Total Amount: " + this.totalAmount);
        System.out.println("Is Paid: " + this.isPaid);
    }

}