package fr.zbar.codingdojo.foobarqix;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class FooBarQix {

    public String execute(Integer input) {
        return foobarQix(Foo.of(input), Bar.of(input), Qix.of(input))
                .orElseGet(input::toString);
    }

    private Optional<String> foobarQix(Word... words) {
        return Stream.of(getWordsIfDivisible(words), getWordsIfContain(words))
                .flatMap(Optional::stream)
                .reduce(String::concat);
    }

    private Optional<String> getWordsIfDivisible(Word[] words) {
        return getWords(words, Word::getIfDivisible);
    }

    private Optional<String> getWordsIfContain(Word[] words) {
        return getWords(words, Word::getIfContains);
    }

    private Optional<String> getWords(Word[] words, Function<Word, Optional<String>> fun) {
        return Arrays.stream(words)
                .map(fun)
                .flatMap(Optional::stream)
                .reduce(String::concat);
    }
}
