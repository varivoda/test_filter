package com.wrike.qaa.adaptor;

/**
 * Created by Ivan Varivoda 06/03/2021
 */
public class TestConfig {

    private String testFilter;

    public TestConfig() {
        String testFilter = System.getProperty("test.filter");
        if (testFilter == null || testFilter.isEmpty()) {
            throw new IllegalStateException("Set test.filter system property");
        }
        this.testFilter = testFilter;
    }

    public String getTestFilter() {
        return testFilter;
    }
}
