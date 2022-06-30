package de.dreadlabs;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class OptionalStreamArrayOperationsTest {

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " "})
    void returnsEmptyList(String input) {
        assertThat(doIt(input)).isEmpty();
    }

    @Test
    @Disabled("until I make it")
    void returnsEmptyListIfNothingNeedsToBeSplitted() {
    }

    @Test
    @Disabled("until I make it")
    void returnsListWithoutEmptyItems() {
    }

    @Test
    @Disabled("until I make it")
    void returnsListWithoutBlankItems() {
    }

    /**
     * @param configs comma separated list of ids; e.g. "1,2,3"
     * @return List of ids without empty items; e.g. configs="1, ,,4" will result in return value of "1,4"
     */
    private List<String> doIt(String configs) {
        ArrayList<String> list = new ArrayList<>();

        if (configs != null && !configs.trim().isEmpty()) { // TODO: compare with call to StringValidator.isEmptyString() at line 5
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

    static class StringValidator {

        public static boolean isEmptyString(String string) {
            return string == null || string.trim().isEmpty();
        }
    }
}
