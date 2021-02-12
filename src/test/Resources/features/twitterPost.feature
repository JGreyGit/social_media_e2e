Feature: Ability to post a tweet

  Scenario Outline:
    Given User navigates to url
    When user enter <usrNme> and <PssWrd>
    And user clicks the login button
    Then user is taken to home page with profile displayed
    Then user inserts text into tweet text field and posts tweet


    Examples:
    |usrNme|PssWrd|
    |learnhow2makeup|Joshua123|

