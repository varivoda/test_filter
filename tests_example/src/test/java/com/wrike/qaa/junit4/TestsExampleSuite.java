package com.wrike.qaa.junit4;

import com.googlecode.junittoolbox.SuiteClasses;
import com.wrike.qaa.TestFilterSuite;
import org.junit.runner.RunWith;

/**
 * Created by Ivan Varivoda 21/03/2021
 */
@SuiteClasses({"**/*.class", "!**/TestsExampleSuite.class"})
@RunWith(TestFilterSuite.class)
public class TestsExampleSuite {
}
