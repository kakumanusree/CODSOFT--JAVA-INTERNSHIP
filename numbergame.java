import java.util.Random;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int score = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        boolean playAgain = true;
        while (playAgain) {
            rounds++;
            int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;
            
            System.out.println("\nRound " + rounds + ": I have selected a number between " + lowerBound + " and " + upperBound + ".");
            
            while (!hasGuessedCorrectly && attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ". Enter your guess: ");
                int playerGuess = scanner.nextInt();
                attempts++;
                
                if (playerGuess < secretNumber) {
                    System.out.println("Your guess is too low.");
                } else if (playerGuess > secretNumber) {
                    System.out.println("Your guess is too high.");
                } else {
                    hasGuessedCorrectly = true;
                    score += maxAttempts - attempts + 1;
                    System.out.println("Congratulations! You've guessed the number " + secretNumber + " in " + attempts + " attempts.");
                }
            }
            
            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + secretNumber + ".");
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next();
            playAgain = playAgainResponse.equalsIgnoreCase("yes");
        }
        
        System.out.println("Game over! Your total score is: " + score);
        scanner.close();
    }
}

