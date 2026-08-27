import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");
        System.out.print("Enter a word to guess: ");

        String wordToGuess = scanner.nextLine().toLowerCase();

        List<Character> guessedLetters = new ArrayList<>();

        int attemptsLeft = 6;

        while (attemptsLeft > 0) {


            boolean allLettersGuessed = true;

            System.out.print("Word: ");

            for (int i = 0; i < wordToGuess.length(); i++) {

                char currentLetter = wordToGuess.charAt(i);

                if (guessedLetters.contains(currentLetter)) {
                    System.out.print(currentLetter + " ");
                } else {
                    System.out.print("_ ");
                    allLettersGuessed = false;
                }
            }

            System.out.println();


            if (allLettersGuessed) {
                System.out.println("You won!");
                System.out.println("The word was: " + wordToGuess);
                break;
            }

            System.out.println("Attempts left: " + attemptsLeft);

            System.out.print("Guess a letter: ");
            char guess = scanner.nextLine().toLowerCase().charAt(0);


            if (guessedLetters.contains(guess)) {
                System.out.println("You already guessed that letter.");
                continue;
            }

            guessedLetters.add(guess);


            if (wordToGuess.contains(String.valueOf(guess))) {
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong!");
                attemptsLeft--;
            }

            System.out.println();
        }


        if (attemptsLeft == 0) {
            System.out.println("Game over!");
            System.out.println("The word was: " + wordToGuess);
        }

        scanner.close();
    }
}