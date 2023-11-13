package Main;

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
                if (type.equals(String.class)) {
                    String input = reader.readLine();
                    if (input.matches(regexPattern) || regexPattern.isEmpty()) {
                        choice = type.cast(input);
                        isValidInput = true;
                    } else {
                        System.out.println(message);
                    }
                } else if (type.equals(Integer.class)) {
                    choice = type.cast(Integer.parseInt(reader.readLine()));
                    isValidInput = true;
                } else if (type.equals(Double.class)) {
                    choice = type.cast(Double.parseDouble(reader.readLine()));
                    isValidInput = true;
                } else {
                    return choice;
                }
            } catch (Exception e) {
                System.out.print("Invalid input, please try again: ");
            }
        }
        return choice;
    }

}
