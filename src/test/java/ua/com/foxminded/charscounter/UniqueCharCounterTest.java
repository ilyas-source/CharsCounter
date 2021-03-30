package ua.com.foxminded.charscounter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class UniqueCharCounterTest {

	private UniqueCharCounter uniqueCharCounter = new UniqueCharCounter();

	@Test
	void givenQwertty_onUniqueCharCount_thenGetHashMap() {
		Map<Character, Long> expected = new HashMap<>();
		expected.put('Q', 1L);
		expected.put('w', 1L);
		expected.put('e', 1L);
		expected.put('r', 1L);
		expected.put('t', 2L);
		expected.put('y', 1L);

		Map<Character, Long> actual = uniqueCharCounter.countChars("Qwertty");

		assertEquals(expected, actual);
	}

	@Test
	void givenMMMMMMM_onUniqueCharCount_thenGetHashMap() {
		Map<Character, Long> expected = new HashMap<>();
		expected.put('M', 7L);

		Map<Character, Long> actual = uniqueCharCounter.countChars("MMMMMMM");

		assertEquals(expected, actual);
	}

	@Test
	void givenSpaces_onUniqueCharCount_thenGetHashMap() {
		Map<Character, Long> expected = new HashMap<>();
		expected.put(' ', 5L);

		Map<Character, Long> actual = uniqueCharCounter.countChars("     ");

		assertEquals(expected, actual);
	}

	@Test
	void givenWWWwww_onUniqueCharCount_thenGetHashMap() {
		Map<Character, Long> expected = new HashMap<>();
		expected.put('W', 3L);
		expected.put('w', 3L);

		Map<Character, Long> actual = uniqueCharCounter.countChars("WWWwww");

		assertEquals(expected, actual);
	}

	@Test
	void givenEmptyString_onUniqueCharCount_thenGetEmptyHashMap() {
		Map<Character, Long> expected = new HashMap<>();

		Map<Character, Long> actual = uniqueCharCounter.countChars("");

		assertEquals(expected, actual);
	}
}
