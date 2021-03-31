package ua.com.foxminded.charscounter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CachedCharCounterTest {

	@Mock
	private CharCounter charCounter;

	@InjectMocks
	CachedCharCounter cachedCharCounter;

	@Test
	void givenQwerttyTwice_onCachedCharCounter_thenCharCounterCalledOnce() {
		cachedCharCounter.countChars("Qwertty");
		cachedCharCounter.countChars("Qwertty");

		verify(charCounter).countChars("Qwertty");
	}

	@Test
	void givenQwertty_onCachedCharCounter_thenCharCounterOutputNotModified() {
		assertEquals(charCounter.countChars("Qwertty"), cachedCharCounter.countChars("Qwertty"));
	}

	@Test
	void givenQwerttyTwice_onCachedCharCounter_thenCharCounterOutputNotModified() {
		cachedCharCounter.countChars("Qwertty");
		assertEquals(charCounter.countChars("Qwertty"), cachedCharCounter.countChars("Qwertty"));
	}
}
