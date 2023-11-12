package User;
public class WalletAccount extends Account {
    private int walletID;
    private String phoneNumber;
    private String Wallet;
    public WalletAccount(){
        super(0 , "Wallet" , "0");
    }
    public WalletAccount(String phoneNumber, double amount , String Wallet , int walletID){
        super(amount , Wallet , phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void Display() {
        System.out.println("Wallet ID: " + this.walletID);
        System.out.println("Wallet Phone Number: " + this.phoneNumber);
    }
    public String getData(){
        return "Wallet" + "-" + getProviderName() + "," + walletID;
    }
}