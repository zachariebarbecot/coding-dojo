package fr.zbar.codingdojo.fizzbuzz;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

public class FizzBuzz {

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        IntStream.rangeClosed(1, 100)
                .mapToObj(fizzBuzz::execute)
                .forEach(System.out::println);
    }

    public String execute(Integer input) {
        return fizzBuzz(Fizz.of(input), Buzz.of(input))
                .orElseGet(input::toString);
    }

    private Optional<String> fizzBuzz(Word... words) {
        return Arrays.stream(words)
                .map(Word::get)
                .flatMap(Optional::stream)
                .reduce(String::concat);
    }
}
