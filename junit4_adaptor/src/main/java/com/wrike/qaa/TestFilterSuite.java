package com.wrike.qaa;

import com.googlecode.junittoolbox.WildcardPatternSuite;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

/**
 * Created by Ivan Varivoda 09/03/2021
 */
public class TestFilterSuite extends WildcardPatternSuite {

    public TestFilterSuite(Class<?> klass, RunnerBuilder builder)
            throws InitializationError, NoTestsRemainException {
        super(klass, builder);
        filter(new TestFilterJunit4());
    }
}

