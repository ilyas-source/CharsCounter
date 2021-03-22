package ua.com.foxminded.charscounter;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		CharCount simpleCharCount = new CharCountImplement();
		CharCount cachingCharCount = new CachedDecorator(simpleCharCount);

		boolean keepOn = true;
		Scanner scanner = new Scanner(System.in);

		while (keepOn) {
			System.out.println("Enter string, or Enter to quit: ");
			String string = scanner.nextLine();
			if (string.length() > 0) {
				System.out.println("Unique characters count: " + cachingCharCount.charCount(string));
			} else {
				keepOn = false;
			}
		}
		scanner.close();

	}
}
