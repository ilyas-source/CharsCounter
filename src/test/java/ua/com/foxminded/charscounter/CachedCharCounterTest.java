package ua.com.foxminded.charscounter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CachedCharCounterTest {

	@Mock
	CharCounter charCounter;

	@InjectMocks
	CachedCharCounter cachedCharCounter = new CachedCharCounter(charCounter);

	@Test
	void givenQwertty_onCachedCharCount_thenGetHashMap() {
		Map<Character, Long> expected = new LinkedHashMap<>();
		expected.put('Q', 1L);
		expected.put('w', 1L);
		expected.put('e', 1L);
		expected.put('r', 1L);
		expected.put('t', 2L);
		expected.put('y', 1L);

		when(charCounter.countChars("Qwertty")).thenReturn(expected);

		assertEquals(expected, cachedCharCounter.countChars("Qwertty"));
		assertEquals(expected, cachedCharCounter.countChars("Qwertty"));

		verify(charCounter, atLeastOnce()).countChars("Qwerrty");
	}
}
