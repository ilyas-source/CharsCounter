package ua.com.foxminded.charscounter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class CachedCharCounterTest {

	UniqueCharCounter uniqueCharCounter = mock(UniqueCharCounter.class);
	CachedCharCounter cachedCharCounter = new CachedCharCounter(uniqueCharCounter);

	@Test
	void givenQwertty_onCachedCharCount_thenGetHashMap() {
		Map<Character, Long> expected = new HashMap<>();
		expected.put('Q', 1L);
		expected.put('w', 1L);
		expected.put('e', 1L);
		expected.put('r', 1L);
		expected.put('t', 2L);
		expected.put('y', 1L);

		when(uniqueCharCounter.countChars("Qwertty")).thenReturn(expected);

		Map<Character, Long> actual = cachedCharCounter.countChars("Qwertty");

		assertEquals(expected, actual);
	}

	@Test
	void givenMMMMMMM_onCachedCharCount_thenGetHashMap() {
		Map<Character, Long> expected = new HashMap<>();
		expected.put('M', 7L);

		when(uniqueCharCounter.countChars("MMMMMMM")).thenReturn(expected);

		Map<Character, Long> actual = cachedCharCounter.countChars("MMMMMMM");

		assertEquals(expected, actual);
	}

	@Test
	void givenSpaces_onCachedCharCount_thenGetHashMap() {
		Map<Character, Long> expected = new HashMap<>();
		expected.put(' ', 5L);

		when(uniqueCharCounter.countChars("     ")).thenReturn(expected);

		Map<Character, Long> actual = cachedCharCounter.countChars("     ");

		assertEquals(expected, actual);
	}

	@Test
	void givenWWWwww_onCachedCharCount_thenGetHashMap() {
		Map<Character, Long> expected = new HashMap<>();
		expected.put('W', 3L);
		expected.put('w', 3L);

		when(uniqueCharCounter.countChars("WWWwww")).thenReturn(expected);

		Map<Character, Long> actual = cachedCharCounter.countChars("WWWwww");

		assertEquals(expected, actual);
	}

	@Test
	void givenEmptyString_onCachedCharCount_thenGetEmptyHashMap() {
		Map<Character, Long> expected = new HashMap<>();

		Map<Character, Long> actual = cachedCharCounter.countChars("");

		assertEquals(expected, actual);
	}

}
