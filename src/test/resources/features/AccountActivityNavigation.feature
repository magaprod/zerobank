Feature: Navigating to specific accounts in Accounts Activity


  Background:
    Given the user is on login page with "username" "password"

  Scenario: Brokerage account redirect

    When the user clicks on "Brokerage" link on the Account Summary
    Then  the "Zero - Account Activity" page should be displayed
    And Account drop down should have "Brokerage" selected


  Scenario: Checking account redirect

    When the user clicks on "Checking" link on the Account Summary
    Then  the "Zero - Account Activity" page should be displayed
    And Account drop down should have "Checking" selected


  Scenario: Credit card account redirect

    When the user clicks on "Credit Card" link on the Account Summary
    Then  the "Zero - Account Activity" page should be displayed
    And Account drop down should have "Credit Card" selected


  Scenario: Loan account redirect

    When the user clicks on "Loan" link on the Account Summary
    Then  the "Zero - Account Activity" page should be displayed
    And Account drop down should have "Loan" selected



  Scenario: Account Activity tables and columns check

    Given the user accesses the "Account Activity" tab
    Then the "Zero - Account Activity" page should be displayed
    And Account drop down should have "Savings" selected
    Then Account dropdown list should have followings
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |

    And transactions table head should have following column names
    |Date|
    |Description|
    |Deposit|
    |Withdrawal|


    Scenario: Paybills page valid complete

      Given the user accesses the "Pay Bills" tab
      Then the "Zero - Pay Bills" page should be displayed
      When the user completes a successfull pay operation
      And "The payment was successfully submitted." should be displayed



      Scenario: Paybills page invalid complete

        Given the user accesses the "Pay Bills" tab
        Then the "Zero - Pay Bills" page should be displayed
        When the user try to make a payment without entering date and amount
    And "Please fill in this field." displayed

