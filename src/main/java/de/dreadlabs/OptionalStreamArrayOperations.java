package de.dreadlabs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalStreamArrayOperations {

    private OptionalStreamArrayOperations() {
    }

    /**
     * @param configs comma separated list of ids; e.g. "1,2,3"
     * @return List of ids without empty items; e.g. configs="1, ,,4" will result in return value of "1,4"
     */
    static List<String> convertCsvIdsToList(String configs) {
        ArrayList<String> list = new ArrayList<>();

        if (!Optional.ofNullable(configs).map(String::isBlank).orElse(true)) {
            // split the list and put all items into the list
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

        return list;
    }
}
