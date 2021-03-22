package ua.com.foxminded.charscounter;

import java.util.Map;

public abstract class Decorator implements CharCount {
	protected CharCount charCount;

	@Override
	public Map<String, Long> charCount(String input) {
		return charCount.charCount(input);
	}
}
