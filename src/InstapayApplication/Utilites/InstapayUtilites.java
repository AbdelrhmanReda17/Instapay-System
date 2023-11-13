package InstapayApplication.Utilites;

import java.io.BufferedReader;
import java.io.InputStreamReader;



public class InstapayUtilites {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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
                        System.out.println(message);
                    }
            } catch (Exception e) {
                System.out.print("Invalid input, please try again: ");
            }
        }
        return choice;
    }

}
