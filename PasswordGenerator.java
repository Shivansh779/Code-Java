import java.util.Scanner;
import java.util.InputMismatchException;
import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890@!$%()*#^&";

    public static String passwordGen(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(index));
        }
        return password.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter the length of the password: ");
                int length = sc.nextInt();
                String password = passwordGen(length);
                System.out.println("The password generated is: " + password);

                System.out.println("Do you want generate another password?");
                String userChoice = sc.next();
                if (userChoice.equalsIgnoreCase("NO")) {
                    System.out.println("Have a good day. Program Terminated.");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input.");
                sc.next();
            }
        }
        sc.close();
    }
}
