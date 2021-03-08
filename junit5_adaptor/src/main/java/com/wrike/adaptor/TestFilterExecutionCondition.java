package com.wrike.adaptor;

import com.wrike.qaa.DefaultTestFilter;
import com.wrike.qaa.adaptor.TestConfig;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Method;
import java.util.Optional;

import static com.wrike.qaa.adaptor.AllureAnnotationHelper.getStandardAllureAnnotationValues;

/**
 * Created by Ivan Varivoda 19/05/2020
 */
public class TestFilterExecutionCondition implements ExecutionCondition {

    private TestConfig testConfig = new TestConfig();
    private DefaultTestFilter defaultTestFilter = new DefaultTestFilter(testConfig.getTestFilter());

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        Optional<Method> method = context.getTestMethod();
        // in case context for method
        if (method.isEmpty()) {
            return ConditionEvaluationResult.enabled("");
        }
        return defaultTestFilter.match(getStandardAllureAnnotationValues(method.get())) ? ConditionEvaluationResult.enabled("") : ConditionEvaluationResult.disabled("");
    }

}
