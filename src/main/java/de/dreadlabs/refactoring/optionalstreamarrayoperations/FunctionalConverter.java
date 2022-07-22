package de.dreadlabs.refactoring.optionalstreamarrayoperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionalConverter implements CommaDelimitedStringConverter {

    @Override
    public List<String> toList(String input) {
        if (input == null || input.isBlank()) {
            return new ArrayList<>();
        }

        String[] ids = input.split(",");
        boolean inputConsistsOfCommasOnly = ids.length == 0;
        if (inputConsistsOfCommasOnly) {
            return List.of(input);
        }

        return Arrays.stream(ids)
                .map(String::trim)
                .filter(Predicate.not(String::isEmpty))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
