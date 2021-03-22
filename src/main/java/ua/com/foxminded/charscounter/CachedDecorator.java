package ua.com.foxminded.charscounter;

import java.util.HashMap;
import java.util.Map;

public class CachedDecorator extends Decorator {

	private Map<String, Map<String, Long>> cache = new HashMap<>();

	public CachedDecorator(CharCount charCount) {
		this.charCount = charCount;
	}

	@Override
	public Map<String, Long> charCount(String input) {
		Map<String, Long> cached = cache.get(input);
		if (cached != null) {
			return cached;
		}

		Map<String, Long> calculated = super.charCount(input);
		cache.put(input, calculated);

		return calculated;
	}
}