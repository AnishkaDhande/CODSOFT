import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        String playAgain;

        do {
            // Random number between 1 and 100
            int numToGuess = random.nextInt(100) + 1;
            int numOfAttempts = 0;
            int maxAttempts = 10;
            boolean GuessedCorrectly = false;

            System.out.println("Choose a number between 1 and 100 for guessing.");

            while (numOfAttempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                numOfAttempts++;

                if (userGuess == numToGuess) {
                    System.out.println("Congratulations! You've guessed the number correctly.");
                    GuessedCorrectly = true;

                    // Higher score for fewer attempts
                    totalScore += (maxAttempts - numOfAttempts + 1);
                    break;
                } else if (userGuess < numToGuess) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

                System.out.println("Attempts left: " + (maxAttempts - numOfAttempts));
            }

            if (!GuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + numToGuess);
            }

            System.out.println("Your score this round: " + totalScore);
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next();
        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing! Total score is: " + totalScore);
        scanner.close();
    }
}
