package com.wrike.qaa.adaptor;

/**
 * Created by Ivan Varivoda 06/03/2021
 */
// TODO: 06/03/2021 Тут через интерфейс зайти, чтобы тесты легко писать
public class TestConfig {

    private String filter;

    public String getTestFilter() {
        return "{epic:Login}|{story:notification}";
    }
}
