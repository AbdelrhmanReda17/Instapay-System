package RegisterationService.Controllers;

import InstapayApplication.Utilites.InstapayUtilites;
import Providers.AccountProviders.IProvider;
import RegisterationService.Views.RegisterView;

public class Authentication {
    public static String Verify(IProvider provider){
        System.out.print("Please enter your Bank Account Number - Exit to close : ");
        String bankId = InstapayUtilites.TakeInput(String.class , "" , "" );
        int OTP = provider.Verify(bankId);
        if(OTP == -1) {
            System.out.println("Invalid Bank Account Number or Bank Account is not registered " + provider.getName() + ". ");
            return null;
        }
        if(RegisterView.VerfiyView(OTP,3)){
            return bankId;
        }
        return null;
    }
}
