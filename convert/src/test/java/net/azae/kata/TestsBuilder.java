package net.azae.kata;

public class TestsBuilder {
	public static void main(String[] args) {
		for (int i = 1; i <= 1003; i++) {
			printTest(Convert.num2text(Integer.toString(i)), Integer.toString(i));
		}
		
		printTest(Convert.num2text("10078"), "10078");
		printTest(Convert.num2text("2007008"), "2007008");
		printTest(Convert.num2text("1007008"), "1007008");
		printTest(Convert.num2text("4000700008"), "4000700008");
		printTest(Convert.num2text("9000000700008"), "9000000700008");
		printTest(Convert.num2text("9012300000700008"), "9012300000700008");
		
	}

	private static void printTest(String expected, String input) {
		System.out.println("assertEquals(\"" + expected	+ "\", ConvertRefactored.num2text(\"" + input + "\"));");
	}
}
