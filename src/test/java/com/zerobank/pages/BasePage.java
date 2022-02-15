package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    @FindBy(xpath = "//span[.='Account Summary']")
    public WebElement accountSummaryPage;
    @FindBy(xpath = "//span[.='Account Activity']")
    public WebElement accountActivityPage;
    @FindBy(xpath = "//span[.='Transfer Funds']")
    public WebElement transferFundsPage;
    @FindBy(xpath = "//a[.='Pay Bills']")
    public WebElement payBillsPage;
    @FindBy(xpath = "//span[.='My Money Map']")
    public WebElement moneyMapPage;
    @FindBy(xpath = "//span[.='Online Statements']")
    public WebElement onlineStatements;

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }


}
