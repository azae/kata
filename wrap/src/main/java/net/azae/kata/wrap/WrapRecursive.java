package net.azae.kata.wrap;

public class WrapRecursive {
	
	public String wrapLine(String input, int maxLength) {
		if (input.length() <= maxLength) {
			return input;
		}
		
		int split = input.lastIndexOf(" ", maxLength);
		
		return input.substring(0, split) + "\n"	+ wrapLine(input.substring(split + 1), maxLength);
	}

}
