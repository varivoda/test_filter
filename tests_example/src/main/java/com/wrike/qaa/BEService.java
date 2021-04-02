package com.wrike.qaa;

/**
 * Created by Ivan Varivoda 02/04/2021
 */
public enum BEService {

    LOGIN_SERVICE("Login service"),
    MESSAGE_SERVICE("Message service");

    private String serviceName;

    BEService(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String toString() {
        return serviceName;
    }
}
