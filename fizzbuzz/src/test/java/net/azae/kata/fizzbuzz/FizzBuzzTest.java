package net.azae.kata.fizzbuzz;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class FizzBuzzTest {

    @DataProvider(name = "implementations")
    public static Object[][] implementations() {
        return new Object[][]{
                {new FizzBuzzImperatif()},
                {new FizzBuzzStream()},
        };
    }


    @Test(dataProvider = "implementations")
    public void should_returns_fizz_when_input_is_divisible_by_3(final FizzBuzz implementation) {
        assertEquals(implementation.compute("3"), "Fizz");
    }

    @Test(dataProvider = "implementations")
    public void should_returns_buzz_when_input_is_divisible_by_5(final FizzBuzz implementation) {
        assertEquals(implementation.compute("5"), "Buzz");
    }

    @Test(dataProvider = "implementations")
    public void should_returns_fizzbuzz_when_input_is_divisible_by_3_and_5(final FizzBuzz implementation) {
        assertEquals(implementation.compute("15"), "FizzBuzz");
    }

    @Test(dataProvider = "implementations")
    public void should_returns_input_when_input_is_neither_divisible_by_3_or_5(final FizzBuzz implementation) {
        assertEquals(implementation.compute("1"), "1");
        assertEquals(implementation.compute("4"), "4");
    }
}
