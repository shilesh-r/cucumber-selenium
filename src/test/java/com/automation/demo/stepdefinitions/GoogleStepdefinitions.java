package com.automation.demo.stepdefinitions;

import com.automation.demo.driver.ChromeBrowserDriver;
import com.automation.demo.pages.GoogleHomePage;
import com.automation.demo.pages.SearchResultsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.Map;

@Slf4j
public class GoogleStepdefinitions {

    private ChromeBrowserDriver chromeBrowserDriver;
    private GoogleHomePage googleHomePage;
    private SearchResultsPage searchResultsPage;

    @Before
    public void setUp() {
        chromeBrowserDriver = ChromeBrowserDriver.getInstance();
        googleHomePage = GoogleHomePage.getInstance();
        searchResultsPage = SearchResultsPage.getInstance();
    }

    @After
    public void tearDown() {
        chromeBrowserDriver.endSession();
    }

    @Given("User launches a browser")
    public void userLaunchesABrowser() {
        chromeBrowserDriver.launchBrowser();
    }

    @And("User navigates to Google home page")
    public void userNavigatesToGoogleHomePage() {
        googleHomePage.navigateToGoogleHomePage();
    }

    @And("User enters search text as {string}")
    public void userEntersSearchTextAs(String searchText) {
        googleHomePage.enterSearchText(searchText);
    }

    @When("User clicks on Google Search button")
    public void userClicksOnGoogleSearchButton() {
        googleHomePage.clickOnGoogleSearch();
    }

    @Then("Search Results is displayed")
    public void searchResultsIsDisplayed() {
        Assert.assertTrue("Search Results are not displayed", searchResultsPage.isSearchResultsDisplayed());
    }

    @And("Test retrieves details of {string} result")
    public void testRetrievesFirstResultsDetails(String nthResult) {
        Map<String, String> searchResults = searchResultsPage.getSearchResults(nthResult);
        log.info("Search Result Details: ");
        for (String resultDetail : searchResults.keySet()) {
            log.info("{} : {}", resultDetail, searchResults.get(resultDetail));
        }
    }
}
