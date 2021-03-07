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
import java.util.Set;
import java.util.stream.Collectors;

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

    // TODO: 06/03/2021 Add custom annotations handling
//    public static Map<String, String> getCustomAnnotationValues(Method method) {
//
//        Set<Annotation> methodAnnotations = Arrays.stream(method.getAnnotations()).filter(annotation -> Arrays.stream(annotation.annotationType()
//                .getAnnotations()).anyMatch(annotation1 -> annotation1.getClass().equals(FilterKey.class))).collect(Collectors.toSet());
//
//
//        Set<Epic> typeSet = new HashSet<>(getAnnotations(method, method.getClass(), Epic.class));
//        getAnnotations(method, method.getClass(), Epics.class).forEach(it -> typeSet.addAll(Arrays.asList(it.value())));
//        return typeSet.stream().map(Epic::value).collect(Collectors.toSet());
//
//    }


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

//    public static Set<String> getAllAnnotationValuesWithPrefixes(Method method, Class<?> testClass) {
//        Set<String> res = new HashSet<>();
//        res.addAll(getEpicAnnotationValues(method, testClass).stream().map(s ->  FilterPrefix.EPIC_PREFIX.getPrefixWithDelimiter() + s).collect(Collectors.toList()));
//        res.addAll(getFeatureAnnotationValues(method, testClass).stream().map(s ->  FilterPrefix.FEATURE_PREFIX.getPrefixWithDelimiter() + s).collect(Collectors.toList()));
//        res.addAll(getStoryAnnotationValues(method, testClass).stream().map(s ->  FilterPrefix.STORY_PREFIX.getPrefixWithDelimiter() + s).collect(Collectors.toList()));
//        res.addAll(getTypeAnnotationValues(method, testClass).stream().map(s ->  FilterPrefix.TYPE_PREFIX.getPrefixWithDelimiter() + s).collect(Collectors.toList()));
//        res.addAll(getHandlerAnnotationValues(method, testClass).stream().map(s ->  FilterPrefix.HANDLER_PREFIX.getPrefixWithDelimiter() + s).collect(Collectors.toList()));
//        res.addAll(getServiceAnnotationValues(method, testClass).stream().map(s ->  FilterPrefix.SERVICE_PREFIX.getPrefixWithDelimiter() + s).collect(Collectors.toList()));
//
//        return res;
//    }

}
