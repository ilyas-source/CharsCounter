package ua.com.foxminded.charscounter;

import java.util.Map;

public interface CharCounter {

	Map<String, Long> charCount(String input);
}
