package com.zerobank.stepdefinitions;

import com.github.javafaker.Faker;
import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class NavigationMenuDefs {

    @When("the user clicks on Savings link on the Account Summary")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary() {
        new AccountSummaryPage().savings.click();
        BrowserUtils.waitFor(3);

    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String expectedTitle) {

        String acctualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle, acctualTitle);
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String expectedDrop) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();

        BrowserUtils.waitForVisibility(accountActivityPage.accDrop, 7);
        Select select = new Select(accountActivityPage.accDrop);
        String acctualdrop = select.getFirstSelectedOption().getText();
        Assert.assertEquals("verify dropdown is what we need", expectedDrop, acctualdrop);
        System.out.println(acctualdrop);

    }


    @When("the user clicks on {string} link on the Account Summary")
    public void theUserClicksOnLinkOnTheAccountSummary(String linkName) {
        new AccountSummaryPage().clickOnCertainLink(linkName);
    }


    @When("the user accesses the {string} tab")
    public void theUserAccessesTheTab(String tabName) {

        AccountActivityPage accountActivityPage = new AccountActivityPage();
        BrowserUtils.waitForPageToLoad(10);
        accountActivityPage.accountActivityTab.click();
        BrowserUtils.waitForPageToLoad(10);
        accountActivityPage.clickOnCertainTab(tabName);
    }

    @When("the user enters date range from {string} {string}")
    public void theUserEntersDateRangeFrom(String from, String to) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.setDateAndFind(from, to);
        BrowserUtils.waitFor(10);


    }


    @Then("results table should only show transactions dates between {string} {string}")
    public void resultsTableShouldOnlyShowTransactionsDatesBetween(String from, String to) {

        AccountActivityPage accountActivityPage = new AccountActivityPage();
        // convert the given parameters to date format using the method in the page
        Date startDate = accountActivityPage.convertDate(from);//2012-09-01
        Date endDate = accountActivityPage.convertDate(to); //2012-09-06

        List<String> elementsText = BrowserUtils.getElementsText(accountActivityPage.transactionDates);

        //for each date text in the list
        for (String date : elementsText) {
            //convert it to date format
            Date actualDate = accountActivityPage.convertDate(date);
            //use compareTo method which compares to date
            //if it is less than the other date, means it is before than that day
            Assert.assertTrue(actualDate.compareTo(startDate) >= 0);
            Assert.assertTrue(actualDate.compareTo(endDate) <= 0);
        }


    }

    @And("the results should be sorted by most recent date")
    public void theResultsShouldBeSortedByMostRecentDate() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Date date = new Date();


    }

    @Then("the error message {string} should be displayed")
    public void theErrorMessageShouldBeDisplayed(String expcErrorMsg) {

        BrowserUtils.waitFor(5);
        String actlErrorMsgTxt = new LoginPage().errorMsgWrngPass.getText();
        Assert.assertEquals("verify error msg displayed", expcErrorMsg, actlErrorMsgTxt);


    }

    @Then("account summary page should have following account types")
    public void accountSummaryPageSchouldHaveFollowingAccountTypes(List<String> exAccTypes) {

        Assert.assertEquals("verify account types are equal", exAccTypes, new AccountSummaryPage().accountTypesTxt);


    }

    @And("credit account table must have following columns")
    public void creditAccountTableMustHaveFollowingColumns(List<String> expcClmnCrAcc) {
        Assert.assertEquals("verify columns  are equal", expcClmnCrAcc, new AccountSummaryPage().tableCloumnCrdtTxt);


    }

    @Then("Account dropdown list should have followings")
    public void accountDropdownListShouldHaveFollowings(List<String> expcDropList) {


        AccountActivityPage accountActivityPage = new AccountActivityPage();

        BrowserUtils.waitForClickablility(accountActivityPage.dropDown, 7);
        Select select = new Select(accountActivityPage.dropDown);

        List<WebElement> originalListElements = select.getOptions();
        List<String> forHere = accountActivityPage.getTextOfDdown(originalListElements);

        Assert.assertFalse("verify that they are not equal", expcDropList.equals(forHere));

    }

    @Given("the user is on Account Activity page")
    public void theUserIsOnAccountActivityPage() {


    }

    @And("transactions table head should have following column names")
    public void transactionsTableHeadShouldHaveFollowingColumnNames(List<String> expHeadName) {

        AccountActivityPage accountActivityPage = new AccountActivityPage();

        Assert.assertEquals("verify transc table heads", expHeadName, accountActivityPage.trnscTableHeadTxt);


    }

    @When("the user completes a successfull pay operation")
    public void theUserCompletesASuccessfullPayOperation() {
        Faker fake = new Faker();
        PayBillsPage payBillsPage = new PayBillsPage();
        BrowserUtils.waitForVisibility(payBillsPage.amountInpBox, 5);
        payBillsPage.amountInpBox.sendKeys(fake.number().digits(100));
        BrowserUtils.waitForVisibility(payBillsPage.dateBox, 5);
        payBillsPage.dateBox.sendKeys("2022-09-06");
        payBillsPage.payBtn.click();


    }

    @And("{string} should be displayed")
    public void shouldBeDisplayed(String exGreenMsg) {

        PayBillsPage payBillsPage = new PayBillsPage();
        BrowserUtils.waitFor(10);
        // Assert.assertEquals("verify green verify msg", exGreenMsg, payBillsPage.textGreen);

    }

    @When("the user try to make a payment without entering date and amount")
    public void theUserTryToMakeAPaymentWithoutEnteringDateAndAmount() {
        Faker fake = new Faker();
        PayBillsPage payBillsPage = new PayBillsPage();
//        payBillsPage.dateBox.sendKeys("2022-09-06");
        BrowserUtils.waitFor(5);
        payBillsPage.payBtn.click();
        BrowserUtils.waitFor(5);
        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        WebElement field = Driver.get().findElement(By.cssSelector("input[name='amount']"));
        String actualMessage = (String) js.executeScript("return arguments[0].validationMessage;", field);
        Assert.assertEquals("Please fill in this field.", actualMessage);


    }

    @And("{string} displayed")
    public void displayed(String expAlerMsg) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        WebElement field = Driver.get().findElement(By.cssSelector("input[name='amount']"));
        String actualMessage = (String) js.executeScript("return arguments[0].validationMessage;", field);
        Assert.assertEquals(expAlerMsg, actualMessage);


    }

    @When("the user enters description {string}")
    public void theUserEntersDescription(String str) {

        BrowserUtils.waitFor(4);
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.descripInput.sendKeys(str);
        accountActivityPage.findDate.click();

    }

    @Then("results table should only show descriptions containing {string}")
    public void resultsTableShouldOnlyShowDescriptionsContaining(String expectedDescp) {

        AccountActivityPage accountActivityPage = new AccountActivityPage();

        for (String s : accountActivityPage.descrpRowsText) {
            Assert.assertTrue(s.contains(expectedDescp));

        }
        BrowserUtils.waitFor(5);
        System.out.println(" = " + accountActivityPage.descrpRowsText);

    }


    @Then("result table should show at least one result under Deposit")
    public void resultTableShouldShowAtLeastOneResultUnderDeposit() {

        BrowserUtils.waitFor(3);
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        System.out.println("accountActivityPage.depClmnTxt.size() = " + accountActivityPage.depClmnTxt.size());

        System.out.println("accountActivityPage.depClmnTxt = " + accountActivityPage.depClmnTxt);


        int count = 0;
        String inside = "";
        for (String s : accountActivityPage.depClmnTxt) {

            if (!s.equals(inside)) {
                count++;
            }

        }

        Assert.assertTrue(count >= 1);


    }

    @And("clicks find")
    public void clicksFind() {


        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.findDate.click();
        BrowserUtils.waitFor(4);
    }

    @Then("result table should show at least one result under Withdrawal")
    public void resultTableShouldShowAtLeastOneResultUnderWithdrawal() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        BrowserUtils.waitFor(4);
        int count = 0;
        String inside = "";
        for (String s : accountActivityPage.withdrClmnTxt) {

            if (!s.equals(inside)) {
                count++;
            }

        }

        Assert.assertTrue(count >= 1);

        System.out.println("result table should show at least one result under Withdrawal column " + accountActivityPage.withdrClmnTxt);
    }

    @When("the user selects {string}")
    public void theUserSelects(String type) {
        WebElement typeDdown = Driver.get().findElement(By.cssSelector("#aa_type"));
        Select select = new Select(typeDdown);
        select.selectByVisibleText(type);


    }

    @But("result table should show no result under Withhdrawal")
    public void resultTableShouldShowNoResultUnderWithhdrawal() {

        AccountActivityPage accountActivityPage = new AccountActivityPage();
        int count = 0;
        String inside = "";
        for (String s : accountActivityPage.withdrClmnTxt) {

            if (!s.equals(inside)) {
                count++;
            }

        }

        Assert.assertTrue(count == 0);
        System.out.println("accountActivityPage.withdrClmnTxt.size() = " + accountActivityPage.withdrClmnTxt.size());

    }

    @But("result table should show no result under Deposit")
    public void resultTableShouldShowNoResultUnderDeposit() {

        AccountActivityPage accountActivityPage = new AccountActivityPage();
        int count = 0;
        String inside = "";
        for (String s : accountActivityPage.depClmnTxt) {

            if (!s.equals(inside)) {
                count++;
            }

        }

        Assert.assertTrue(count == 0);
        System.out.println("accountActivityPage.depClmnTxt.size() = " + accountActivityPage.depClmnTxt.size());
    }

    @Given("Add New Payee tab")
    public void addNewPayeeTab() {
        BrowserUtils.waitFor(3);
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.payBillsPage.click();
        BrowserUtils.waitForClickablility(payBillsPage.addNewPayee, 5);
        payBillsPage.addNewPayee.click();


    }


    @And("creates new payee using following information")
    public void createsNewPayeeUsingFollowingInformation(Map<String, String> userinfo) {
        System.out.println("userinfo = " + userinfo);
        BrowserUtils.waitFor(3);
        PayBillsPage payBillsPage = new PayBillsPage();


        payBillsPage.payeeName.sendKeys(userinfo.get("Payee Name"));
        payBillsPage.payeeAddress.sendKeys(userinfo.get("Payee Address"));
        payBillsPage.payeeAccount.sendKeys(userinfo.get("Account"));
        payBillsPage.payeeDetails.sendKeys(userinfo.get("Payee details"));
        payBillsPage.addNPayeeBtn.click();




    }


    @Then("the message should be displayed following message {string}")
    public void theMessageShouldBeDisplayedFollowingMessage(String expMsg) {
        PayBillsPage payBillsPage = new PayBillsPage();
        String acctualMsg = new PayBillsPage().succesfullBtn.getText();

        Assert.assertEquals("verify message",expMsg,acctualMsg);


    }

    @When("the user passes the {string} tab")
    public void theUserPassesTheTab(String target ) {
        BrowserUtils.waitFor(5);

        new AccountActivityPage().clickOnCertainTab(target);



    }

    @Then("following currencies should be available")
    public void followingCurrenciesShouldBeAvailable(List<String>exdropDown) {
        BrowserUtils.waitFor(3);
        PayBillsPage payBillsPage=new PayBillsPage();
        System.out.println("payBillsPage.currencyTxt = " + payBillsPage.currencyTxt);
        Assert.assertTrue(payBillsPage.currencyTxt.retainAll(exdropDown));

    }
    @When("user tries to calculate cost without selecting a currency")
    public void userTriesToCalculateCostWithoutSelectingACurrency() {
        BrowserUtils.waitForClickablility(new PayBillsPage().purchaseBtn,5);
        new PayBillsPage().calcCost.click();
        Alert alert = Driver.get().switchTo().alert();
        String alertText =alert.getText();
        BrowserUtils.waitFor(5);
        System.out.println("alertText = " + alertText);
    }

    @Then("the error message on purchase page {string} should be displayed")
    public void theErrorMessageOnPurchasePageShouldBeDisplayed(String expMsg) {
        Alert alert = Driver.get().switchTo().alert();
        String alertText =alert.getText();
        BrowserUtils.waitFor(5);
        System.out.println("alertText = " + alertText);
        Assert.assertEquals("verify error msh",expMsg,alertText);

    }
}
