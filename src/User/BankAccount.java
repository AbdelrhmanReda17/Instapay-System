package User;
public class BankAccount extends Account {
    private String AccountID;
    private String password;
    private double amount;
    public BankAccount(){}

    public BankAccount(String AccountID, String password , double amount ){
        this.AccountID = AccountID;
        this.password = password;
        this.amount = amount;
    }

    public void Display() {
        System.out.println("Account ID: " + this.AccountID);
        System.out.println("Password: " + this.password);
        System.out.println("Amount: " + this.amount);
    }
}