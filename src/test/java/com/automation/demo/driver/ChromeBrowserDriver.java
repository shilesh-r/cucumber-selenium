package com.automation.demo.driver;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Slf4j
public class ChromeBrowserDriver {
    private static ChromeBrowserDriver instance = null;

    public static ChromeBrowserDriver getInstance() {
        if (instance == null) {
            instance = new ChromeBrowserDriver();
        }
        return instance;
    }

    @Getter
    private WebDriver driver;

    public void launchBrowser() {
        //Closes current browser session to start afresh
        if (driver != null) {
            endSession();
        }
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endSession() {
        driver.quit();
    }
}
