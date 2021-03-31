package ua.com.foxminded.charscounter;

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
	void givenQwerttyTwice_onCachedCharCounter_thenCharCounterCalledOnce() {
		cachedCharCounter.countChars("Qwertty");
		cachedCharCounter.countChars("Qwertty");

		verify(charCounter, times(1)).countChars("Qwertty");
	}

	@Test
	void givenEmptyStringTwice_onCachedCharCounter_thenCharCounterCalledOnce() {
		cachedCharCounter.countChars("");
		cachedCharCounter.countChars("");

		verify(charCounter, times(1)).countChars("");
	}

	@Test
	void givenWWWwwwTwice_onCachedCharCounter_thenCharCounterCalledOnce() {
		cachedCharCounter.countChars("WWWwww");
		cachedCharCounter.countChars("WWWwww");

		verify(charCounter, times(1)).countChars("WWWwww");
	}
}
