package com.wrike.qaa.testng;

import com.wrike.qaa.Type;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

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
