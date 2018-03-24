package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.trivia.runner.GameRunner;
import com.adaptionsoft.games.uglytrivia.DefaultRandom;
import com.adaptionsoft.games.uglytrivia.GameState;
import com.adaptionsoft.games.uglytrivia.IPrinter;
import com.adaptionsoft.games.uglytrivia.InfiniteTimer;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

class FixtureTest {
	private static final int FIXURE_COUNT = 999;

	private String readFixture(int index) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get("src/test/java/resources/fixtures/" + index));
		return new String(encoded, StandardCharsets.UTF_8);
	}

	@RepeatedTest(FIXURE_COUNT)
	void testAllFixtures(RepetitionInfo repetitionInfo) throws Exception {
		int i = repetitionInfo.getCurrentRepetition();

		IPrinter mockPrinter = new SystemOutPrinterMock();
		List<String> players = Arrays.asList("Chet", "Pat", "Sue");
		GameState gameState = new GameState(players);
		new GameRunner(mockPrinter, new DefaultRandom(i), new InfiniteTimer(), gameState, players).run();
		String fixture = readFixture(i);

		assertEquals("Fixture index: " + i, fixture, mockPrinter.toString());
	}
}
