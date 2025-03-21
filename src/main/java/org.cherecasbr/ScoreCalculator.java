package org.cherecasbr;

import java.util.HashMap;

public class ScoreCalculator {
    public static void sumScore(String word) {
        HashMap<Character, Byte> scrabble = ScrabbleLetters.getScrabbleLetterValues();
        Score score = new Score();
        for (int i = 0; i < word.length(); i++) {
            for (char key : scrabble.keySet()) {
                if (key == word.charAt(i)) score.setScore(scrabble.get(key));
            }
        }

        if (word.length() == 5) Score.totalScore += 50;
        System.out.printf("'%s' earned %d points. Total points: %d\n\n", word, score.getScore(), Score.totalScore);
    }

    static void resetScore() {
        Score.totalScore = 0;
    }
}
