package by.lravenclaw.quizer.tools;

import java.util.Random;

public class RandomWrapper {
    public static int getRandomIndex(int size) {
        Random rand = new Random();
        return rand.nextInt(size);
    }
}
