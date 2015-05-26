package net.azae.kata;

public class TestsBuilder {

    public static void main(String[] args) {
        for (int i = 0; i < 2000; i++) {
            printAssert(Integer.toString(i));
        }
        printAssert("10009");
        printAssert("12300012130006780009");
        printAssert("az0009");

    }

    private static void printAssert(String input) {
        String expected = Convert.num2text(input);
        if (expected != null)
            System.out.println("assertEquals(\"" + expected + "\", Convert.num2text(\"" + input + "\"));");
        else
            System.out.println("assertEquals(null, Convert.num2text(\"" + input + "\"));");
    }
}
