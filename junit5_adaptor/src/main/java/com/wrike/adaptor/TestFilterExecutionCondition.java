package com.wrike.adaptor;

import com.wrike.qaa.DefaultTestFilter;
import com.wrike.qaa.adaptor.AllureAnnotationHelper;
import com.wrike.qaa.adaptor.TestConfig;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.wrike.qaa.adaptor.AllureAnnotationHelper.*;

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

        Map<String, String> epicMap = AllureAnnotationHelper.getEpicAnnotationValues(method.get()).stream().collect(Collectors.toMap(o -> EPIC_KEY, o -> o));
        Map<String, String> featureMap = AllureAnnotationHelper.getFeatureAnnotationValues(method.get()).stream().collect(Collectors.toMap(o -> FEATURE_KEY, o -> o));
        Map<String, String> storyMap = AllureAnnotationHelper.getStoryAnnotationValues(method.get()).stream().collect(Collectors.toMap(o -> STORY_KEY, o -> o));

        Map<String, String> joinedMap = Stream.of(epicMap, featureMap, storyMap)
                .flatMap(stringStringMap -> stringStringMap.entrySet().stream())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

        return defaultTestFilter.match(joinedMap) ? ConditionEvaluationResult.enabled("") : ConditionEvaluationResult.disabled("");
    }

}
