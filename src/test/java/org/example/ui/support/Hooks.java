package org.example.ui.support;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before("@ui")
    public void setUp() {
        DriverFactory.getDriver();
    }

    @After("@ui")
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
