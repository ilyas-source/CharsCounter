package ua.com.foxminded.charscounter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class CharCounterTest {

	Map<String, Long> expected = new HashMap<>();

	@Test
	void givenQwertty_onGetCharCount_thenGetHashMap() {
		expected.put("Q", 1L);
		expected.put("w", 1L);
		expected.put("e", 1L);
		expected.put("r", 1L);
		expected.put("t", 2L);
		expected.put("y", 1L);

		CharCounter cachingCharCount = new CachedDecorator(new UniqueCharCounter());

		Map<String, Long> actual = cachingCharCount.charCounter("Qwertty");

		assertEquals(actual, expected);
	}

	@Test
	void givenMMMMMMM_onGetCharCount_thenGetHashMap() {
		expected.put("M", 1L);

		CharCounter cachingCharCount = new CachedDecorator(new UniqueCharCounter());

		Map<String, Long> actual = cachingCharCount.charCounter("M");

		assertEquals(actual, expected);
	}

	@Test
	void givenSpaces_onGetCharCount_thenGetHashMap() {
		expected.put(" ", 5L);

		CharCounter cachingCharCount = new CachedDecorator(new UniqueCharCounter());

		Map<String, Long> actual = cachingCharCount.charCounter("     ");

		assertEquals(actual, expected);
	}
}
