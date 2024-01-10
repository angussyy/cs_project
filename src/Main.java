/*
Name: Angus Wong
Teacher: Ms Nahar
Date: 9th of January 2024
Project: Hangman
Collaborators:None
Description:
*/
/*project/*
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String[] words = {"APPLE", "CHAIR", "WATCH", "FLOOR", "BOOK", "COMPUTER", "FOOTBALL", "FUN", "SIGHT", "BUTTON"};
        boolean playA = false;
        boolean playAgain = true;
        while (playAgain) {
            String secretWord = getRandomWord(convertFile("HangmanWordsList 2.txt"));
            //System.out.println(secretWord); //for bug testing purposes
            int guesses = 7;
            System.out.println("Hi! Get ready to play some hangman!");
            System.out.println("Enter any letter to get started.");
            boolean win = false;
            String display = "";
            for (int i = 0; i < secretWord.length(); i++) { //setting display as secretWord but in -s
                display = display + "-";
            }
            while (!win) {
                String updated = "";
                Scanner scanner = new Scanner(System.in);
                System.out.println("Your secret word looks like this: ");
                System.out.print(display);
                String input = (scanner.nextLine()).toUpperCase();
                if (input.length() == 1) {
                    if (secretWord.contains(input)) {
                        for (int i = 0; i < secretWord.length(); i++) {
                            if ((secretWord.charAt(i) + "").equals(input)) {
                                updated = updated + secretWord.charAt(i);
                            } else if (!(display.charAt(i) == '-')) {
                                updated = updated + display.charAt(i);
                            } else {
                                updated = updated + '-';
                            }
                        }
                        display = updated;
                        System.out.println("Your guess is correct. ");
                        hangman(guesses);
                        if (display.equals(secretWord)) {
                            System.out.println("You have successfully guessed the secret word. ");
                            System.out.println("The secret word was " + secretWord + ". ");
                            System.out.println("Amazing job!");
                            System.out.println("Do you wish to play again? (y/n)");
                            boolean inputGiven = false;
                            while (!inputGiven) {
                                input = (scanner.nextLine()).toUpperCase();
                                if (input.length() == 1) {
                                    if (input.equals("Y")) {
                                        playA = true;
                                        break;
                                    } else {
                                        System.out.println("thank you for playing!");
                                        playA = false;



                                    }
                                } else {
                                    System.out.println("give an actual input. ");
                                }
                            }
                            if (playA) {
                                win = true;
                            }
                            else if (!playA) {
                                System.exit(0); //quit
                            }
                        }
                    } else {
                        System.out.println("There are no " + input.toUpperCase() + "'s in this secretWord. ");
                        guesses = guesses - 1;
                        System.out.println("You have " + guesses + " guesses left. ");
                        hangman(guesses);
                        if (guesses == 0) {
                            System.out.println("You have failed to guess the secret word. Better luck next time. ");
                            System.out.println("You have guessed the secret word. ");
                            System.out.println("The secret word was " + secretWord + ". ");
                            System.out.println("Amazing job!");
                            System.out.println("Do you wish to play again? (y/n)");
                            boolean inputGiven = false;
                            while (!inputGiven) {
                                input = (scanner.nextLine()).toUpperCase();
                                if (input.length() == 1) {
                                    if (input.equals("Y")) {
                                        playA = true;
                                        break;
                                    } else {
                                        System.out.println("thank you for playing!");
                                        playA = false;
                                    }
                                } else {
                                    System.out.println("give an actual input. ");
                                }
                            }
                            if (playA) {
                                win = true;
                            }
                            else if (!playA) {
                                //quit
                            }
                        }
                    }
                }
                else {
                    System.out.println("invalid input. ");
                }
            }
        }
    }
    public static String getRandomWord(String[] a) {

        Random rand = new Random();
        int upperbound = a.length;
        return a[rand.nextInt(upperbound)];


    }

    public static void hangman(int a) { //todo
        if (a==7) {
            System.out.println("   +---+");
            System.out.println("       ||");
            System.out.println("       ||");
            System.out.println("       ||");
            System.out.println("       ||");
            System.out.println("=========");
        } else if (a == 6) {
                System.out.println("   +---+");
                System.out.println("   |   ||");
                System.out.println("       ||");
                System.out.println("       ||");
                System.out.println("       ||");
                System.out.println("=========");
            } else if (a == 5) {
                System.out.println("   +---+");
                System.out.println("   |   ||");
                System.out.println("   O   ||");
                System.out.println("       ||");
                System.out.println("       ||");
                System.out.println("=========");
            } else if (a == 4) {
                System.out.println("   +---+");
                System.out.println("   |   ||");
                System.out.println("   O   ||");
                System.out.println("   |   ||");
                System.out.println("       ||");
                System.out.println("=========");
            } else if (a == 3) {
                System.out.println("   +---+");
                System.out.println("   |   ||");
                System.out.println("   O   ||");
                System.out.println("  /|   ||");
                System.out.println("       ||");
                System.out.println("=========");
            } else if (a == 2) {
                System.out.println("   +---+");
                System.out.println("   |   ||");
                System.out.println("   O   ||");
                System.out.println("  /|\\  ||");
                System.out.println("       ||");
                System.out.println("=========");
            } else if (a == 1) {
                System.out.println("   +---+");
                System.out.println("   |   ||");
                System.out.println("   O   ||");
                System.out.println("  /|\\  ||");
                System.out.println("  /    ||");
                System.out.println("=========");
            } else if (a == 0) {
                System.out.println("   +---+");
                System.out.println("   |   ||");
                System.out.println("   O   ||");
                System.out.println("  /|\\  ||");
                System.out.println("  / \\  ||");
                System.out.println("=========");
            }
        }


    public static String[] convertFile(String input) throws FileNotFoundException {//
        File file = new File(input);
        Scanner scanner = new Scanner(file);
        int numberOfLines = countLinesFile(input);
        String[] array = new String[numberOfLines];
        int index = 0;
        while (scanner.hasNextLine()) {
            array[index++] = scanner.nextLine();
        }
        scanner.close();
        return array;

    }

    public static int countLinesFile(String input) throws FileNotFoundException {//
        File file = new File(input);
        Scanner scanner = new Scanner(file);
        int lines = 0;
        while (scanner.hasNextLine()) {
            lines++;
            scanner.nextLine();
        }
        scanner.close();
        return lines;
    }



}
}
 */