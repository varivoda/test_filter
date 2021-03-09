package com.wrike.qaa;

import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;

/**
 * Created by Ivan Varivoda 09/03/2021
 */
public class TestFilter extends Filter {

    @Override
    public boolean shouldRun(Description description) {
        System.out.println("Я тут был");
        return true;
    }

    @Override
    public String describe() {
        return null;
    }
}
