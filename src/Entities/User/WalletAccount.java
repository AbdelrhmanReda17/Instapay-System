package Entities.User;

import Providers.AccountProviders.IProvider;

public class WalletAccount extends Account {
    public WalletAccount(String walletID, double amount , IProvider walletProvider , String phoneNumber){
        super( walletID ,amount , walletProvider , phoneNumber);
    }
    public String getData(){
        return "Wallet" + "-" + getProvider().getName() + "," + getPhoneNumber();
    }
}