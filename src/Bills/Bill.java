package Bills;

public abstract class Bill {
    private String username;
    private int billId;
    double totalAmount;
    boolean isPaid;
    Bill(int billId,String username,double amount , boolean isPaid){
        this.billId=billId;
        this.username=username;
        this.totalAmount = amount;
        this.isPaid = false;
    }
    Bill(){}
    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public abstract void PrintBillDetails();
    public abstract void setUsage(double usage);
}