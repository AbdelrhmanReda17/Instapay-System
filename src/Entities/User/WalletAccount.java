package Entities.User;

import Providers.AccountProviders.IProvider;

public class WalletAccount extends Account {
    public WalletAccount(String walletID, double amount , String phoneNumber){
        super( walletID ,amount, phoneNumber);
    }
    public String getData(){
        return getPhoneNumber();
    }
    public String getType() {
        return  "Wallet";
    }
}