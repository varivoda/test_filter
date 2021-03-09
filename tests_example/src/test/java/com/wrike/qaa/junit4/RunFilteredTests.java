package com.wrike.qaa.junit4;

import com.googlecode.junittoolbox.SuiteClasses;
import com.wrike.qaa.TestFilterRunner;
import org.junit.runner.RunWith;

/**
 * Created by Ivan Varivoda 09/03/2021
 */
@SuiteClasses("**/*Test.class")
@RunWith(TestFilterRunner.class)
public class RunFilteredTests {
}
