package User;
public class BankAccount extends Account {
    private String AccountID;
    private String creditCard;
    public BankAccount() {
        super(0 , "Bank" , "0");
    }
    public BankAccount(String AccountID, String creditCard , double Amount , String Bank , String phoneNumber ){
        super(Amount , Bank , phoneNumber);
        this.AccountID = AccountID;
        this.creditCard = creditCard;
    }
    public String getAccountID() {
        return AccountID;
    }
    public void Display() {
        System.out.println("Account ID: " + this.AccountID);
        System.out.println("creditCard: " + this.creditCard);
        System.out.println("Amount: " + getAmount());
    }
    public String getData() {
        return  "Bank" + "-" + getProviderName() + "," + AccountID;
    }
}