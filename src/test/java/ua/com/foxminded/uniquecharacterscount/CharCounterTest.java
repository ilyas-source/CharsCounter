package ua.com.foxminded.uniquecharacterscount;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ua.com.foxminded.uniquecharacterscount.CharCounter;

class CharCounterTest {

	CharCounter charCounter = new CharCounter();

	@Test
	void givenQwertty_onGetCharCount_thenGet6() {
		assertEquals(6, charCounter.getCharCount("Qwertty"));
	}

	@Test
	void givenEmptyString_onGetCharCount_thenGet0() {
		assertEquals(0, charCounter.getCharCount(""));
	}

}
