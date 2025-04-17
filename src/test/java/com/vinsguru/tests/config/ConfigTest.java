package com.vinsguru.tests.config;

import com.vinsguru.util.Config;

public class ConfigTest {
    public static void main(String[] args) {
        System.setProperty("browser", "firefox");
        Config.initialize();
        System.out.println(Config.get("selenium.grid.hubHost"));
    }
}
