package com.vinsguru.util;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverOptions {
    public static ChromeOptions getChromeDriverOptions() {
        ChromeOptions options = new ChromeOptions();

//        options.addArguments("--headless");
        options.addArguments("--incognito");
        options.addArguments("--disable-extensions");
//        options.addArguments("window-size=1920,1080");
//        options.addArguments("--start-fullscreen");
//        options.addArguments("--disable-gpu");
//        options.addArguments("--blink-settings=imagesEnabled=false");

        return options;
    }
}
