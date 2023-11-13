package Providers.AccountProviders.Wallets;

import Providers.AccountProviders.WalletProvider;
import User.model.Account;
import User.model.WalletAccount;

import java.io.BufferedReader;
import java.io.FileReader;

public class VodafoneProvider extends WalletProvider {
    private final String Name = "Vodafone";
    private final String AccountsFilePath = "src\\Database\\VodafoneAccounts.csv";
    @Override
    public Account getAccount(String PhoneNumber) {
        try (BufferedReader reader = new BufferedReader(new FileReader(AccountsFilePath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if(columns.length != 4) continue;
                if(!columns[3].equals(PhoneNumber)) continue;
                return new WalletAccount(columns[3],Double.parseDouble(columns[2]),this,columns[0]);
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    @Override
    public String getName() {
        return Name;
    }
    public Account Update() {
        return null;
    }

    @Override
    public void Deposit(Account account, double ammount) {
        //Deposit should differ from each api to another but we don't have this option
        //so we chose to duplicate.
        double currentAmount = account.getAmount();
        account.setAmount(currentAmount + ammount);
    }
    @Override
    public boolean Withdraw(Account account, double ammount) {
        //Withdraw should differ from each api to another but we don't have this option
        //so we chose to duplicate.
        double currentAmount = account.getAmount();
        if (currentAmount >= ammount) {
            account.setAmount(currentAmount - ammount);
            return true;
        } else {
            return false;

        }
    }
}
