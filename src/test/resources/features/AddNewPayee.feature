Feature: Add new payee


  Scenario Outline: Add a new payee
    Given the user is on login page with "username" "password"
    Given Add New Payee tab
    And creates new payee using following information
      | Payee Name    | <Payee Name>    |
      | Payee Address | <Payee Address> |
      | Account       | <Account>       |
      | Payee details | <Payee details> |

    And  the message should be displayed following message "The new payee The Law Offices of Hyde,Price & Scharks was successfully created."

    Examples:
      | Payee Name                              | Payee Address                 | Account  | Payee details |
      | The Law Offices of Hyde,Price & Scharks | 100 Same st,Anytown,USA,10001 | Checking | XYZ account   |








