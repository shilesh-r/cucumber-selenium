package com.automation.demo.pages;

import com.automation.demo.driver.ChromeBrowserDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String, String> getSearchResults(String nthResult) {
        Map<String, String> searchResultDetails = new LinkedHashMap<>();
        searchResultReference = String.format(searchResultReference, nthResult);

        searchResultDetails.put("Result Title", chromeBrowserDriver.getDriver().findElement(By.xpath(searchResultReference + "/div[1]/a/h3")).getText());
        searchResultDetails.put("Result Title HyperLink", chromeBrowserDriver.getDriver().findElement(By.xpath(searchResultReference + "/div[1]/a")).getAttribute("href"));
        searchResultDetails.put("Result Description", chromeBrowserDriver.getDriver().findElement(By.xpath(searchResultReference + "/div[2]/div/span")).getText());

        //Additional links in result
        try {
            List<WebElement> resultLinks = chromeBrowserDriver.getDriver().findElements(By.xpath(searchResultReference + "/div[2]//a"));
            for (int index = 0; index < resultLinks.size(); index++) {
                searchResultDetails.put("Result Additional link " + (index + 1), resultLinks.get(index).getText() + " " + resultLinks.get(index).getAttribute("href"));
            }
        } catch (Exception ex) {
            log.info("Additional Links are not shown as part of this result");
        }

        return searchResultDetails;
    }
}
