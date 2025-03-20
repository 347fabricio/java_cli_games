package org.cherecasbr;

import java.util.Random;

public class RandomUtils {
    private RandomUtils() {
    }

    static byte random(byte bound) {
        return (byte) new Random().nextInt(bound);
    }
}
