package com.wrike.qaa;

import com.wrike.qaa.adaptor.TestConfig;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.SkipException;

import java.lang.reflect.Method;

import static com.wrike.qaa.adaptor.AllureAnnotationHelper.getStandardAllureAnnotationValues;

/**
 * Created by Ivan Varivoda 08/03/2021
 */
public class TestFilterListener implements IInvokedMethodListener {

    private TestConfig testConfig = new TestConfig();
    private DefaultTestFilter defaultTestFilter = new DefaultTestFilter(testConfig.getTestFilter());

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        Method javaMethod = method.getTestMethod().getConstructorOrMethod().getMethod();

        if (javaMethod == null) {
            return;
        }

        if (!defaultTestFilter.match(getStandardAllureAnnotationValues(javaMethod))) {
            throw new SkipException("This test doesn't fit by filter");
        }
    }
}
