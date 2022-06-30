package de.dreadlabs;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class OptionalStreamArrayOperationsTest {

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", ", ,", ",,,    "})
    void returnsEmptyList(String input) {
        assertThat(OptionalStreamArrayOperations.convertCsvIdsToList(input)).isEmpty();
    }

    @ParameterizedTest
    @ValueSource(strings = {",", ",,", ",,,"})
    void returnsInputAsIsIfOnlyContainingCommas(String input) {
        // @see https://stackoverflow.com/a/28035974
        assertThat(OptionalStreamArrayOperations.convertCsvIdsToList(input)).isEqualTo(List.of(input));
    }

    @Test
    void returnsListWithoutEmptyOrBlankItemsButTrimmedItems() {
        assertThat(OptionalStreamArrayOperations.convertCsvIdsToList("1,, ,2, 3 ,4")).isEqualTo(List.of("1", "2", "3", "4"));
    }

}
