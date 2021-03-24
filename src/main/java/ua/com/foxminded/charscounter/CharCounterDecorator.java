package ua.com.foxminded.charscounter;

import java.util.Map;

public abstract class CharCounterDecorator implements CharCounter {

	protected CharCounter charCounter;

	@Override
	public Map<String, Long> charCounter(String input) {
		return charCounter.charCounter(input);
	}
}
