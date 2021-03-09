package com.wrike.qaa;

import com.wrike.qaa.adaptor.TestConfig;
import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.wrike.qaa.adaptor.AllureAnnotationHelper.getStandardAllureAnnotationValues;
import static com.wrike.qaa.adaptor.CustomAnnotationsHelper.getCustomAnnotationValues;

/**
 * Created by Ivan Varivoda 09/03/2021
 */
public class TestFilter extends Filter {

    private TestConfig testConfig = new TestConfig();
    private DefaultTestFilter defaultTestFilter = new DefaultTestFilter(testConfig.getTestFilter());

    @Override
    public boolean shouldRun(Description description) {
        if (!description.isTest()) {
            return true;
        }

        Method method = null;
        // TODO: 09/03/2021 подумать как лучше сделать
        try {
            method = description.getTestClass().getMethod(description.getMethodName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        Map<String, String> annotationValues = Stream.of(getCustomAnnotationValues(method), getStandardAllureAnnotationValues(method))
                .flatMap(stringStringMap -> stringStringMap.entrySet().stream())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

        return defaultTestFilter.match(annotationValues);
    }

    @Override
    public String describe() {
        return null;
    }
}
