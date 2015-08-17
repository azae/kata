package net.azae.kata;

public class TestsBuilder {

	public static void main(String[] args) {
        for (int i = 0; i < 1020; i++) {
            String input = Integer.toString(i);
            printAssert(input);
        }
        printAssert("10456");
        printAssert("10456034");
        printAssert("10456034856");
        printAssert("10456034000856");
        printAssert("10456034000856097");
        printAssert("abc");
        printAssert("1.6");
        printAssert("1€6");

	}

    private static void printAssert(String input) {
        String expected = Convert.num2text(input);
        System.out.println("assertEquals(\""+expected+"\", Convert.num2text(\""+input+"\"));");
    }
}
