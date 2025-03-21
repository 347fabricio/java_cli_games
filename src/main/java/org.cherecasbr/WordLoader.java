package org.cherecasbr;

import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.HashSet;

public class WordLoader {
    public static HashSet<String> loadWords() throws Exception {
        HashSet<String> words = new HashSet<>();
        try {
            InputStream inputStream = WordLoader.class.getClassLoader().getResourceAsStream("words.txt");

            if (inputStream == null) {
                throw new Exception("[ERROR] words.txt file not found.");
            }

            String absolutePath = "/home/ralf/Documents/github/java_cli_games/src/words.txt";
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) words.add(line);
        } catch (Exception e) {
            throw new Exception("[ERROR] words.txt file not found.");
        }

        return words;
    }

    static void searchFor(HashSet<String> wordList, String word) {
        for (String w : wordList) if (w.toLowerCase().equals(word)) return;
    }

    static void updateHand(HashMap<Character, Byte> hand, String word) {
        char[] wordArr = word.toLowerCase().toCharArray();
        for (Character letter : wordArr) {
            if (hand.get(letter) != null || hand.get(letter) < 1) {
                HandHandler.decrementHand(hand, letter, hand.get(letter));
            }
        }
    }

    static boolean isWordInHand(HashMap<Character, Byte> hand, String word) {
        char[] wordArr = word.toLowerCase().toCharArray();
        for (Character letter : wordArr) if (hand.get(letter) == null || hand.get(letter) < 1) return false;

        return true;
    }

    public static boolean isValidWord(HashSet<String> wordList, HashMap<Character, Byte> hand, String word) {
        boolean valid = isWordInHand(hand, word);
        if (valid) {
            searchFor(wordList, word);
            updateHand(hand, word);
            return true;
        } else {
            System.out.print("Invalid word, please try again.\n\n");
            HangmanHandler.displayHand(hand);
            return false;
        }
    }

    public static void clearConsole() {
        for (int i = 0; i < 10; i++) System.out.println();
    }
}
