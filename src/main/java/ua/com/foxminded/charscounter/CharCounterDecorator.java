package ua.com.foxminded.charscounter;

import java.util.Map;

public abstract class CharCounterDecorator implements CharCounter {

	protected CharCounter charCounter;

	@Override
	public Map<Character, Long> countChars(String input) {
		return charCounter.countChars(input);
	}
}
