package com.wrike.adaptor;

import com.wrike.qaa.DefaultTestFilter;
import com.wrike.qaa.adaptor.AllureAnnotationHelper;
import com.wrike.qaa.adaptor.TestConfig;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Ivan Varivoda 19/05/2020
 */
public class TestFilterExecutionCondition implements ExecutionCondition {

    private TestConfig testConfig = new TestConfig();
    private DefaultTestFilter defaultTestFilter = new DefaultTestFilter(testConfig.getTestFilter());
    // TODO: 06/03/2021 DI??

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {

        Optional<Method> method = context.getTestMethod();

        // TODO: 06/03/2021 epic и прочее вынести в константу
        Map<String, String> epicMap = AllureAnnotationHelper.getEpicAnnotationValues(method.get()).stream().collect(Collectors.toMap(o -> "epic", o -> o));
        Map<String, String> featureMap = AllureAnnotationHelper.getFeatureAnnotationValues(method.get()).stream().collect(Collectors.toMap(o -> "feature", o -> o));
        Map<String, String> storyMap = AllureAnnotationHelper.getStoryAnnotationValues(method.get()).stream().collect(Collectors.toMap(o -> "story", o -> o));

        // TODO: 06/03/2021 тут все проверит вдоль и поперек
        Map<String, String> joinedMap = Stream.of(epicMap, featureMap, storyMap).flatMap(stringStringMap -> stringStringMap.entrySet().stream()).collect(Collectors.toMap(o -> o.getKey(), o -> o.getValue()));

        return defaultTestFilter.match(joinedMap) ? ConditionEvaluationResult.enabled("") : ConditionEvaluationResult.disabled("");
        }

}
