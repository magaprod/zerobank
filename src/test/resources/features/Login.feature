Feature: User should be able to login


  Scenario:Login compleated
    Given the user is on login page with "username" "password"
    When  the user clicks on Savings link on the Account Summary
    Then  the "Zero - Account Activity" page should be displayed
    And Account drop down should have "Savings" selected


  Scenario: Login with valid credentials
    Given the user is on login page with "username" "password"
    Then the "Zero - Account Summary" page should be displayed


  Scenario: Login with invalid credentials
    When the user is on login page with invalid "username5" "password6"
    Then the error message "Login and/or password are wrong." should be displayed