package fr.zbar.codingdojo.fizzbuzz;

import lombok.Value;

import java.util.Optional;
import java.util.stream.Stream;

@Value(staticConstructor = "of")
public class Buzz implements Word {

    private final static Integer FIVE = 5;
    private static final String BUZZ = "Buzz";
    Integer number;

    @Override
    public Optional<String> get() {
        return Stream.of(isMod(), contains())
                .filter(Boolean::booleanValue)
                .findAny()
                .map(b -> BUZZ);
    }

    private Boolean isMod() {
        return number % FIVE == 0;
    }

    private Boolean contains() {
        String stringifyFive = String.valueOf(FIVE);
        return number.toString().contains(stringifyFive);
    }
}
