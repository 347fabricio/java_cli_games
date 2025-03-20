import org.cherecasbr.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HangmanTest {
    @Test
    public void testUserInput_NullInput() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            UserInputHandler.getUserInput_Char(null);
        });
    }

    @Test
    public void testUserInput_TooManyChar() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            UserInputHandler.getUserInput_Char("foo");
        });
    }

    @Test
    public void testUserInput_EmptyInput() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            UserInputHandler.getUserInput_Char("");
        });
    }

//    @Test
//    public void testUserInput_WrongOption() {
//        var input = new uInput();
//        Assert.assertTrue(input.handleUserInput("n"));
//        Assert.assertTrue(input.handleUserInput("r"));
//        Assert.assertTrue(input.handleUserInput("e"));
//
//        Assert.assertFalse(input.handleUserInput("Z"));
//    }
}