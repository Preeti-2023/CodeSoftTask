package com.Task1;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        final int maxRange = 100;
        int numberOfAttempts = 10;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
    
        System.out.println("You have " + numberOfAttempts + " attempts to guess it.");

        boolean start = true;

        while (start) {
            int targetNumber = random.nextInt(maxRange)+1;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            while (attempts < numberOfAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the correct number: " + targetNumber);
                    hasGuessedCorrectly = true;
                    score++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! You have " + (numberOfAttempts - attempts) + " attempts remaining.");
                } else {
                    System.out.println("Too high! You have " + (numberOfAttempts - attempts) + " attempts remaining.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainChoice = scanner.next().toLowerCase();
            start = playAgainChoice.equals("yes");
        }

        System.out.println("Thanks for playing! Your total score is: " + score);
        scanner.close();



    }
}
