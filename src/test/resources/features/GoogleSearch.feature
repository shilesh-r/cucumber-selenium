@GoogleSearch
Feature: Google Search

  @FetchFirstResults
  Scenario: Perform Google search and fetch first results
    Given User launches a browser
    And User navigates to Google home page
    And User enters search text as "Jack Reacher By Lee Child"
    When User clicks on Google Search button
    Then Search Results is displayed
    And Test retrieves details of "1" result