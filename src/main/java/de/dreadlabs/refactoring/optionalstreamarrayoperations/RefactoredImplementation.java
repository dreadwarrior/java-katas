package de.dreadlabs.refactoring.optionalstreamarrayoperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RefactoredImplementation implements OptionalStreamArrayOperations {

    /**
     * @param csvIds comma separated list of ids; e.g. "1,2,3"
     * @return List of ids without empty items; e.g. csvIds="1, ,,4" will result in return value of "1,4"
     */
    @Override
    public List<String> convertCsvIdsToList(String csvIds) {
        return Optional.ofNullable(csvIds)
                .map(it -> it.split(","))
                .map(it -> it.length <= 0 ? new ArrayList<>(List.of(csvIds)) : Arrays.stream(it).map(String::trim).filter(id -> id.length() > 0).collect(Collectors.toCollection(ArrayList::new)))
                .orElse(new ArrayList<>(List.of()));
    }
}
