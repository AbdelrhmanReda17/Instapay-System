package Providers.AccountProviders;

import Entities.User.Account;

public abstract class WalletProvider extends IProvider {
    @Override
    public int Verify(String phone ){
        int OTP = Integer.parseInt(generateOTP());
        Account account = getAccount(phone);
        if(account != null){
            String num = phone.substring(0, 2) + "*******" + phone.substring(7);
            System.out.println("An OTP has been sent to your phone number " + num  + " , please enter it to verify your Wallet");
            return OTP;
        }
        return -1;
    }
}
