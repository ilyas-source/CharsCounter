package ua.com.foxminded.charscounter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class CachedCharCounterTest {

	CachedCharCounter cachedCharCounter = new CachedCharCounter(new UniqueCharCounter());

	@Test
	void givenQwertty_onCachedCharCount_thenGetHashMap() {
		Map<Character, Long> expected = new HashMap<>();
		expected.put('Q', 1L);
		expected.put('w', 1L);
		expected.put('e', 1L);
		expected.put('r', 1L);
		expected.put('t', 2L);
		expected.put('y', 1L);

		Map<Character, Long> actual = cachedCharCounter.countChars("Qwertty");

		assertEquals(expected, actual);
	}

	@Test
	void givenMMMMMMM_onCachedCharCount_thenGetHashMap() {
		Map<Character, Long> expected = new HashMap<>();
		expected.put('M', 1L);

		Map<Character, Long> actual = cachedCharCounter.countChars("M");

		assertEquals(expected, actual);
	}

	@Test
	void givenSpaces_onCachedCharCount_thenGetHashMap() {
		Map<Character, Long> expected = new HashMap<>();
		expected.put(' ', 5L);

		Map<Character, Long> actual = cachedCharCounter.countChars("     ");

		assertEquals(expected, actual);
	}

}
