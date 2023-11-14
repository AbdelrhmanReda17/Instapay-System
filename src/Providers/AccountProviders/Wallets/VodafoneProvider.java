package Providers.AccountProviders.Wallets;

import Providers.AccountProviders.WalletProvider;
import Entities.User.Account;
import Entities.User.WalletAccount;

import java.io.BufferedReader;
import java.io.FileReader;

public class VodafoneProvider extends WalletProvider {
     final String AccountsFilePath = "src\\InstapayDatabase\\Database\\VodafoneAccounts.csv";
    @Override
    //code Dublication.
    public Account getAccount(String PhoneNumber) {
        try (BufferedReader reader = new BufferedReader(new FileReader(AccountsFilePath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if(columns.length != 4) continue;
                if(!columns[3].equals(PhoneNumber)) continue;
                return new WalletAccount(columns[0],Double.parseDouble(columns[2]),this,columns[3]);
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    @Override
    public String getName() {
        return "Vodafone";
    }
    @Override
    public void Update(String userID) {
        //Update User Data.
    }


    @Override
    public void Deposit(Account account, double ammount) {
        //Deposit should differ from each api to another but we don't have this option
        //so we chose to duplicate.
        double currentAmount = account.getAmount();
        account.setAmount(currentAmount + ammount);
        Update(account.getAccountId());
    }
    @Override
    public boolean Withdraw(Account account, double ammount) {
        //Withdraw should differ from each api to another but we don't have this option
        //so we chose to duplicate.
        double currentAmount = account.getAmount();
        if (currentAmount >= ammount) {
            account.setAmount(currentAmount - ammount);
            Update(account.getAccountId());
            return true;
        } else {
            return false;

        }
    }
}
