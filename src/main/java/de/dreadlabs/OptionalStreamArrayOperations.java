package de.dreadlabs;

import java.util.ArrayList;
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
        ArrayList<String> list = new ArrayList<>();

        if (!Optional.ofNullable(csvIds).map(String::isBlank).orElse(true)) {
            // split the list and put all items into the list
            String[] ids = csvIds.split(",");
            if (ids.length > 0) {
                for (String id : ids) {
                    String trimmedId = id.trim();
                    if (trimmedId.length() > 0) {
                        list.add(trimmedId);
                    }
                }
            } else { // no comma
                list.add(csvIds);
            }
        }

        return list;
    }
}
