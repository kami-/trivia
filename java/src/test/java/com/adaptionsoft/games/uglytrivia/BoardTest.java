package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;

    @BeforeEach
    void setup() {
        board = new Board();
    }

    @DisplayName("When field is 0 should return POP")
    @Test
    void pop() {
        assertEquals(board.getCategoryForField(0), Category.POP);
    }

    @DisplayName("When field is 1 should return SCIENCE")
    @Test
    void science() {
        assertEquals(board.getCategoryForField(1), Category.SCIENCE);
    }

    @DisplayName("When field is 2 should return SPORTS")
    @Test
    void sports() {
        assertEquals(board.getCategoryForField(2), Category.SPORTS);
    }

    @DisplayName("When field is 3 should return ROCK")
    @Test
    void rock() {
        assertEquals(board.getCategoryForField(3), Category.ROCK);
    }
}