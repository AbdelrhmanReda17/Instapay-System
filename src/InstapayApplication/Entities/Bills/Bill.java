package InstapayApplication.Entities.Bills;

public abstract class Bill {
    public String getUsername() {
        return username;
    }
    public int getBillId() {
        return billId;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public boolean isPaid() {
        return isPaid;
    }
    private String username;
    private int billId;
    double totalAmount;
    boolean isPaid;
    Bill(int billId,String username,double amount , boolean isPaid){
        this.billId=billId;
        this.username=username;
        this.totalAmount = amount;
        this.isPaid = isPaid;
    }
    Bill(){}
    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }
    public abstract void PrintBillDetails();
}
