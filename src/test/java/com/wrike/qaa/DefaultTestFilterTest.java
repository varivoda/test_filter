package com.wrike.qaa;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * Created by Ivan Varivoda 06/03/2021
 */
class DefaultTestFilterTest {

    private DefaultTestFilter defaultTestFilter;

    @Test
    void testValidFilterReturnTrueOrExpression() {
        defaultTestFilter = new DefaultTestFilter("{epic:Login}|{story:notification}");
        Assertions.assertThat(defaultTestFilter.match(Map.of("epic", "Login"))).isTrue();
    }

    @Test
    void testValidFilterReturnFalseAndExpression() {
        defaultTestFilter = new DefaultTestFilter("{epic:Login}&{story:notification}");
        Assertions.assertThat(defaultTestFilter.match(Map.of("epic", "Login"))).isFalse();
    }

    @Test
    void testValidFilterReturnTrueAndExpression() {
        defaultTestFilter = new DefaultTestFilter("{epic:Login}&{story:notification}");
        Assertions.assertThat(defaultTestFilter.match(Map.of("epic", "Login", "story", "notification"))).isTrue();
    }

    @Test
    void testValidFilter() {
        defaultTestFilter = new DefaultTestFilter("{epic:Login}|{story:notification}");

        Assertions.assertThat(defaultTestFilter.isValid()).isTrue();
    }

    @Test
    void testInValidFilter() {
        defaultTestFilter = new DefaultTestFilter("inval{epic:Login}|{story:notification}");

        Assertions.assertThat(defaultTestFilter.isValid()).isFalse();
    }

}
