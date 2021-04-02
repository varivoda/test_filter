package com.wrike.qaa.adaptor;

/**
 * Created by Ivan Varivoda 06/03/2021
 *
 * Default way for getting test filter from System property
 */
public class TestConfig {

    private static final String TEST_FILTER;

    static {
        String testFilterProp = System.getProperty("test.filter");
        if (testFilterProp == null || testFilterProp.isEmpty()) {
            throw new IllegalStateException("Set test.filter system property");
        }
        TEST_FILTER = testFilterProp;
    }

    public static String getTestFilter() {
        return TEST_FILTER;
    }
}
