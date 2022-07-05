package de.dreadlabs.refactoring.optionalstreamarrayoperations;

import java.util.ArrayList;
import java.util.List;

public class LegacyImplementation implements OptionalStreamArrayOperations {

    @Override
    public List<String> convertCsvIdsToList(String configs) {
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
