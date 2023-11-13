package User;

import Providers.AccountProviders.IProvider;

public class WalletAccount extends Account {
    private int walletID;
    private String phoneNumber;
    public WalletAccount(){
        super(0 , null , "0");
    }
    public WalletAccount(String phoneNumber, double amount , IProvider walletProvider , int walletID){
        super(amount , walletProvider , phoneNumber);
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
        return "Wallet" + "-" + getProvider().toString() + "," + walletID;
    }
}