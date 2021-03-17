package ua.com.foxminded.uniquecharacter;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		CharCounter charCounter = new CharCounter();
		String string = "qwerty";
		System.out.println("Unique characters count: " + charCounter.getCharCount(string));

		string = "21g3412gj3hf21k3jh21df3kjh12g*&^(*&$$$$$$$$$$$5555";
		System.out.println("Unique characters count: " + charCounter.getCharCount(string));
		string = "qwerty";
		System.out.println("Unique characters count: " + charCounter.getCharCount(string));

	}
}
