package net.azae.kata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Convert {
	
	public static final char[] NUM_0_9 = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	public static String[] TEXT_0_9 = new String[] { "zéro", "un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf" };
	public static String[] TEXT_10_19 = new String[] { "dix", "onze", "douze", "treize", "quatorze", "quinze", "seize", "dix sept", "dix huit",	"dix neuf" };
	public static String[] TEXT_10_90 = new String[] { "", "dix", "vingt", "trente", "quarante", "cinquante", "soixante", "soixante", "quatre vingt", "quatre vingt" };
	public static String[] TEXT_10_99 = new String[] { "", " et un", " deux", " trois", " quatre", " cinq", " six", " sept", " huit", " neuf" };
	public static String[] MAGNITUDE = new String[] { "", "mille", "million", "milliard", "billion", "billiar", "trillion", "trilliard", "quadrillion", "quadrilliard" };
	private static Map<Character, String> num2text09;
	private static Map<Character, String> num2text1019;
	private static Map<Character, String> num2text1090;
	private static Map<Character, String> num2text1099;

	/**
	 * Returns a text version of a number passed as input.
	 * 
	 * @param input The number to convert to text.
	 * @return Text version of the number.
	 */
	public static String num2text(String input) {
		if (num2text09 == null)
			loadNum2text();
		if (!isNumeric(input)) return null;
		String retour = "";
		List<String> blocks = split(input);
		for (int blockNumber = 0; blockNumber < blocks.size(); blockNumber++) {
			retour = processBlock( blocks.get(blockNumber), blockNumber, blocks.size()) + retour;
		}
		return retour.trim();
	}

	private static String processBlock( String block, int i, int total) {
		 if (renderBlock(block).equals("zéro") && total > 1) 
			 return "";
		 else 
			 return concatMagnitudeName(renderBlock(block), i);
	}

	private static String concatMagnitudeName(String blockText, int i) {
		String prefix = blockText + " ";
		if (blockText.equals("un") && i > 0 ) {
			prefix = "";
		}
		String suffix = "";
		if (i > 0) 
			suffix = " ";
		return prefix + MAGNITUDE[i] + suffix;
	
	}
	
	private static List<String> split(String input) {
		StringBuilder revertedInput = new StringBuilder(input).reverse();
		List<String> output = new ArrayList<>();
		for (int i = 0; i < (revertedInput.length() - 1) / 3 + 1; i++) {
			int end = Math.min(i*3 +3, revertedInput.length());
			String orderedBloc = new StringBuilder(revertedInput.substring(i*3, end)).reverse().toString();
			output.add(orderedBloc);
		}
		return output;
	}
	
	private static boolean isNumeric(String input) {
		return input.matches("^[0-9]+$");
	}

	private static String renderBlock(String input) {
		if (input.length() == 1)
			return un2text(input);
		if (input.length() == 2) {
			return renderDecade(input);
		}
		if (input.length() == 3) {
			String decade = renderDecade(input.substring(1, 3));
			String prefix = "";
			if (input.charAt(0) == '0')
				return decade;
			else if (input.charAt(0) == '1') {
				prefix = "cent";
			} else {
				prefix = num2text09.get(input.charAt(0)) + " cent";
			}
			if (decade.equals("zéro")) {
				return prefix;
			} else {
				return prefix + " " + decade;
			}
		}
		return null;
	}

	private static String renderDecade(String input) {
		if (input.length() == 2) {
			if (input.charAt(0) == '7' || input.charAt(0) == '9')
				return num2text1090.get(input.charAt(0)) + " " + num2text1019.get(input.charAt(1));
			else if (input.charAt(0) == '1')
				return num2text1019.get(input.charAt(1));
			else if (input.charAt(0) == '0')
				return num2text09.get(input.charAt(1));
			else
				return num2text1090.get(input.charAt(0)) + "" + num2text1099.get(input.charAt(1));
		}
		return null;
	}

	private static String un2text(String input) {
		if (input.length() == 1)
			return num2text09.get(input.charAt(0));
		return null;
	}

	private static void loadNum2text() {
		num2text09 = new HashMap<Character, String>();
		for (int i = 0; i < NUM_0_9.length; i++)
			num2text09.put(NUM_0_9[i], TEXT_0_9[i]);
		num2text1019 = new HashMap<Character, String>();
		for (int i = 0; i < NUM_0_9.length; i++)
			num2text1019.put(NUM_0_9[i], TEXT_10_19[i]);
		num2text1090 = new HashMap<Character, String>();
		for (int i = 0; i < NUM_0_9.length; i++)
			num2text1090.put(NUM_0_9[i], TEXT_10_90[i]);
		num2text1099 = new HashMap<Character, String>();
		for (int i = 0; i < NUM_0_9.length; i++)
			num2text1099.put(NUM_0_9[i], TEXT_10_99[i]);
	}

}