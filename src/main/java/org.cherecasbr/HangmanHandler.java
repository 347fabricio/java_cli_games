package org.cherecasbr;

import java.util.HashMap;

public class HangmanHandler {
    static void displayGameMenu() {
        System.out.print("Enter 'n' to deal a new hand, 'r' to replay the" + " last hand, or 'e' to end game: ");
    }

    static void displayHand(HashMap<Character, Byte> hand) {
        StringBuilder print = new StringBuilder();
        print.append("Current hand: ");
        for (Character letter : hand.keySet()) {
            byte length = hand.get(letter);
            if (length >= 1) {
                for (int i = 0; i < length; i++) {
                    print.append(letter);
                    print.append(" ");
                }
            }
        }
        System.out.println(print);
    }

    public static void exitGame(int score) {
        System.out.printf("\nGoodbye! Total score: %d points.\n", score);
        UserInputHandler.closeReader();
    }
}
