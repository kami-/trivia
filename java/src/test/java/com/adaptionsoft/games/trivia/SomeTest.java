package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.trivia.runner.GameRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

class SomeTest {
	private static final int FIXURE_COUNT = 999;
	private ByteArrayOutputStream stream;

	@BeforeEach
	void setup() throws IOException {
		stream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(new BufferedOutputStream(stream), true));
	}

	private String readFixture(int index) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get("src/test/java/resources/fixtures/" + index));
		return new String(encoded, StandardCharsets.UTF_8);
	}

	@RepeatedTest(FIXURE_COUNT)
	void testAllFixtures(RepetitionInfo repetitionInfo) throws Exception {
		int i = repetitionInfo.getCurrentRepetition();

		GameRunner.main(new String[]{String.valueOf(i)});
		String fixture = readFixture(i);

		assertEquals("Fixture index: " + i, fixture, stream.toString());
	}
}
