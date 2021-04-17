package fr.zbar.codingdojo.foobarqix;

import java.util.Optional;

public interface Word {

    Optional<String> getIfDivisible();

    Optional<String> getIfContains();
}
