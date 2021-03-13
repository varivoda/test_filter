package com.wrike.qaa.adaptor;

/**
 * Created by Ivan Varivoda 06/03/2021
 */
public class TestConfig {

    private static final String testFilter;

    static {
        String testFilterProp = System.getProperty("test.filter");
        if (testFilterProp == null || testFilterProp.isEmpty()) {
            throw new IllegalStateException("Set test.filter system property");
        }
        testFilter = testFilterProp;
    }

    public static String getTestFilter() {
        return testFilter;
    }
}
