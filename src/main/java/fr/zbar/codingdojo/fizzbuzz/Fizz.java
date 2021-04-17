package fr.zbar.codingdojo.fizzbuzz;

import lombok.Value;

import java.util.Optional;
import java.util.stream.Stream;

@Value(staticConstructor = "of")
public class Fizz implements Word {

    private final static Integer THREE = 3;
    private static final String FIZZ = "Fizz";
    Integer number;

    @Override
    public Optional<String> get() {
        return Stream.of(isMod(), contains())
                .filter(Boolean::booleanValue)
                .findAny()
                .map(b -> FIZZ);
    }

    private Boolean isMod() {
        return number % THREE == 0;
    }

    private Boolean contains() {
        String stringifyThree = String.valueOf(THREE);
        return number.toString().contains(stringifyThree);
    }
}
