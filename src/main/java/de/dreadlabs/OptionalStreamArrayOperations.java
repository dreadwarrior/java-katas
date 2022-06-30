package de.dreadlabs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalStreamArrayOperations {

    private OptionalStreamArrayOperations() {
    }

    /**
     * @param csvIds comma separated list of ids; e.g. "1,2,3"
     * @return List of ids without empty items; e.g. csvIds="1, ,,4" will result in return value of "1,4"
     */
    static ArrayList<String> convertCsvIdsToList(String csvIds) {
        if (Optional.ofNullable(csvIds).map(String::isBlank).orElse(true)) {
            return new ArrayList<>(List.of());
        }

        // split the list and put all items into the list
        String[] ids = csvIds.split(",");

        if (ids.length <= 0) { // no comma
            return new ArrayList<>(List.of(csvIds));
        }

        return Arrays.stream(ids).map(String::trim).filter(it -> it.length() > 0).collect(Collectors.toCollection(ArrayList::new));
    }

    static ArrayList<String> convertCsvIdsToListOriginal(String configs) {
        ArrayList<String> list = new ArrayList<>();
        if (configs != null && !configs.trim().isEmpty()) {
            // split the list and put all items into the list
            if (!StringValidator.isEmptyString(configs)) {
                String[] feld = configs.split(",");
                if (feld != null) {
                    if (feld.length > 0) {
                        for (String dummy : feld) {
                            String tmp = dummy.trim();
                            if (tmp.length() > 0) {
                                list.add(tmp);
                            }
                        }
                    } else { // no comma
                        list.add(configs);
                    }
                }
            }
        }

        return list;
    }

    private static class StringValidator {
        public static boolean isEmptyString(String string) {
            return string == null || string.trim().isEmpty();
        }
    }
}
