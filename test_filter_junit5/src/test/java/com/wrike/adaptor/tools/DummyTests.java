package com.wrike.adaptor.tools;

import com.wrike.adaptor.TestFilterExecutionCondition;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Created by Ivan Varivoda 06/03/2021
 */
@ExtendWith(TestFilterExecutionCondition.class)
public class DummyTests {

    @Test
    @Epic("e1")
    @Feature("f1")
    @Story("s1")
    public void e1f1s1() {
    }

    @Test
    @Epic("e2")
    @Feature("f2")
    @Story("s2")
    public void e2f2s2() {
    }

    @Test
    @Epic("e3")
    @Feature("f3")
    @Story("s3")
    public void e3f3s3() {
    }

    @Test
    @Epic("e1")
    public void e1() {
    }

}
