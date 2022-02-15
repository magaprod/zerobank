$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/PurchaseForeignCurrency.feature");
formatter.feature({
  "name": "Purchase Foreign Currency",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user is on login page with \"username\" \"password\"",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.LoginStepDefs.theUserIsOnLoginPageWith(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Error message for not selecting currency",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.step({
  "name": "the user accesses the \"Pay Bills\" tab",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.NavigationMenuDefs.theUserAccessesTheTab(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user passes the \"Purchase Foreign Currency\" tab",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.NavigationMenuDefs.theUserPassesTheTab(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user tries to calculate cost without selecting a currency",
  "keyword": "When "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.NavigationMenuDefs.userTriesToCalculateCostWithoutSelectingACurrency()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the error message on purchase page \"Please, ensure that you have filled all the required fields with valid values.\" should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.NavigationMenuDefs.theErrorMessageOnPurchasePageShouldBeDisplayed(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});