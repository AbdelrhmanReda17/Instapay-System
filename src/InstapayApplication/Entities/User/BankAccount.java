package InstapayApplication.Entities.User;

public class BankAccount extends Account {
    public BankAccount(String AccountID , String password, double Amount , String phoneNumber ){
        super( AccountID , password,Amount , phoneNumber);
    }

    public String getData() {
        return  getAccountId();
    }
    public String getType() {
        return  "Bank";
    }
}