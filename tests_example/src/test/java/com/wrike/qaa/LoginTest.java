package com.wrike.qaa;

import com.wrike.adaptor.TestFilterExecutionCondition;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Created by Ivan Varivoda 07/03/2021
 */
@ExtendWith(TestFilterExecutionCondition.class)
@Epic("Login")
public class LoginTest {

    @Test
    @Feature("Correct credentials")
    void loginWithCorrectCredentials() {

    }

    @Test
    @Feature("Incorrect credentials")
    void loginWithIncorrectCredentials() {

    }

    @Test
    @Story("Login screenshot")
    void loginScreenshotTest() {
        throw new AssertionError();
    }

}
