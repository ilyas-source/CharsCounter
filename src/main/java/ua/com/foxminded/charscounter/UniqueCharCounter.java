package ua.com.foxminded.charscounter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueCharCounter implements CharCounter {

	public Map<String, Long> charCounter(String input) {
		return input.codePoints().mapToObj(c -> String.valueOf((char) c))
				.collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));

	}
}