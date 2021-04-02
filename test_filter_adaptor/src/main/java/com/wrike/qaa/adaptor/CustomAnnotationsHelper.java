package com.wrike.qaa.adaptor;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Ivan Varivoda 08/03/2021
 */
public class CustomAnnotationsHelper {

    public static Map<String, String> getCustomAnnotationValues(Method method) {

        return Stream.of(Arrays.stream(method.getAnnotations()), Arrays.stream(method.getClass().getAnnotations()))
                .flatMap(annotationStream -> annotationStream)
                .filter(annotation -> Arrays.stream(annotation.annotationType().getAnnotations()).anyMatch(parentAnn -> parentAnn.annotationType().equals(FilterKey.class)))
                .collect(Collectors.toMap(annotation -> annotation.annotationType().getAnnotation(FilterKey.class).value(), CustomAnnotationsHelper::readAnnotationValueByReflection));
    }

    private static String readAnnotationValueByReflection(Annotation annotation) {
        try {
            return annotation.annotationType().getMethod("value").invoke(annotation).toString();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new IllegalStateException("Custom annotation `{%s}` must have value method with value of test coordinate");
        }
    }

}
