package ua.com.foxminded.charscounter;

import java.util.HashMap;
import java.util.Map;

public class CachedDecorator extends CharCountDecorator {

	private Map<String, Map<String, Long>> cache = new HashMap<>();

	public CachedDecorator(CharCounter charCount) {
		this.charCount = charCount;
	}

	@Override
	public Map<String, Long> charCounter(String input) {
		cache.putIfAbsent(input, super.charCounter(input));

		return cache.get(input);
	}
}