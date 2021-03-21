package com.wrike.adaptor;

import com.wrike.qaa.TestFilter;
import com.wrike.qaa.adaptor.TestConfig;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Optional;

import static com.wrike.qaa.adaptor.AllureAnnotationHelper.getAllTestCoordinates;

/**
 * Created by Ivan Varivoda 19/05/2020
 */
public class TestFilterExecutionCondition implements ExecutionCondition {

    private final TestFilter defaultTestFilter = new TestFilter(TestConfig.getTestFilter());

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        Optional<Method> method = context.getTestMethod();
        if (method.isEmpty()) {
            return ConditionEvaluationResult.enabled("");
        }

        Map<String, String> testCoordinated = getAllTestCoordinates(method.get());

        return defaultTestFilter.match(testCoordinated) ?
                ConditionEvaluationResult.enabled("") : ConditionEvaluationResult.disabled("Test isn't fit for filter");
    }

}
