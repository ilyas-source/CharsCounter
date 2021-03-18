package ua.com.foxminded.uniquecharacterscount;

import java.util.HashMap;
import java.util.Map;

import javax.sound.midi.Soundbank;

public class CharCounter {

	private static Map<String, Map<Character, Long>> resultMap = new HashMap<>();

	public Map<Character, Long> getCharCount(String source) {
		if (resultMap.containsKey(source)) {
			System.out.println("Have in cache: ");
			return resultMap.get(source);
		}
		Map<Character, Long> count = countUnique(source);
		resultMap.put(source, count);
		return count;
	}

	private Map<Character, Long> countUnique(String input) {
		Character[] chars = new Character[input.length()];
		for (int i = 0; i < input.length(); i++) {
			chars[i] = input.charAt(i);
		}

		Map<Character, Long> calculations = new HashMap<>();

		for (Character c : chars) {
			if (calculations.containsKey(c)) {
				calculations.put(c, calculations.get(c) + 1);
			} else {
				calculations.put(c, (long) 1);
			}
		}

		return calculations;
	}
}
