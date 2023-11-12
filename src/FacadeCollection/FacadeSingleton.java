package FacadeCollection;

import java.io.Console;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FacadeSingleton {
    private FacadeSingleton() {}

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static <T> T TakeInput(Class<T> type, String regexPattern) {
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
                            System.out.println("Invalid input. Please try again.");
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

    public static void Splitter() {
        System.out.println("----------------------------------");
    }

    public static void DisplayExitMessage() {
        System.out.println("----------------------------------");
        System.out.println("       Thank you for using        ");
        System.out.println("----------------------------------");
    }

    public static void DisplayStartMessage() {
        System.out.println("----------------------------------");
        System.out.println("       Welcome to Instapay        ");
        System.out.println("----------------------------------");
    }
}
