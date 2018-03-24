package com.adaptionsoft.games.uglytrivia;

public enum Category {
    POP("Pop"),
    SCIENCE("Science"),
    SPORTS("Sports"),
    ROCK("Rock");

    private final String literal;

    Category(String literal) {
        this.literal = literal;
    }

    @Override
    public String toString() {
        return literal;
    }
}
