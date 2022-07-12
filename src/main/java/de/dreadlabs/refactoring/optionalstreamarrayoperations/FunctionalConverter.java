package de.dreadlabs.refactoring.optionalstreamarrayoperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalConverter implements CommaDelimitedStringConverter {

    @Override
    public List<String> toList(String input) {
        return Optional.ofNullable(input)
                .map(ids -> ids.split(","))
                .stream()
                .flatMap(ids -> ids.length <= 0 ? Stream.of(input) : Arrays.stream(ids))
                .map(String::trim)
                .filter(id -> id.length() > 0)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
