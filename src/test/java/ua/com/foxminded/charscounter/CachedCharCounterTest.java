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
	private CachedCharCounter cachedCharCounter;

	@Test
	void givenQwerttyTwice_onCachedCharCounter_thenCharCounterCalledOnce() {
		String testString = "Qwerrty";
		cachedCharCounter.countChars(testString);
		cachedCharCounter.countChars(testString);
		verify(charCounter).countChars(testString);
	}

	@Test
	void givenQwertty_onCachedCharCounter_thenOutputNotModified() {
		Map<Character, Long> expected = new HashMap<>();
		String testString = "Qwerrty";
		expected.put('Q', 1L);
		expected.put('w', 1L);
		expected.put('e', 1L);
		expected.put('r', 1L);
		expected.put('t', 2L);
		expected.put('y', 1L);
		when(charCounter.countChars(testString)).thenReturn(expected);

		Map<Character, Long> actual = cachedCharCounter.countChars(testString);

		assertEquals(expected, actual);
	}
}
