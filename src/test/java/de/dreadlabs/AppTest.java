package de.dreadlabs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AppTest {

    @Test
    void assertjShouldWork() {
        boolean actual = true;
        assertThat(actual).isTrue();
    }
}
