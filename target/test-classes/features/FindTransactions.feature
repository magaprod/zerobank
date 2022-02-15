Feature: Find Transactions in Account Activity


  Background:
    Given the user is on login page with "username" "password"


  Scenario: Search date range
    When the user accesses the "Find Transactions" tab
    When the user enters date range from "2012-09-01" "2012-09-06"
    Then results table should only show transactions dates between "2012-09-01" "2012-09-06"
    And the results should be sorted by most recent date
    When the user enters date range from "2012-09-02" "2012-09-06"


  Scenario: Search description

    Given the user accesses the "Find Transactions" tab
    When the user enters description "ONLINE"
    Then results table should only show descriptions containing "ONLINE"
    When the user enters description "OFFICE"
      #But result should not show description containing "OFFICE" bunu arasdir??



  Scenario: Search description case insensetive
    Given the user accesses the "Find Transactions" tab
    When the user enters description "ONLINE"
    Then results table should only show descriptions containing "ONLINE"
    When the user enters description "online"
    Then results table should only show descriptions containing "ONLINE"



  Scenario: Type
    Given the user accesses the "Find Transactions" tab
    And clicks find
    Then result table should show at least one result under Deposit
    Then result table should show at least one result under Withdrawal
    When the user selects "Deposit"
    And clicks find
    Then result table should show at least one result under Deposit
    But result table should show no result under Withhdrawal
    When the user selects "Withdrawal"
    And clicks find
    Then result table should show at least one result under Withdrawal
    But result table should show no result under Deposit







