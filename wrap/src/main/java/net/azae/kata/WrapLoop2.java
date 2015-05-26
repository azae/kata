package net.azae.kata;

public class WrapLoop2 {
			
	public String wrapLine(String line, int maxLength) {
		StringBuilder output = new StringBuilder();
		int pos = 0;
		while (pos + maxLength < line.length()) {
			int maxPos = pos + maxLength;
			int split = line.lastIndexOf(" ", maxPos);
			
			output.append(line.substring(pos, split) + "\n");
			pos = split + 1;
		}
		output.append(line.substring(pos));
		return output.toString();
	}
	
}

