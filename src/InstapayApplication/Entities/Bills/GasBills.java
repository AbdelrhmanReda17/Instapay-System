package InstapayApplication.Entities.Bills;

public class GasBills extends Bill {
    private double usageInCubicMeters;
    public GasBills(int billId, String username, double amount, boolean isPaid, double usageInCubicMeters){
        super( billId, username, amount ,  isPaid);
        this.usageInCubicMeters = usageInCubicMeters;
    }
    public GasBills(){}



    @Override
    public void PrintBillDetails() {
        System.out.println("Gas Bill");
        System.out.println("Usage: " + this.usageInCubicMeters + " cubic meters");
        System.out.println("Total Amount: " + this.totalAmount);
        System.out.println("Is Paid: " + this.isPaid);
    }

}
