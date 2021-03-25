package ua.com.foxminded.charscounter;

import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		CharCounter charCounter = new CachedCharCounter(new UniqueCharCounter());
		boolean keepOn = true;
		Scanner scanner = new Scanner(System.in);

		while (keepOn) {
			System.out.println("Enter string, or Enter to quit: ");
			String string = scanner.nextLine();
			if (string.length() > 0) {
				for (Map.Entry<Character, Long> entry : charCounter.countChars(string).entrySet()) {
					System.out.println("\"" + entry.getKey() + "\" - " + entry.getValue());
				}
			} else {
				keepOn = false;
			}
		}
		scanner.close();

	}
}
