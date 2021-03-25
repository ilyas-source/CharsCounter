package ua.com.foxminded.charscounter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class UniqueCharCounterTest {

	UniqueCharCounter uniqueCharCounter = new UniqueCharCounter();

	@Test
	void givenQwertty_onGetCharCount_thenGetHashMap() {
		Map<String, Long> expected = new HashMap<>();
		expected.put("Q", 1L);
		expected.put("w", 1L);
		expected.put("e", 1L);
		expected.put("r", 1L);
		expected.put("t", 2L);
		expected.put("y", 1L);

		CharCounter cachingCharCount = new CachedCharCounter(uniqueCharCounter);

		Map<String, Long> actual = cachingCharCount.charCounter("Qwertty");

		assertEquals(actual, expected);
	}

	@Test
	void givenMMMMMMM_onGetCharCount_thenGetHashMap() {
		Map<String, Long> expected = new HashMap<>();
		expected.put("M", 1L);

		CharCounter cachingCharCount = new CachedCharCounter(uniqueCharCounter);

		Map<String, Long> actual = cachingCharCount.charCounter("M");

		assertEquals(actual, expected);
	}

	@Test
	void givenSpaces_onGetCharCount_thenGetHashMap() {
		Map<String, Long> expected = new HashMap<>();
		expected.put(" ", 5L);

		CharCounter cachingCharCount = new CachedCharCounter(uniqueCharCounter);

		Map<String, Long> actual = cachingCharCount.charCounter("     ");

		assertEquals(actual, expected);
	}
}
