package de.dreadlabs.refactoring.optionalstreamarrayoperations;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CommaDelimitedStringConverterTest {

    private final List<CommaDelimitedStringConverter> converters = List.of(
            new ImperativeConverter(),
            new FunctionalConverter()
    );
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", ", ,", ",,,    "})
    void returnsEmptyList(String input) {
        assertThat(converters).allSatisfy(it -> assertThat(it.toList(input)).as(classNameOf(it)).isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {",", ",,", ",,,"})
    void returnsInputAsIsIfOnlyContainingCommas(String input) {
        // @see https://stackoverflow.com/a/28035974
        assertThat(converters).allSatisfy(it -> assertThat(it.toList(input)).as(classNameOf(it)).isEqualTo(List.of(input)));
    }

    @Test
    void returnsListWithoutEmptyOrBlankItemsButTrimmedItems() {
        assertThat(converters).allSatisfy(it -> assertThat(it.toList("1,, ,2, 3 ,4")).as(classNameOf(it)).isEqualTo(List.of("1", "2", "3", "4")));
    }

    private String classNameOf(CommaDelimitedStringConverter it) {
        return it.getClass().getName();
    }
}
