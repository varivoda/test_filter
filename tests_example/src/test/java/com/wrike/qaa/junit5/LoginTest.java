package com.wrike.qaa.junit5;

import com.wrike.qaa.Type;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
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
    @Type("Screenshot")
    void loginScreenshotTest() {
        throw new AssertionError();
    }

}
