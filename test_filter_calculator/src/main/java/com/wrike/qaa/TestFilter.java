package com.wrike.qaa;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Ivan Varivoda 06/03/2021
 */
public class TestFilter {

    public static final String TEST_FILTER_SET_REGEX = "\\{([^{])*:([^}])*}";

    private final String filter;
    private final BoolExpressionExecutor boolExpressionExecutor;

    public TestFilter(String filter) {
        this.filter = filter;
        boolExpressionExecutor = new BoolExpressionExecutor();
    }

    public boolean isValid() {
        String modifiedFilter = filter.replaceAll(TEST_FILTER_SET_REGEX, "false");
        try {
            boolExpressionExecutor.eval(modifiedFilter);
        } catch (TestFilterEvaluationException e) {
            return false;
        }
        return true;
    }

    public boolean match(Map<String, String> testCoords) {
        AtomicReference<String> modifiedFilter = new AtomicReference<>(filter);
        testCoords.forEach((key, value) -> modifiedFilter.set(modifiedFilter.get().replaceAll("\\{" + key + ":" + value + "}", "true")));

        modifiedFilter.set(modifiedFilter.get().replaceAll(TEST_FILTER_SET_REGEX, "false"));

        try {
            return boolExpressionExecutor.eval(modifiedFilter.get());
        } catch (TestFilterEvaluationException e) {
            throw new IllegalStateException(String.format("Test filter {%s} is wrong", filter));
        }
    }

}
