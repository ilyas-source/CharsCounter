package ua.com.foxminded.charscounter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class CharCounterTest {

	Map<String, Long> expected = new HashMap<>();

	@Test
	void givenQwertty_onGetCharCount_thenGetHashMap() {
		expected.put("Q", (long) 1);
		expected.put("w", (long) 1);
		expected.put("e", (long) 1);
		expected.put("r", (long) 1);
		expected.put("t", (long) 2);
		expected.put("y", (long) 1);

		CharCounter cachingCharCount = new CachedDecorator(new UniqueCharacterCounter());

		Map<String, Long> actual = cachingCharCount.charCount("Qwertty");

		assertEquals(actual, expected);
	}

	@Test
	void givenMMMMMMM_onGetCharCount_thenGetHashMap() {
		expected.put("M", (long) 1);

		CharCounter cachingCharCount = new CachedDecorator(new UniqueCharacterCounter());

		Map<String, Long> actual = cachingCharCount.charCount("M");

		assertEquals(actual, expected);
	}

	@Test
	void givenSpaces_onGetCharCount_thenGetHashMap() {
		expected.put(" ", (long) 5);

		CharCounter cachingCharCount = new CachedDecorator(new UniqueCharacterCounter());

		Map<String, Long> actual = cachingCharCount.charCount("     ");

		assertEquals(actual, expected);
	}
}
