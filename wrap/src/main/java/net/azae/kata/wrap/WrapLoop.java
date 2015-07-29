package net.azae.kata.wrap;

public class WrapLoop {
			
	public String wrapLine(String line, int maxLength) {
		StringBuilder output = new StringBuilder();
		String remaining = line;
		while (remaining.length() > maxLength) {
			int split = remaining.lastIndexOf(" ", maxLength);
			output.append(remaining.substring(0, split) + "\n");
			remaining = remaining.substring(split + 1);
		}
		output.append(remaining);
		return output.toString();
	}
	
}

