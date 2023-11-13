package Providers.AccountProviders.Banks;

import java.io.BufferedReader;
import java.io.FileReader;

import Providers.AccountProviders.BankProvider;
import User.model.Account;
import User.model.BankAccount;

public class QNBProvider extends BankProvider {
    private final String Name = "QNB";
    private Account updatedAccount;
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
                return new BankAccount(columns[0],Double.parseDouble(columns[2]) , this , columns[3]);
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
