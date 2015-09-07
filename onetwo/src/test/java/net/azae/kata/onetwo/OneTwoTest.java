package net.azae.kata.onetwo;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class OneTwoTest {

    @DataProvider(name = "number2letters")
    public static Object[][] simpleCaseNumber2letters() {
        return new Object[][]{
                {"1", "one one"},
                {"12", "one one one two"},
                {"111556", "three one two five one six"},
                {"778099", "two seven one eight one zero two nine"},
                {"779999", "two seven four nine"},
                {"1111111111", "nine one one one"},

        };
    }

    @Test(dataProvider = "number2letters")
    public void should_return_good_letters_string(String input, String expected) {
        assertEquals(OneTwo.convertInLetter(input), expected);
    }

    @Test(dataProvider = "number2letters")
    public void should_return_good_number_from_string(String expected, String input) {
        assertEquals(OneTwo.convertToNumber(input), expected);
    }

}
