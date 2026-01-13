import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int roundsWon = 0;

        System.out.println("🎯 Welcome to the Number Guessing Game!");
        System.out.println("You need to guess the number between 1 and 100.");
        System.out.println("You have 10 attempts per round.\n");

        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // 1 to 100
            int attemptsLeft = 10;
            boolean guessedCorrectly = false;

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess (" + attemptsLeft + " attempts left): ");
                int userGuess = scanner.nextInt();

                if (userGuess == numberToGuess) {
                    System.out.println("🎉 Congratulations! You guessed it right.");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("⬆️ Too low! Try again.");
                } else {
                    System.out.println("⬇️ Too high! Try again.");
                }
                attemptsLeft--;
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've used all attempts. The correct number was: " + numberToGuess);
            }

            System.out.println("Your score (rounds won): " + roundsWon);

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
            System.out.println();
        }

        System.out.println("Thanks for playing! Your total rounds won: " + roundsWon);
        scanner.close();
    }
}

