Feature: Account Summary Navigations


  Scenario: Checking Account Types on Activity Page
    Given the user is on login page with "username" "password"
    And  the "Zero - Account Summary" page should be displayed
    Then account summary page should have following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

    And credit account table must have following columns
      | Account     |
      | Credit Card |
      | Balance     |
