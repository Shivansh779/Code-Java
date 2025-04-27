import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class StonePaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // declare variables to count the wins, losses, ties, and no. of attempts
        int wins = 0;
        int loss = 0;
        int attempts = 0;
        int tie = 0;

        System.out.println("Welcome to Stone, Paper & Scissors");

        try {
            while (true) {
                //take user input for rock, paper and scissor.
                System.out.println("1. Stone");
                System.out.println("2. Paper");
                System.out.println("3. Scissors");
                System.out.print("Enter your choice: ");

                // Check if input is an integer before reading it
                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number between 1 and 3.");
                    sc.next();  // Clear invalid input
                    continue;   // Restart the loop
                }

                int userChoice = sc.nextInt();

                //check if user choice is valid
                if (userChoice < 1 || userChoice > 3) {
                    System.out.println("Please enter a valid option. Please enter 1, 2 or 3.");
                    continue;
                }

                //declare variable for the computerChoice
                int computerChoice = rand.nextInt(3) + 1;

                //show the options chosen
                System.out.println("Computer chose: " + getChoice(computerChoice));
                System.out.println("You Chose: " + getChoice(userChoice));

                //make tie, win & lose conditions
                if (userChoice == computerChoice) {
                    //tie condition
                    System.out.println("It's a tie.");
                    tie++;
                    attempts++;
                } else if ((userChoice == 1 && computerChoice == 3) || (userChoice == 2 && computerChoice == 1) || (userChoice == 3 && computerChoice == 2)) {
                    //win condition
                    System.out.println("🎉 You win! ");
                    wins++;
                    attempts++;
                } else {
                    //lose condition
                    System.out.println("😢You lose.");
                    loss++;
                    attempts++;
                }

                //ask if the user wants to continue
                System.out.print("Do you want to continue? ");
                String cont = sc.next();

                //if user discontinues
                if (cont.equalsIgnoreCase("no")) {
                    //print the total wins, loss, ties and attempts
                    System.out.println("Total  times played: " + attempts);
                    System.out.println("Wins: " + wins + " | Losses: " + loss + " | Ties: " + tie);
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    //helper function to convert 1,2 & 3 to Rock, Paper & Scissors
    private static String getChoice(int choice) {
        return switch (choice) {
            case 1 -> "Stone";
            case 2 -> "Paper";
            case 3 -> "Scissors";
            default -> "Invalid Choice";
        };

    }
}
