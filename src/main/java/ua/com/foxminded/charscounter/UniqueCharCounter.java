package ua.com.foxminded.charscounter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import static java.util.stream.Collectors.*;

public class UniqueCharCounter implements CharCounter {

	public Map<Character, Long> countChars(String text) {
		return text.chars().mapToObj(c -> (char) c)
				.collect(groupingBy(Function.identity(), LinkedHashMap::new, counting()));

	}
}