package com.wrike.qaa;

import com.wrike.qaa.adaptor.TestConfig;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.SkipException;

import java.lang.reflect.Method;
import java.util.Map;

import static com.wrike.qaa.adaptor.AllureAnnotationHelper.getAllTestCoordinates;

/**
 * Created by Ivan Varivoda 08/03/2021
 */
public class TestFilterListener implements IInvokedMethodListener {

    private final TestFilter defaultTestFilter = new TestFilter(TestConfig.getTestFilter());

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

        Method javaMethod = getMethodFromInvokedMethod(method);
        if (javaMethod == null) {
            return;
        }

        Map<String, String> testCoords = getAllTestCoordinates(javaMethod);

        if (!defaultTestFilter.match(testCoords)) {
            throw new SkipException("This test doesn't fit by filter");
        }
    }

    private Method getMethodFromInvokedMethod(IInvokedMethod method) {
        return method.getTestMethod().getConstructorOrMethod().getMethod();
    }
}
