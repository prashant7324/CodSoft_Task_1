import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int round = 0;
        int totalAttempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            round++;
            int targetNumber = random.nextInt(100) + 1; // Random number between 1 and 100
            int guess;
            int attempts = 0;

            System.out.println("\nRound " + round + ":");
            System.out.println("I have selected a number between 1 and 100. Try to guess it!");

            while (true) {
                System.out.print("Enter your guess: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number!");
                    scanner.next(); // clear invalid input
                    System.out.print("Enter your guess: ");
                }

                guess = scanner.nextInt();
                attempts++;

                if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    break;
                }
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine(); // Consume newline
            String response = scanner.nextLine().trim().toLowerCase();

            if (!response.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nGame Over. You played " + round + " round(s) with a total of " + totalAttempts + " attempts.");
        System.out.println("Average attempts per round: " + (double) totalAttempts / round);
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
