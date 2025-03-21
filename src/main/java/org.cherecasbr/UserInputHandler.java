package org.cherecasbr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class UserInputHandler {
    private static final Logger log = LoggerFactory.getLogger(UserInputHandler.class);
    private static final BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));

    public static void getUserInput_Char(String input) {
        if (input == null || input.length() != 1) throw new IllegalArgumentException("Invalid input.");
    }

    public static char getUserInput_Char() {
        String input = "";
        try {
            input = bufferReader.readLine();
            if (input == null || input.length() > 1) {
                System.out.println("Input MUST be a single character.\n");
                Hangman.startGame();
                return 0;
            }
        } catch (IOException e) {
            log.error("[ERROR]", e);
            System.out.println("[ERROR] Something wrong has occurred.");
        }
        System.out.println();

        return input.charAt(0);
    }

    public static String getUserInput_String() {
        String input = "";
        System.out.print("Enter a word, or '.' to indicate that you are finished: ");
        try {
            input = bufferReader.readLine();
            if (input == null || input.isEmpty()) throw new IllegalArgumentException("Enter a valid input.");
        } catch (IOException e) {
            log.error("[ERROR]", e);
            System.out.println("[ERROR] Something wrong has occurred.");
        }

        return input;
    }

    public static void handleUserInput(char input) {
        if (input != 'n' && input != 'r' && input != 'e') {
            System.out.println("[ERROR] Input doesn't match.\n");
            Hangman.startGame();
            return;
        }
        switch (input) {
            case 'n': {
                HandHandler.hand = HandHandler.dealHand();
                HangmanHandler.displayHand(HandHandler.hand);
                UserInputHandler.handleUserWord(HandHandler.hand);
                break;
            }
            case 'r': {
                if (PreviousHandHandler.previousHand != null) {
                    HangmanHandler.displayHand(PreviousHandHandler.previousHand);
                    UserInputHandler.handleUserWord(PreviousHandHandler.previousHand);
                } else {
                    System.out.println("[ERROR] You must play at least once.\n");
                    Hangman.startGame();
                    return;
                }
                break;
            }
            case 'e': {
                UserInputHandler.closeReader();
            }
        }
    }

    static void handleUserWord(HashMap<Character, Byte> hand) {
        HashSet<String> wordList;
        try {
            wordList = WordLoader.loadWords();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        while (true) {
            if (HandHandler.getHandSize(hand)) return;
            try {
                String player_choose = UserInputHandler.getUserInput_String();
                if (player_choose.equals(".")) {
                    HangmanHandler.exitGame();
                    WordLoader.clearConsole();
                    Hangman.startGame();
                    return;
                }
                boolean valid = WordLoader.isValidWord(wordList, hand, player_choose);
                if (valid) {
                    ScoreCalculator.sumScore(player_choose);
                    if (HandHandler.getHandSize(hand)) return;
                    HangmanHandler.displayHand(hand);
                }
            } catch (IllegalArgumentException e) {
                System.err.println("[INPUT ERROR]" + e.getMessage());
                return;
            } catch (RuntimeException e) {
                System.err.println("[UNEXPECTED ERROR]: " + e.getMessage());
                return;
            }
        }
    }

    public static void closeReader() {
        try {
            bufferReader.close();
        } catch (IOException e) {
            log.error("[ERROR] closeReader", e);
            System.out.println("[ERROR] Something wrong has occurred.");
        }
    }
}
