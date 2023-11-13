package User.model;

import Providers.AccountProviders.IProvider;
import User.model.Account;

public class WalletAccount extends Account {
    private String walletID;
    private String phoneNumber;
    public WalletAccount(){
        super(0 , null , "0");
    }
    public WalletAccount(String phoneNumber, double amount , IProvider walletProvider , String walletID){
        super(amount , walletProvider , phoneNumber);
        this.walletID = walletID;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWalletID() {
        return walletID;
    }

    public void Display() {
        System.out.println("Wallet ID: " + this.walletID);
        System.out.println("Wallet Phone Number: " + this.phoneNumber);
    }
    public String getData(){
        return "Wallet" + "-" + getProvider().toString() + "," + walletID;
    }
}