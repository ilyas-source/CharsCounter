package ua.com.foxminded.charscounter;

import java.util.LinkedHashMap;
import java.util.Map;

public class CachedCharCounter extends CharCounterDecorator {

	private Map<String, Map<Character, Long>> cache = new LinkedHashMap<>();

	public CachedCharCounter(CharCounter charCounter) {
		this.charCounter = charCounter;
	}

	@Override
	public Map<Character, Long> countChars(String input) {
		return cache.merge(input, super.countChars(input), (a, b) -> b);
	}
}