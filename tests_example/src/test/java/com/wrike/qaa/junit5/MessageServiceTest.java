package com.wrike.qaa.junit5;

import com.wrike.qaa.Service;
import com.wrike.qaa.Type;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Test;

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
