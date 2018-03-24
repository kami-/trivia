package com.adaptionsoft.games.uglytrivia;

import java.util.Random;

public class DefaultRandom implements IRandom {
    private final Random random;

    public DefaultRandom(long seed) {
        this.random = new Random(seed);
    }

    @Override
    public int nextInt(int n) {
        return random.nextInt(n);
    }
}
