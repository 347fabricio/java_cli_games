package org.cherecasbr;

import java.util.HashMap;

public class HandHandler {
    public static HashMap<Character, Byte> dealHand() {
        byte totalLetters = 7 / 3;
        HashMap<Character, Byte> hand = new HashMap<>();
        byte vowelsLength = (byte) LetterCategories.getVowels().length();
        byte consonantLength = (byte) LetterCategories.getConsonants().length();
        addVowels(hand, totalLetters, vowelsLength);
        addConsonants(hand, totalLetters, consonantLength);

        return hand;
    }

    public static boolean getHandSize(HashMap<Character, Byte> hand) {
        byte hand_size = 0;
        for (Character letter : hand.keySet()) hand_size += hand.get(letter);

        return hand_size <= 1;
    }

    static void decrementHand(HashMap<Character, Byte> hand, String word) {
        char[] wArr = word.toLowerCase().toCharArray();
        for (char letter : wArr) {
            Byte length = hand.get(letter);
            if (length != null) {
                hand.put(letter, (byte) (length - 1));
            }
        }
    }

    static void addVowels(HashMap<Character, Byte> hand, byte totalLetters, byte categoryLength) {
        for (int i = 0; i < totalLetters; i++) {
            char letter = LetterCategories.getVowels().charAt(RandomUtils.random(categoryLength));

            hand.compute(letter, (x, length) -> length != null ? (byte) (length + 1) : (byte) 1);
        }
    }

    static void addConsonants(HashMap<Character, Byte> hand, byte totalLetters, byte categoryLength) {
        for (int i = totalLetters; i < 7; i++) {
            char letter = LetterCategories.getConsonants().charAt(RandomUtils.random(categoryLength));
            Byte length = hand.get(letter);
            if (length != null) {
                hand.put(letter, (byte) (length + 1));
            } else {
                hand.put(letter, (byte) 1);
            }
        }
    }
}
