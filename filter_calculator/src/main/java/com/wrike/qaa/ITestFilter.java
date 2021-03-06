package com.wrike.qaa;

import java.util.Map;

/**
 * Created by Ivan Varivoda 06/03/2021
 */
public interface ITestFilter {

    boolean isValid();

    boolean match(Map<String, String> testCoords);
}
