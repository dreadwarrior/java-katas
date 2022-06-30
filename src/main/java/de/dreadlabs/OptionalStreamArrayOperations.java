package de.dreadlabs;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalStreamArrayOperations {

    private OptionalStreamArrayOperations() {
    }

    /**
     * @param csvIds comma separated list of ids; e.g. "1,2,3"
     * @return List of ids without empty items; e.g. csvIds="1, ,,4" will result in return value of "1,4"
     */
    static List<String> convertCsvIdsToList(String csvIds) {
        if (Optional.ofNullable(csvIds).map(String::isBlank).orElse(true)) {
            return List.of();
        }

        // split the list and put all items into the list
        String[] ids = csvIds.split(",");

        if (ids.length <= 0) { // no comma
            return List.of(csvIds);
        }

        return Arrays.stream(ids).map(String::trim).filter(it -> it.length() > 0).toList();
    }
}
