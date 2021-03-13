package com.wrike.qaa;

import com.googlecode.junittoolbox.SuiteClasses;
import org.junit.runner.RunWith;

/**
 * Created by Ivan Varivoda 09/03/2021
 */
@SuiteClasses("**/*Test.class")
@RunWith(TestFilterSuite.class)
public class RunFilteredTests {
}
