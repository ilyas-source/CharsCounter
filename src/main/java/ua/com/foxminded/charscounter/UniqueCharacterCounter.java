package ua.com.foxminded.charscounter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueCharacterCounter implements CharCounter {

	public Map<String, Long> charCount(String input) {
		return Arrays.stream(input.split(""))
				.collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
	}
}