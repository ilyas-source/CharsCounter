package ua.com.foxminded.charscounter;

import java.util.HashMap;
import java.util.Map;

import org.junit.platform.commons.util.ToStringBuilder;

public class CachedCharCounter extends CharCounterDecorator {

	private Map<String, Map<String, Long>> cache = new HashMap<>();

	public CachedCharCounter(CharCounter charCount) {
		this.charCounter = charCount;
	}

	@Override
	public Map<String, Long> charCounter(String input) {
		cache.putIfAbsent(input, super.charCounter(input));
		return cache.get(input);
	}
}