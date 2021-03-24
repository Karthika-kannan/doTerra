Feature: Login Feature

  Scenario Outline: This is login test with valid credentials
    Given User navigates to the login page
    When User enters <username> and <password>
    And Clicks on login button
    Then User is taken to the home page
    
   Examples:
     | username | password |
     | karthika.kanan@gmail.com | g+ZjxHd6AT1MIrRNwtUFVw== |
