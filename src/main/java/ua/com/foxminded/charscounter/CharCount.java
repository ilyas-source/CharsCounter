package ua.com.foxminded.charscounter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharCount {

	private static Map<String, Map<String, Long>> resultMap = new HashMap<>();

	public Map<String, Long> charCount(String source) {
		if (resultMap.containsKey(source)) {
			return resultMap.get(source);
		}
		Map<String, Long> count = countNewString(source);
		resultMap.put(source, count);
		return count;
	}

	private Map<String, Long> countNewString(String input) {
		return Arrays.stream(input.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
	}
}
