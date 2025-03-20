package org.cherecasbr;

import java.util.HashMap;

public class ScoreCalculator {
    public static int sumScore(String word) {
        HashMap<Character, Byte> scrabble = ScrabbleLetters.getScrabbleLetterValues();
        int score = 0;

        for (int i = 0; i < word.length(); i++) {
            for (char key : scrabble.keySet()) {
                if (key == word.charAt(i)) score += scrabble.get(key);
            }
        }

        if (word.length() == 7) score += 50;
        System.out.printf("'%s' earned %d points. Total: %d\n\n", word, score, score);

        return score;
    }
}
