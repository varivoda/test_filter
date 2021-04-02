package com.wrike.qaa.junit4;

import com.wrike.qaa.Service;
import com.wrike.qaa.Type;
import io.qameta.allure.Epic;
import org.junit.Test;

import static com.wrike.qaa.BEService.MESSAGE_SERVICE;

/**
 * Created by Ivan Varivoda 07/03/2021
 */
@Epic("Messages")
public class MessageServiceTest {

    @Test
    @Type("Smoke")
    @Service(MESSAGE_SERVICE)
    public void checkMessageService() {

    }

    @Test
    public void checkWrongMessageService() {

    }
}
