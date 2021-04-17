package fr.zbar.codingdojo.foobarqix;

import lombok.Value;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Value(staticConstructor = "of")
public class Qix implements Word {

    private final static Integer SEVEN = 7;
    private static final String QIX = "Qix";
    Integer number;

    @Override
    public Optional<String> getIfDivisible() {
        return Optional.of(isMod())
                .filter(Boolean::booleanValue)
                .map(b -> QIX);
    }

    @Override
    public Optional<String> getIfContains() {
        return Optional.of(contains())
                .filter(Boolean::booleanValue)
                .map(b -> getByOccurrence());
    }

    private Boolean isMod() {
        return number % SEVEN == 0;
    }

    private Boolean contains() {
        String stringifyThree = String.valueOf(SEVEN);
        return number.toString().contains(stringifyThree);
    }

    private String getByOccurrence() {
        long count = number.toString().chars().filter(ch -> ch == SEVEN.toString().charAt(0)).count();
        return IntStream.range(0, (int) count)
                .mapToObj(i -> QIX)
                .collect(Collectors.joining());
    }
}
