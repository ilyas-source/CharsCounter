package ua.com.foxminded.charscounter;

import java.util.Map;

public abstract class CharCountDecorator implements CharCounter {

	protected CharCounter charCount;

	@Override
	public Map<String, Long> charCounter(String input) {
		return charCount.charCounter(input);
	}
}
