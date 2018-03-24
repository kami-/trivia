
package com.adaptionsoft.games.trivia.runner;

import com.adaptionsoft.games.uglytrivia.DefaultRandom;
import com.adaptionsoft.games.uglytrivia.SystemOutPrinter;


public class Main {

	public static void main(String[] args) {
		long seed = Long.valueOf(args[0]);
		GameRunner gameRunner = new GameRunner(new SystemOutPrinter(), new DefaultRandom(seed), timer);
		gameRunner.run();
	}
}
