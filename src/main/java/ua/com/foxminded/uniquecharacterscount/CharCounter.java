package ua.com.foxminded.uniquecharacterscount;

import java.util.HashMap;
import java.util.Map;

import javax.sound.midi.Soundbank;

public class CharCounter {

	private static Map<String, Integer> resultMap = new HashMap<>();

	public int getCharCount(String source) {
		if (resultMap.containsKey(source)) {
			return resultMap.get(source);
		}
		int count = countUnique(source);
		resultMap.put(source, count);
		return count;
	}

	private int countUnique(String input) {
		Character[] chars = new Character[input.length()];
		for (int i = 0; i < input.length(); i++) {
			chars[i] = input.charAt(i);
		}

		Map<Character, Long> calculations = new HashMap<>();

		for (Character c : chars) {
			if (calculations.containsKey(c)) {
				calculations.put(c, calculations.get(c) + 1);
			} else {
				calculations.put(c, (long) 0);
			}
		}

		return calculations.size();
	}
}
