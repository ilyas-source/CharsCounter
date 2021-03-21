package ua.com.foxminded.charscounter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import ua.com.foxminded.charscounter.CharCounter;

class CharCounterTest {

	CharCounter charCounter = new CharCounter();

	@Test
	void givenQwertty_onGetCharCount_thenGetHashMap() {

		Map<Character, Long> expected = new HashMap<>();
		expected.put('Q', (long) 1);
		expected.put('w', (long) 1);
		expected.put('e', (long) 1);
		expected.put('r', (long) 1);
		expected.put('t', (long) 2);
		expected.put('y', (long) 1);

		Map<Character, Long> actual = charCounter.getCharCount("Qwertty");

		assertEquals(actual, expected);
	}

	@Test
	void givenM_onGetCharCount_thenGetHashMap() {

		Map<Character, Long> expected = new HashMap<>();
		expected.put('M', (long) 1);

		Map<Character, Long> actual = charCounter.getCharCount("M");

		assertEquals(actual, expected);
	}
}
