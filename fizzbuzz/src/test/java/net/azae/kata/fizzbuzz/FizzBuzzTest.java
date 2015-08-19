package net.azae.kata.fizzbuzz;

import org.testng.annotations.Test;

import static net.azae.kata.fizzbuzz.FizzBuzz.compute;
import static org.testng.Assert.assertEquals;

public class FizzBuzzTest {

    @Test
    public void should_returns_fizz_when_input_is_divisible_by_3() {
        assertEquals(compute("3"), "Fizz");
    }

    @Test
    public void should_returns_buzz_when_input_is_divisible_by_5() {
        assertEquals(compute("5"), "Buzz");
    }

    @Test
    public void should_returns_fizzbuzz_when_input_is_divisible_by_3_and_5() {
        assertEquals(compute("15"), "FizzBuzz");
    }

    @Test
    public void should_returns_input_when_input_is_neither_divisible_by_3_or_5() {
        assertEquals(compute("1"), "1");
        assertEquals(compute("4"), "4");
    }

}
