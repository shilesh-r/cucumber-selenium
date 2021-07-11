package com.automation.demo.pages;

import com.automation.demo.driver.ChromeBrowserDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class SearchResultsPage {

    private static SearchResultsPage instance = null;
    private ChromeBrowserDriver chromeBrowserDriver = ChromeBrowserDriver.getInstance();
    private WebDriverWait webDriverWait;
    private By searchResults = By.xpath("(//h2[contains(text(),'Web results')])[1]");
    private String searchResultReference = "(//div[@class='tF2Cxc'])[%s]";

    public static SearchResultsPage getInstance() {
        if (instance == null) {
            instance = new SearchResultsPage();
        }
        return instance;
    }

    public boolean isSearchResultsDisplayed() {
        try {
            log.info("Awaiting search results display");
            webDriverWait = new WebDriverWait(chromeBrowserDriver.getDriver(), 5);
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(searchResults));
            return true;
        } catch (Exception ex) {
            log.info("Exception occured. Search Results not displayed");
            return false;
        }
    }
}
