package com.wrike.qaa.testng;

import com.wrike.qaa.TestFilterListener;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by Ivan Varivoda 07/03/2021
 */
@Listeners(value = TestFilterListener.class)
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
