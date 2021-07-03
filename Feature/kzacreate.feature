Feature: KZA create new Board

  Background:
    Given I launch chrome browser
    And User enters Email
    Then click Log with in atlassian button
    And User enters Password

  Scenario: Create new Board
    When User Clicks Create new board link
    And User enters new board name
    And create board button
    And click cancel arrow
    Then add list page should be displayed


  Scenario: Add list to the board
      Given I click Test KZA board
      And  enter ToDOList title
      Then  Click ToDoaddlist button
      When I enter InProgress title
      And click Progressaddlist button
      And I enter Done title
      And click cancel button
      Then new lists should be displayed


  Scenario: Add card to the list
        Given User click KZA board
        When  User enter card name
        And   Click add cart button
        And  Click cancel button for add another card
        Then New card we added should be displayed


  Scenario: Update card
    Given User click KZA board
    When User click card
    And  Click move button
    Then Select In Progress from the list
    When User click confirm button
    And Click close button
    Then New card we updated should be displayed

  Scenario: Delete card
    Given User click KZA board
    And Click card
    And Click Archive button
    When User click delete button
    And Click confirm delete button
    Then Card should be deleted

  Scenario:  Delete board
    Given User click KZA board
    And Click show menu button
    Then Click open more button
    When User click close board button
    Then Click confirm close button
    When User click Permanently delete button
    And Click confirm delete buttons
    Then Board should be deleted

