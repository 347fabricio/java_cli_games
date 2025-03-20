package org.cherecasbr;

public class LetterCategories {
    private LetterCategories() {
    }

    private static final String vowels = "aeiou";
    private static final String consonants = "bcdfghjklmnpqrstvwxyz";

    public static String getVowels() {
        return vowels;
    }

    public static String getConsonants() {
        return consonants;
    }
}



