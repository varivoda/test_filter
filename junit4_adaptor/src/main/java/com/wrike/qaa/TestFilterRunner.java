package com.wrike.qaa;

import com.googlecode.junittoolbox.WildcardPatternSuite;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

/**
 * Created by Ivan Varivoda 09/03/2021
 */
public class TestFilterRunner extends WildcardPatternSuite {

    public TestFilterRunner(Class<?> klass, RunnerBuilder builder) throws InitializationError {
        super(klass, builder);
        try {
            filter(new TestFilterJunit4());
        } catch (NoTestsRemainException e) {
            // TODO: 09/03/2021 handle this error
            e.printStackTrace();
        }
    }





}
