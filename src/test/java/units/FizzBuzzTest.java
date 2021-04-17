package units;

import fr.zbar.codingdojo.fizzbuzz.FizzBuzz;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @BeforeEach
    void init() {
        fizzBuzz = new FizzBuzz();
    }

    @ParameterizedTest(name = "Returns {0} when entered {0}")
    @CsvSource({"1", "2", "4", "7", "8", "11", "14", "16", "17", "19"})
    void should_return_only_number(Integer input) {
        assertThat(fizzBuzz.execute(input)).isEqualTo(input.toString());
    }

    @ParameterizedTest(name = "Returns Fizz when entered {0}")
    @CsvSource({"3", "6", "9", "12", "18"})
    void should_return_fizz_when_number_is_only_mod_three(Integer input) {
        assertThat(fizzBuzz.execute(input)).isEqualTo("Fizz");
    }

    @ParameterizedTest(name = "Returns Buzz when entered {0}")
    @CsvSource({"5", "10", "20"})
    void should_return_buzz_when_number_is_only_mod_five(Integer input) {
        assertThat(fizzBuzz.execute(input)).isEqualTo("Buzz");
    }

    @ParameterizedTest(name = "Returns FizzBuzz when entered {0}")
    @CsvSource({"15"})
    void should_return_fizzbuzz_when_number_is_mod_three_and_mod_five(Integer input) {
        assertThat(fizzBuzz.execute(input)).isEqualTo("FizzBuzz");
    }

    @ParameterizedTest(name = "Returns Fizz when entered {0}")
    @CsvSource({"13", "23", "31", "32", "34"})
    void should_return_fizz_when_number_contains_three(Integer input) {
        assertThat(fizzBuzz.execute(input)).isEqualTo("Fizz");
    }

    @ParameterizedTest(name = "Returns Buzz when entered {0}")
    @CsvSource({"52", "56", "58", "59"})
    void should_return_buzz_when_number_contains_five(Integer input) {
        assertThat(fizzBuzz.execute(input)).isEqualTo("Buzz");
    }

    @ParameterizedTest(name = "Returns FizzBuzz when entered {0}")
    @CsvSource({"35", "51", "54", "57"})
    void should_return_fizzbuzz_when_number_contains_or_is_mod_three_and_mod_five(Integer input) {
        assertThat(fizzBuzz.execute(input)).isEqualTo("FizzBuzz");
    }
}
