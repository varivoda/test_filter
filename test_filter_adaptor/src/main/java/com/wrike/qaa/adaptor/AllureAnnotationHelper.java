package com.wrike.qaa.adaptor;

import io.qameta.allure.Epic;
import io.qameta.allure.Epics;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.wrike.qaa.adaptor.CustomAnnotationsHelper.getCustomAnnotationValues;

/**
 * Created by Ivan Varivoda 06/03/2021
 */
public class AllureAnnotationHelper {

    public static final String EPIC_KEY = "epic";
    public static final String FEATURE_KEY = "feature";
    public static final String STORY_KEY = "story";

    public static Set<String> getStoryAnnotationValues(Method method) {
        Set<Story> typeSet = new HashSet<>(getAnnotations(method, method.getDeclaringClass(), Story.class));
        getAnnotations(method, method.getDeclaringClass(), Stories.class).forEach(it -> typeSet.addAll(Arrays.asList(it.value())));
        return typeSet.stream().map(Story::value).collect(Collectors.toSet());
    }

    public static Set<String> getFeatureAnnotationValues(Method method) {
        Set<Feature> typeSet = new HashSet<>(getAnnotations(method, method.getDeclaringClass(), Feature.class));
        getAnnotations(method, method.getDeclaringClass(), Features.class).forEach(it -> typeSet.addAll(Arrays.asList(it.value())));
        return typeSet.stream().map(Feature::value).collect(Collectors.toSet());
    }

    public static Set<String> getEpicAnnotationValues(Method method) {
        Set<Epic> typeSet = new HashSet<>(getAnnotations(method, method.getDeclaringClass(), Epic.class));
        getAnnotations(method, method.getDeclaringClass(), Epics.class).forEach(it -> typeSet.addAll(Arrays.asList(it.value())));
        return typeSet.stream().map(Epic::value).collect(Collectors.toSet());
    }

    public static Map<String, String> getStandardAllureAnnotationValues(Method method) {

        Map<String, String> epicMap = getEpicAnnotationValues(method).stream().collect(Collectors.toMap(o -> EPIC_KEY, o -> o));
        Map<String, String> featureMap = getFeatureAnnotationValues(method).stream().collect(Collectors.toMap(o -> FEATURE_KEY, o -> o));
        Map<String, String> storyMap = getStoryAnnotationValues(method).stream().collect(Collectors.toMap(o -> STORY_KEY, o -> o));

        return Stream.of(epicMap, featureMap, storyMap)
                .flatMap(stringStringMap -> stringStringMap.entrySet().stream())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    public static Map<String, String> getAllTestCoordinates(Method method) {
        return Stream.of(getCustomAnnotationValues(method), getStandardAllureAnnotationValues(method))
                .flatMap(stringStringMap -> stringStringMap.entrySet().stream())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    private static <T extends Annotation> Set<T> getAnnotations(Method method, Class<?> testClass, Class<T> annotationClass) {
        Set<T> annotationSet = new HashSet<>();

        T annotation;

        annotation = method.getAnnotation(annotationClass);
        if (annotation != null) {
            annotationSet.add(annotation);
        }

        annotation = testClass.getAnnotation(annotationClass);
        if (annotation != null) {
            annotationSet.add(annotation);
        }

        return annotationSet;
    }

}
