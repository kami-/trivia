package com.adaptionsoft.games.uglytrivia;

public class Board {
    public static final int NUMBER_OF_FIELDS = 12;

    public Category getCategoryForField(int field) {
        int modulo = field % 4;
        if (modulo == 0) return Category.POP;
        if (modulo == 1) return Category.SCIENCE;
        if (modulo == 2) return Category.SPORTS;
        return Category.ROCK;
    }
}
