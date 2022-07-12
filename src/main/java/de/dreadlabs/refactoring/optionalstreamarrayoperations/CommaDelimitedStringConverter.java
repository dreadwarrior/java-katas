package de.dreadlabs.refactoring.optionalstreamarrayoperations;

import java.util.List;

public interface CommaDelimitedStringConverter {

    /**
     * @param input comma separated list of ids; e.g. "1,2,3"
     * @return List of ids without empty items; e.g. input="1, ,,4" will result in return value of "1,4"
     */
    List<String> toList(String input);
}
