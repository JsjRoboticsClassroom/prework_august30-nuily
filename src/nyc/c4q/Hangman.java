package nyc.c4q;

import java.util.Scanner;


public class Hangman {
    private final SecretWord mSecretWord;
    private char mLastGuess;
    private int mMisses = 0;

    public Hangman(){
        mSecretWord = new SecretWord();
    }


    public int getMisses(){
        return mMisses;
    }

    public void resetGame() {
        mMisses = 0;
// reset secret word
// reset last guess
    }

    public void readLetter() {
        Scanner scanner = new Scanner(System.in);
        char input = scanner.next().charAt(0);
        mLastGuess = Character.toUpperCase(input);
    }

    public void promptPlayer(String string) {
        System.out.println(string);
    }

    public boolean checkLetter() {
        if (mSecretWord.isLetter(mLastGuess)) {
            // If letter is in word do something
            mSecretWord.set(mLastGuess);
            return true;
        } else {
            mMisses++;
            return false;
        }
    }

    public void printCurrentWord(){
        System.out.println(mSecretWord);
    }

    public String getSecretWord() {
        return mSecretWord.reveal();
    }

    public boolean guessedSuccessfully() {
        return mSecretWord.isGuessed();
    }
}