Feature: User should be able to login with valid credential and user should not be
  able to login with invalid credential.

  Scenario Outline: Login Data Driven
    Given User Launch Chrome Browser with URL
    And User Enters Email as "<email>" and Password as "<password>"
    And Click on Login
    Then HomePage should be displayed
    When User Click on Logout link
    Then Close Browser


    Examples:
      |email | password|
      |ustel1111@gmail.com| Freeuyghur22@@|
      |admin1@yourstore.com | admin123|
