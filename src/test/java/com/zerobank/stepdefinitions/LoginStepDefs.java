package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

public class LoginStepDefs {



    @Given("the user is on login page with {string} {string}")
    public void theUserIsOnLoginPageWith(String username, String password) {
        String url = ConfigurationReader.get("url");

        LoginPage loginPage = new LoginPage();
        Driver.get().navigate().to(url);
        BrowserUtils.waitFor(3);

        loginPage.signIn.click();
        new LoginPage().login(username,password);
        Driver.get().navigate().back();
        BrowserUtils.waitFor(2);
        loginPage.moreservices.click();
        BrowserUtils.waitFor(3);
        new AccountSummaryPage().accSummaryBtn.click();


    }


    @When("the user is on login page with invalid {string} {string}")
    public void theUserIsOnLoginPageWithInvalid(String userN, String passW) {
        String url = ConfigurationReader.get("url");
        LoginPage loginPage = new LoginPage();
        Driver.get().navigate().to(url);
        BrowserUtils.waitFor(5);
        loginPage.signIn.click();
        new LoginPage().login(userN,passW);
        //Driver.get().navigate().back();
        BrowserUtils.waitForVisibility(new LoginPage().errorMsgWrngPass,6);
    }



}
