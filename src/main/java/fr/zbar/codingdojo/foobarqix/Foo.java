package fr.zbar.codingdojo.foobarqix;

import lombok.Value;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Value(staticConstructor = "of")
public class Foo implements Word {

    private final static Integer THREE = 3;
    private static final String FOO = "Foo";
    Integer number;

    @Override
    public Optional<String> getIfDivisible() {
        return Optional.of(isMod())
                .filter(Boolean::booleanValue)
                .map(b -> FOO);
    }

    @Override
    public Optional<String> getIfContains() {
        return Optional.of(contains())
                .filter(Boolean::booleanValue)
                .map(b -> getByOccurrence());
    }

    private Boolean isMod() {
        return number % THREE == 0;
    }

    private Boolean contains() {
        String stringifyThree = String.valueOf(THREE);
        return number.toString().contains(stringifyThree);
    }

    private String getByOccurrence() {
        long count = number.toString().chars().filter(ch -> ch == THREE.toString().charAt(0)).count();
        return IntStream.range(0, (int) count)
                .mapToObj(i -> FOO)
                .collect(Collectors.joining());
    }
}
