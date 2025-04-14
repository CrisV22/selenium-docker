package com.vinsguru.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.vinsguru.util.ChromeDriverOptions;

public abstract class AbstractTest {

    protected WebDriver driver;

    @BeforeTest
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver(ChromeDriverOptions.getChromeDriverOptions());
    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }

}