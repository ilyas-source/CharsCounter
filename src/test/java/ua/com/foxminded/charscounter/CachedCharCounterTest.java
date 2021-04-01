package ua.com.foxminded.charscounter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class CachedCharCounterTest {

	@Mock
	private CharCounter charCounter;

	@InjectMocks
	CachedCharCounter cachedCharCounter;

	@Test
	void givenQwerttyTwice_onCachedCharCounter_thenCharCounterCalledOnce() {
		String testString = "Qwerrty";
		cachedCharCounter.countChars(testString);
		cachedCharCounter.countChars(testString);
		verify(charCounter).countChars(testString);
	}

	@Test
	void givenQwertty_onCachedCharCounter_thenOutputNotModified() {
		Map<Character, Long> testMap = new HashMap<>();
		String testString = "Qwerrty";
		testMap.put('Q', 1L);
		testMap.put('w', 1L);
		testMap.put('e', 1L);
		testMap.put('r', 1L);
		testMap.put('t', 2L);
		testMap.put('y', 1L);
		when(charCounter.countChars(testString)).thenReturn(testMap);

		Map<Character, Long> expected = charCounter.countChars(testString);
		Map<Character, Long> actual = cachedCharCounter.countChars(testString);
		assertEquals(expected, actual);
	}
}
