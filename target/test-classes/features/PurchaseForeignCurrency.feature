Feature: Purchase Foreign Currency


  Background:
    Given the user is on login page with "username" "password"


  Scenario: Available currencies
    Given  the user accesses the "Pay Bills" tab
    When the user passes the "Purchase Foreign Currency" tab
    Then following currencies should be available
      | Australia(dollar)    |
      | Canada(dollar)       |
      | Switzerland(franc)   |
      | China (yuan)         |
      | Denmark(euro)        |
      | Eurozone(euro)       |
      | Great Britain(pound) |
      | Japan(yen)           |
      | Mexico(peso)         |
      | Norway(krone)        |
      | New Zealand(dollar)  |
      | Singapur(dollar)     |

@wip
    Scenario: Error message for not selecting currency
    Given  the user accesses the "Pay Bills" tab
      Given the user passes the "Purchase Foreign Currency" tab
      When user tries to calculate cost without selecting a currency
      Then the error message on purchase page "Please, ensure that you have filled all the required fields with valid values." should be displayed


