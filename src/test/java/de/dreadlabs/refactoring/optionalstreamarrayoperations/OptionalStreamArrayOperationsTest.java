package de.dreadlabs.refactoring.optionalstreamarrayoperations;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class OptionalStreamArrayOperationsTest {
    private final List<OptionalStreamArrayOperations> implementations = List.of(
            new LegacyImplementation(),
            new RefactoredImplementation()
    );
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", ", ,", ",,,    "})
    void returnsEmptyList(String input) {
        assertThat(implementations).allSatisfy(it -> assertThat(it.convertCsvIdsToList(input)).as(classNameOf(it)).isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {",", ",,", ",,,"})
    void returnsInputAsIsIfOnlyContainingCommas(String input) {
        // @see https://stackoverflow.com/a/28035974
        assertThat(implementations).allSatisfy(it -> assertThat(it.convertCsvIdsToList(input)).as(classNameOf(it)).isEqualTo(List.of(input)));
    }

    @Test
    void returnsListWithoutEmptyOrBlankItemsButTrimmedItems() {
        assertThat(implementations).allSatisfy(it -> assertThat(it.convertCsvIdsToList("1,, ,2, 3 ,4")).as(classNameOf(it)).isEqualTo(List.of("1", "2", "3", "4")));
    }

    private String classNameOf(OptionalStreamArrayOperations it) {
        return it.getClass().getName();
    }
}
