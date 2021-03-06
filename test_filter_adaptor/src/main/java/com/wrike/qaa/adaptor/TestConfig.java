package com.wrike.qaa.adaptor;

/**
 * Created by Ivan Varivoda 06/03/2021
 */
// TODO: 06/03/2021 Тут через интерфейс зайти, чтобы тесты легко писать
public class TestConfig {

    public String getTestFilter() {
        return System.getProperty("test.filter");
    }
}
