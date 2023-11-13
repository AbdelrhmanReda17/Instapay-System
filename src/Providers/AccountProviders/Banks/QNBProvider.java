package Providers.AccountProviders.Banks;

import java.io.BufferedReader;
import java.io.FileReader;

import Providers.AccountProviders.BankProvider;
import User.Account;
import User.BankAccount;

public class QNBProvider extends BankProvider {
    private final String Name = "QNB";
    private final String AccountsFilePath = "src\\Database\\QNBAccounts.csv";
    @Override

    public Account getAccount(String AccountId) {
        try (BufferedReader reader = new BufferedReader(new FileReader(AccountsFilePath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if(columns.length != 4) continue;
                if(!columns[0].equals(AccountId)) continue;
                return new BankAccount(columns[0],Double.parseDouble(columns[1]) , this , columns[2]);
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

    
    public Account Deposit(Account account, double ammount) {
        //Deposit should differ from each api to another but we don't have this option
        //so we chose to duplicate.
        if (account != null && account instanceof BankAccount) {
            Account updatedAccount = new BankAccount(((BankAccount)account).getAccountID(),
                                account.getAmount() + ammount, this, account.getPhoneNumber());
            return updatedAccount;
        } else {
            return null;
        }
    }

    public Account Withdraw(Account account, double ammount) {
        //Withdraw should differ from each api to another but we don't have this option
        //so we chose to duplicate.
        if (account != null && account instanceof BankAccount) {
            if (account.getAmount() >= ammount) {
                Account updatedAccount = new BankAccount(((BankAccount)account).getAccountID(),
                                account.getAmount() - ammount, this, account.getPhoneNumber());
                return updatedAccount;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
