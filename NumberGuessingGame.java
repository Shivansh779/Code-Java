import java.util.*;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Welcome to the number Guessing Game.");
        System.out.println("Guess a number from 1 to 100");

        int compNum = rand.nextInt(100) + 1;
        int attempts = 0;

        while (true) {
            try {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number within the range of 1 to 100.");
                } else if (guess > compNum) {
                    System.out.println("Your number is too high. Try again!");
                } else if (guess < compNum) {
                    System.out.println("Your number is too low. Try again!");
                } else {
                    System.out.println("Great! You guessed the number correctly!");
                    System.out.println("You guessed the number in " + attempts + " attempts");
                    System.out.println("The number was: " + compNum);
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please a valid number.");
                sc.next();
            }
        }
        sc.close();
    }
}