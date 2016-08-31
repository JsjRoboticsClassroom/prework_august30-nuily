package nyc.c4q;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Hangman hangman = new Hangman();


        // Here is an if statement that checks if yes was entered
        boolean notDone = true;
        while (notDone) {
            while (hangman.getMisses() < 5) {
                hangman.printCurrentWord();
                hangman.promptPlayer("Enter a letter: ");
                hangman.readLetter();
                hangman.checkLetter();
                if (hangman.guessedSuccessfully()) {
                    break;
                }
                System.out.println(Drawing.get(hangman.getMisses()));
                System.out.println("Misses -> " + hangman.getMisses());
            }

            if (hangman.guessedSuccessfully()) {
                System.out.println("Success");
            } else {
                System.out.println("The answer was " + hangman.getSecretWord());
            }
            System.out.println("Do you want to play a game?");

            boolean isNotValidInput = false;

            do {
                Scanner newGame = new Scanner(System.in);

                String userAnswer = newGame.next();
                userAnswer = userAnswer.toLowerCase();

                if (userAnswer.equals("yes") || userAnswer.indexOf('y') == 0) {

                    isNotValidInput = false;

                    hangman.resetGame();

                    notDone = true;

                } else if (userAnswer.equals("no") || userAnswer.indexOf('n') == 0) {

                    isNotValidInput = false;

                    notDone = false;

                } else {
                    System.out.println("Try again");
                    isNotValidInput = true;
                }
            } while (isNotValidInput);

        }
    }
}
