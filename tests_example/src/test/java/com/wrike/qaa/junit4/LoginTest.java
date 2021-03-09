package com.wrike.qaa.junit4;

import com.wrike.qaa.Type;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.Test;

/**
 * Created by Ivan Varivoda 07/03/2021
 */
@Epic("Login")
public class LoginTest {

    @Test
    @Feature("Correct credentials")
    public void loginWithCorrectCredentials() {

    }

    @Test
    @Feature("Incorrect credentials")
    public void loginWithIncorrectCredentials() {

    }

    @Test
    @Story("Login screenshot")
    @Type("lala")
    public void loginScreenshotTest() {
        throw new AssertionError();
    }

}
