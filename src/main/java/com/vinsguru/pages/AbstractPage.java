package com.vinsguru.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public abstract class AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(AbstractPage.class);
    protected final WebDriver driver;
    protected FluentWait<WebDriver> wait;

    public AbstractPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(Exception.class);
    }

    public void scrollToPageBottomUntilElementClickable(WebElement targetElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int maxTries = 20;
        int attempts = 0;

        while (attempts < maxTries) {
            try {
                 js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

                Thread.sleep(200);

                if (targetElement.isDisplayed() && targetElement.isEnabled()) {
                    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", targetElement);
                    targetElement.click();
                    return;
                }
            } catch (Exception ignored) {
                log.info("N° of attempts: {}", attempts);
            }

            attempts++;
        }

        throw new RuntimeException("Element was not clickable after scrolling " + maxTries + " times.");
    }

    // Automation waits for one-page element to be visible to know the hole page was loaded and start the actions and asserts.
    public abstract boolean isAt();

}