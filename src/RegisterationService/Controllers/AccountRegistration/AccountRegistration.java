package RegisterationService.Controllers.AccountRegistration;

import InstapayApplication.Entities.User.Account;
import Utilites.InstapayUtilites;
import Providers.AccountProviders.IProvider;
import RegisterationService.Views.RegisterView;

import java.util.Map;

public abstract class AccountRegistration {
    abstract public Map.Entry<Account, IProvider> Register();
    public static String Verify(IProvider provider , String name){
        System.out.print("Please enter your "+ name +" Number - Exit to close : ");
        String bankId = InstapayUtilites.TakeInput(String.class , "" , "" );
        int OTP = provider.Verify(bankId);
        if(OTP == -1) {
            System.out.println("Invalid " + provider.getName() +" Number or " + provider.getName() + " is not registered. ");
            return null;
        }
        if(RegisterView.VerfiyView(OTP,3)) return bankId;
        return null;
    }
}
