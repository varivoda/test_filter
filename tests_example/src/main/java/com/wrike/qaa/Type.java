package com.wrike.qaa;

import com.wrike.qaa.adaptor.FilterKey;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Ivan Varivoda 08/03/2021
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@FilterKey("type")
public @interface Type {

    String value();
}
