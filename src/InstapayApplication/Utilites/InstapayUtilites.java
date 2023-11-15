package InstapayApplication.Utilites;

import Entities.User.Factories.AccountFactory;
import Providers.AccountProviders.IProvider;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;



public class InstapayUtilites {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void Splitter() {
        System.out.println("----------------------------------");
    }
    public static <T> T TakeInput(Class<T> type, String regexPattern , String message) {
        T choice = null;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                    String input = reader.readLine();
                    if (input.matches(regexPattern) || regexPattern.isEmpty() || (input.equals("Exit") && type.equals(String.class))
                            || (input.equals("0") && type.equals(Integer.class) || (input.equals("0") && type.equals(Double.class)))) {
                        if(type.equals(Integer.class)){
                            choice = type.cast(Integer.parseInt(input));
                        }else if(type.equals(Double.class)) {
                            choice = type.cast(Double.parseDouble(input));
                        }else{
                            choice = type.cast(input);
                        }
                        isValidInput = true;
                    } else {
                        System.out.print(message);
                    }
            } catch (Exception e) {
                System.out.print("Invalid input, please try again: ");
            }
        }
        return choice;
    }

    
    public static int GenericMenu(Set<String> Array , String name){
        System.out.println("Please Select your " + name + " : ");
        for (int i = 1; i < Array.size() + 1; i++){
            System.out.println(i + ". " + Array.toArray()[i - 1]);
        }
        System.out.println("0. Exit");
        System.out.print("Please select an option [0 - "+ Array.size() +"]: ");
        return InstapayUtilites.TakeInput(Integer.class , "[0-"+Array.size()+"]" , "Invalid input, please enter a number between [0 - "+ Array.size() +"]: " );
    }

    public static IProvider GenericSelection(AccountFactory accountFactory , String name){
        Set<String> FactoryArray = accountFactory.GetProviders();
        int choice = InstapayUtilites.GenericMenu(FactoryArray , name);
        if (choice == 0) {
            return null;
        }
        return accountFactory.CreateProvider(FactoryArray.toArray()[choice - 1].toString());
    }

}
