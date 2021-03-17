package ua.com.foxminded.uniquecharacter;

import java.util.HashMap;
import java.util.Map;

public class CharCounter {

	private static Map<String, Integer> resultMap = new HashMap<>();

	public int getCharCount(String source) {
		String md5Hash = MD5.getMd5(source);
		if (resultMap.containsKey(md5Hash)) {
			return resultMap.get(md5Hash);
		}
		int count = countUnique(source);
		resultMap.put(md5Hash, count);
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
