package ua.com.foxminded.charscounter;

import java.util.HashMap;
import java.util.Map;

public class CachingCharCounter extends CharCounterDecorator {

	private Map<String, Map<String, Long>> cache = new HashMap<>();

	public CachingCharCounter(CharCounter charCount) {
		this.charCounter = charCount;
	}

	@Override
	public Map<String, Long> charCounter(String input) {
		cache.putIfAbsent(input, super.charCounter(input));

		return cache.get(input);
	}
}