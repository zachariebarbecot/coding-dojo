package fr.zbar.codingdojo.foobarqix;

import lombok.Value;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Value(staticConstructor = "of")
public class Bar implements Word {

    private final static Integer FIVE = 5;
    private static final String BAR = "Bar";
    Integer number;

    @Override
    public Optional<String> getIfDivisible() {
        return Optional.of(isMod())
                .filter(Boolean::booleanValue)
                .map(b -> BAR);
    }

    @Override
    public Optional<String> getIfContains() {
        return Optional.of(contains())
                .filter(Boolean::booleanValue)
                .map(b -> getByOccurrence());
    }

    private Boolean isMod() {
        return number % FIVE == 0;
    }

    private Boolean contains() {
        String stringifyThree = String.valueOf(FIVE);
        return number.toString().contains(stringifyThree);
    }

    private String getByOccurrence() {
        long count = number.toString().chars().filter(ch -> ch == FIVE.toString().charAt(0)).count();
        return IntStream.range(0, (int) count)
                .mapToObj(i -> BAR)
                .collect(Collectors.joining());
    }
}
