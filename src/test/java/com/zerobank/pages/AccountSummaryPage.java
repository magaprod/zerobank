package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountSummaryPage extends BasePage {

    @FindBy(xpath= "//span[.='Account Summary']")
    public WebElement accSummaryBtn;

    @FindBy(xpath= "(//a[.='Savings'])[1]")
    public WebElement savings;

    @FindBy(xpath = "(//div/table)[3]//thead/tr/th")
    public List<WebElement> tableColumnOfCreddit;

    public List<String> tableCloumnCrdtTxt = BrowserUtils.getElementsText(tableColumnOfCreddit);
    @FindBy(xpath = "//div/h2")
    public List<WebElement> accountTypes;
    public List<String> accountTypesTxt = BrowserUtils.getElementsText(accountTypes);

@FindBy(xpath ="//a[.='Brokerage']")
public WebElement brokerage;

public void clickOnCertainLink(String link){

    Driver.get().findElement(By.xpath("//a[.='"+link+"']")).click();
}




}
