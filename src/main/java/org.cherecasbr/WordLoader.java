package org.cherecasbr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class WordLoader {
    private static final Logger log = LoggerFactory.getLogger(WordLoader.class);

    public static HashSet<String> loadWords() {
        HashSet<String> words = new HashSet<>();
        try {
            String absolutePath = "/home/ralf/Documents/projects/java/hangman/src/words.txt";
            BufferedReader reader = new BufferedReader(new FileReader(absolutePath));
            String line;
            while ((line = reader.readLine()) != null) words.add(line);
        } catch (IOException e) {
            log.error("Error loading words from file", e);
        }

        return words;
    }

    public static boolean isValidWord(HashSet<String> wordList, HashMap<Character, Byte> hand, String word) {
        boolean valid = false;
        for (String w : wordList)
            if (w.toLowerCase().equals(word)) {
                valid = true;
                break;
            }
        if (!valid) {
            System.out.print("Invalid word, please try again.\n\n");
            HangmanHandler.displayHand(hand);
            return false;
        }
        HandHandler.decrementHand(hand, word);

        return true;
    }
}
