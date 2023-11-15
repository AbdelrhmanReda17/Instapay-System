package InstapayApplication.Entities.User;

public class WalletAccount extends Account {
    public WalletAccount(String walletID , String password, double amount , String phoneNumber){
        super( walletID , password ,amount, phoneNumber);
    }
    public String getData(){
        return getPhoneNumber();
    }
    public String getType() {
        return  "Wallet";
    }
}