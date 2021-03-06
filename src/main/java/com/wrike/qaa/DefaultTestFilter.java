package com.wrike.qaa;

import java.util.Map;

/**
 * Created by Ivan Varivoda 06/03/2021
 */
public class DefaultTestFilter implements ITestFilter {

    public static final String TEST_FILTER_SET_REGEX = "\\{.*:([^}])*}";

    protected String filter;
    protected BoolExpressionExecutor boolExpressionExecutor;

    public DefaultTestFilter(String filter) {
        this.filter = filter;
        boolExpressionExecutor = new BoolExpressionExecutor();
    }

    @Override
    public boolean isValid() {
        String modifiedFilter = filter.replaceAll(TEST_FILTER_SET_REGEX, "false");
        try {
            boolExpressionExecutor.eval(modifiedFilter);
        } catch (TestFilterEvaluationException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean match(Map<String, String> testCoords) {
        final String[] modifiedFilter = {filter};
        testCoords.forEach((key, value) -> modifiedFilter[0] = modifiedFilter[0].replaceAll("\\{" + key + ":" + value + "}", "true"));

        modifiedFilter[0] = modifiedFilter[0].replaceAll(TEST_FILTER_SET_REGEX, "false");

        try {
            return boolExpressionExecutor.eval(modifiedFilter[0]);
        } catch (TestFilterEvaluationException e) {
            throw new IllegalStateException(String.format("Test filter {%s} is wrong", filter));
        }
    }

}
