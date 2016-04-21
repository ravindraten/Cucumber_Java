Feature: Is the user able to perform a valid search

  Scenario: Launch the Fiori url with the given username and perform a Search on term "SAP"
    Given I am on the Fiori homepage
    When I Click on Search Button , I Enter a Search Term SAP, the search field, Hit Search Button
    Then I should see the search Results

  Scenario: Launch the Fiori url and then logout
    Given I am on Fiori Homepage
    When I Click on logout Button
    Then I should see a pop up and click on OK to be logged out of the system
