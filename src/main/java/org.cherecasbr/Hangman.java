package org.cherecasbr;

public class Hangman {
    static void startGame() {
        HangmanHandler.displayGameMenu();
        char player_choose = UserInputHandler.getUserInput_Char();
        UserInputHandler.handleUserInput(player_choose);
    }
}