package Providers.AccountProviders;
import Entities.User.Account;
import java.util.Random;

public abstract class BankProvider extends IProvider {

    @Override
    public int Verify(String AccountId) {
        int OTP = Integer.parseInt(generateOTP());
        Account account = getAccount(AccountId);
        if(account != null){
            String phone = account.getPhoneNumber().substring(0, 2) + "*******" + account.getPhoneNumber().substring(7);
            System.out.println("An OTP has been sent to your phone number " + phone + " , please enter it to verify your account");
            // Send OTP to the user via SMS
            return OTP;
        }
        return -1;
    }
}
