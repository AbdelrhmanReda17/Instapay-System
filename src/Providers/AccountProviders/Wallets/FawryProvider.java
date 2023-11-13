package Providers.AccountProviders.Wallets;

import Providers.AccountProviders.WalletProvider;
import User.Account;
import User.BankAccount;
import User.WalletAccount;

import java.io.BufferedReader;
import java.io.FileReader;

public class FawryProvider extends WalletProvider {
    private final String Name = "Fawry";
    private final String AccountsFilePath = "src\\Database\\FawryAccounts.csv";
    public Account Update() {
        return null;
    }

    @Override
    public String getName() {
        return Name;
    }

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

    public Account Deposit(Account account, double ammount) {
        //Deposit should differ from each api to another but we don't have this option
        //so we chose to duplicate.
        if (account instanceof WalletAccount) {
            Account updatedAccount = new WalletAccount(account.getPhoneNumber(),
                 account.getAmount() + ammount, this,((WalletAccount)account).getWalletID());
            return updatedAccount;
        } else {
            return null;
        }
    }

    public Account Withdraw(Account account, double ammount) {
        //Withdraw should differ from each api to another but we don't have this option
        //so we chose to duplicate.
        if ( account instanceof WalletAccount) {
            if (account.getAmount() >= ammount) {
                Account updatedAccount = new WalletAccount(account.getPhoneNumber(),
                     account.getAmount() - ammount, this,((WalletAccount)account).getWalletID());
                return updatedAccount;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}