package User;
public class BankAccount extends Account {
    private String AccountID;
    private String password;
    public BankAccount() {
        super(0);
    }
    public BankAccount(String AccountID, String password , double amount ){
        super(amount);
        this.AccountID = AccountID;
        this.password = password;
    }

    public String getAccountID() {
        return AccountID;
    }

    public void Display() {
        System.out.println("Account ID: " + this.AccountID);
        System.out.println("Password: " + this.password);
        System.out.println("Amount: " + getAmount());
    }
    public String getData(){
        return AccountID + "," + getAmount();
    }
}