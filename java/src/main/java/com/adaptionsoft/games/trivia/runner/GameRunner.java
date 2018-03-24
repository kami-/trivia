package com.adaptionsoft.games.trivia.runner;

import com.adaptionsoft.games.uglytrivia.*;

import java.util.Arrays;
import java.util.List;

public class GameRunner {
    private final IPrinter printer;
    private final IRandom random;
    private final ITimer timer;
    private final GameState gameState;
    private final List<String> players;

    public GameRunner(IPrinter printer, IRandom random, ITimer timer, GameState gameState, List<String> players) {
        this.printer = printer;
        this.random = random;
        this.timer = timer;
        this.gameState = gameState;
        this.players = players;
    }

    public void run() {
        boolean shouldContinue;

        Game aGame = new Game(printer, gameState);

        players.forEach(aGame::add);


        do {

            aGame.roll(random.nextInt(5) + 1);

            if (random.nextInt(9) == 7) {
                shouldContinue = aGame.wrongAnswer();
            } else {
                shouldContinue = aGame.wasCorrectlyAnswered();
            }



        } while (shouldContinue && timer.getElapsedMinutes() < 30);
    }
}
