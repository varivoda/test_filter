package com.wrike.qaa;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

/**
 * Created by Ivan Varivoda 07/03/2021
 */
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
    @Story("Login screnshot")
    void loginScreenshotTest() {
        throw new AssertionError();
    }

}
