package org.cherecasbr;

import java.util.HashMap;

import java.util.HashMap;

public class ScrabbleLetters {
    private ScrabbleLetters() {
    }

    public static HashMap<Character, Byte> getScrabbleLetterValues() {
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        byte[] values = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};

        HashMap<Character, Byte> scrabble = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            scrabble.put(letters[i], values[i]);
        }

        return scrabble;
    }
}

