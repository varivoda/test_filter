package com.wrike.qaa;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * Created by Ivan Varivoda 06/03/2021
 */
class TestFilterTest {

    private TestFilter defaultTestFilter;

    @Test
    void testValidFilterReturnTrueOrExpression() {
        defaultTestFilter = new TestFilter("{epic:Login}|{story:notification}");
        Assertions.assertThat(defaultTestFilter.match(Map.of("epic", "Login"))).isTrue();
    }

    @Test
    void testValidFilterReturnFalseAndExpression() {
        defaultTestFilter = new TestFilter("{epic:Login}&{story:notification}");
        Assertions.assertThat(defaultTestFilter.match(Map.of("epic", "Login"))).isFalse();
    }

    @Test
    void testValidFilterReturnTrueAndExpression() {
        defaultTestFilter = new TestFilter("{epic:Login}&{story:notification}");
        Assertions.assertThat(defaultTestFilter.match(Map.of("epic", "Login", "story", "notification"))).isTrue();
    }

    @Test
    void testValidFilter() {
        defaultTestFilter = new TestFilter("{epic:Login}|{story:notification}");

        Assertions.assertThat(defaultTestFilter.isValid()).isTrue();
    }

    @Test
    void testInValidFilter() {
        defaultTestFilter = new TestFilter("inval{epic:Login}|{story:notification}");

        Assertions.assertThat(defaultTestFilter.isValid()).isFalse();
    }

}
