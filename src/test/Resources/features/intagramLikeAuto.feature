Feature: Using Instagram Liking Functionality


  Scenario Outline:
    Given user enters correct <username>
    Then user types <password>
    And user clicks on Sign In button
    Then use is taken to instagram Home page with logo displayed
    When user inserts in search field a <hashtag>
    And navigates to <hashtag>
    Then is able to like multiple posts from collection



    Examples:
      | username |password| hashtag|
      |humansofunny|Joshua123*|#funnymeme|
      |humansofunny|Joshua123*|#loveyourself|








