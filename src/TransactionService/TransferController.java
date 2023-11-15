package TransactionService;

import Providers.AccountProviders.IProvider;
import Entities.User.Account;
import Entities.User.User;

import java.util.Map;

public abstract class TransferController {
    private final TransferValidator validator = new WalletToBankValidator();
    public abstract Map.Entry<Account,IProvider> ParseUserData(IProvider provider,String[] data);
    public boolean Transfer(TransferMenuView menuView, Account srcAccount, IProvider srcProvider) {
        String[] userInput = menuView.Display();
        return userInput != null && TransferHandler(srcAccount,srcProvider,userInput,menuView.getDistUserProvider());
    }
    public boolean TransferHandler(Account srcAccount,IProvider srcProvider, String[] userInputData,IProvider distUserProvider) {
        Map.Entry<Account,IProvider> distUser = ParseUserData(distUserProvider, userInputData);
        if(distUser == null) {
            System.out.println("Account not found !");
            return false;
        }
        if( (distUser.getKey().getAccountId().equals(srcAccount.getAccountId()) &&  srcProvider.getName().equals(distUser.getValue().getName()))
                || distUser.getKey().getPhoneNumber().equals(srcAccount.getPhoneNumber()) && srcProvider.getName().equals(distUser.getValue().getName()) ) {
            System.out.println("Cannot transfer to the same account !! ");
            return false;
        }
        double amount = Double.parseDouble(userInputData[1]);
        if (validator.Validate(srcAccount , distUser.getKey()) && srcProvider.Withdraw(srcAccount, amount)) {
            distUser.getValue().Deposit(distUser.getKey(), amount);
            System.out.println("Transaction done successfully");
            return true;
        }
        else {
            return false;
        }
    }
}
