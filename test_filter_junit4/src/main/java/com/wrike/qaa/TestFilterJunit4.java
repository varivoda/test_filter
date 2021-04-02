package com.wrike.qaa;

import com.wrike.qaa.adaptor.TestConfig;
import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;

import java.lang.reflect.Method;
import java.util.Map;

import static com.wrike.qaa.adaptor.AllureAnnotationHelper.getAllTestCoordinates;

/**
 * Created by Ivan Varivoda 09/03/2021
 */
public class TestFilterJunit4 extends Filter {

    private final TestFilter defaultTestFilter = new TestFilter(TestConfig.getTestFilter());

    @Override
    public boolean shouldRun(Description description) {

        if (!description.isTest()) {
            return true;
        }

        Method method = getMethodFromDescription(description);
        Map<String, String> annotationValues = getAllTestCoordinates(method);

        return defaultTestFilter.match(annotationValues);
    }


    private Method getMethodFromDescription(Description description) {
        try {
            return description.getTestClass().getMethod(description.getMethodName());
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public String describe() {
        return null;
    }
}
