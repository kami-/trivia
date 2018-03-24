
package com.adaptionsoft.games.trivia.runner;

import com.adaptionsoft.games.uglytrivia.DefaultRandom;
import com.adaptionsoft.games.uglytrivia.GameState;
import com.adaptionsoft.games.uglytrivia.SystemOutPrinter;
import com.adaptionsoft.games.uglytrivia.InfiniteTimer;

import java.util.Arrays;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		long seed = Long.valueOf(args[0]);
		List<String> players = Arrays.asList("Chet", "Pat", "Sue");
		GameState gameState = new GameState(players);
		GameRunner gameRunner = new GameRunner(new SystemOutPrinter(), new DefaultRandom(seed), new InfiniteTimer(), gameState, players);
		gameRunner.run();
	}
}
