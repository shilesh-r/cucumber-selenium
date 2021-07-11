package com.automation.demo.pages;

import com.automation.demo.driver.ChromeBrowserDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

@Slf4j
public class GoogleHomePage {

    private static GoogleHomePage instance = null;
    private ChromeBrowserDriver chromeBrowserDriver = ChromeBrowserDriver.getInstance();
    private String googleUrl = "https://www.google.com/";
    private By searchTextBox = By.name("q");

    //Search Button Xpath relative to magnifying glass/lens icon to the left of search box
    private By searchButton = By.xpath("//span[@class='QCzoEc z1asCe MZy1Rb']//ancestor::div[5]//div[@class='FPdoLc lJ9FBc']//input[@value='Google Search']");

    private WebElement searchTextBoxElement;
    private WebElement searchButtonElement;

    public static GoogleHomePage getInstance() {
        if (instance == null) {
            instance = new GoogleHomePage();
        }
        return instance;
    }

    public void navigateToGoogleHomePage() {
        log.info("Navigating to Google Home page");
        chromeBrowserDriver.getDriver().get(googleUrl);
    }

    public void enterSearchText(String searchText) {
        log.info("Entering search text");
        searchTextBoxElement = chromeBrowserDriver.getDriver().findElement(searchTextBox);
        searchTextBoxElement.sendKeys(searchText);
    }

    public void clickOnGoogleSearch(){
        try {
            log.info("Identify and click on Google Search Button");
            searchButtonElement = chromeBrowserDriver.getDriver().findElement(searchButton);
            searchButtonElement.click();
        }
        catch (ElementClickInterceptedException exception) {
            log.info("ElementClickInterceptedException occured possibly due to dynamic search results dropdown shown in front of Google search button");
            if(searchTextBoxElement!=null){
                searchTextBoxElement.sendKeys(Keys.ENTER);
            }
        }
    }
}
