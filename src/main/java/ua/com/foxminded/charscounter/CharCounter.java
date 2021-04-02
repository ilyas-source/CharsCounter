package ua.com.foxminded.charscounter;

import java.util.Map;

public interface CharCounter {

	Map<Character, Long> countChars(String input);
}
