package com.wrike.qaa.testng;

import com.wrike.qaa.Service;
import com.wrike.qaa.Type;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import static com.wrike.qaa.BEService.MESSAGE_SERVICE;

/**
 * Created by Ivan Varivoda 07/03/2021
 */
@Epic("Messages")
public class MessageServiceTest {

    @Test
    @Type("Smoke")
    @Service(MESSAGE_SERVICE)
    void checkMessageService() {

    }

    @Test
    void checkWrongMessageService() {

    }

}
