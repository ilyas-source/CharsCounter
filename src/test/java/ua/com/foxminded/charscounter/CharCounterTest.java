package ua.com.foxminded.charscounter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import ua.com.foxminded.charscounter.CharCount;

class CharCounterTest {

	CharCount charCounter = new CharCount();

	@Test
	void givenQwertty_onGetCharCount_thenGetHashMap() {

		Map<String, Long> expected = new HashMap<>();
		expected.put("Q", (long) 1);
		expected.put("w", (long) 1);
		expected.put("e", (long) 1);
		expected.put("r", (long) 1);
		expected.put("t", (long) 2);
		expected.put("y", (long) 1);

		Map<String, Long> actual = charCounter.charCount("Qwertty");

		assertEquals(actual, expected);
	}

	@Test
	void givenMMMMMMM_onGetCharCount_thenGetHashMap() {

		Map<String, Long> expected = new HashMap<>();
		expected.put("M", (long) 7);

		Map<String, Long> actual = charCounter.charCount("MMMMMMM");

		assertEquals(actual, expected);
	}

	@Test
	void givenSpaces_onGetCharCount_thenGetHashMap() {

		Map<String, Long> expected = new HashMap<>();
		expected.put(" ", (long) 6);

		Map<String, Long> actual = charCounter.charCount("      ");

		assertEquals(actual, expected);
	}
}
