package Providers.AccountProviders.Wallets;

import Providers.AccountProviders.WalletProvider;
import User.Account;
import User.WalletAccount;

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
    @Override
    public Account UpdateHandler() {
        return null;
    }
}
