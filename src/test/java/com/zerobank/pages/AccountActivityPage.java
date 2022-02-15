package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AccountActivityPage extends BasePage {

    @FindBy(xpath = "//select")
    public WebElement accDrop;
    @FindBy(xpath = "//a[.='Account Activity']")
    public WebElement accountActivityTab;

    @FindBy(xpath = "//input[@id='aa_fromDate']")
    public WebElement fromDate;
    @FindBy(xpath = "//input[@id='aa_toDate']")
    public WebElement toDate;
    @FindBy(xpath = "//button[.='Find']")
    public WebElement findDate;

    @FindBy(xpath = "((//tbody)[2]/tr/td[1])]")
    public List<WebElement> transacTdList;

    @FindBy(xpath = "(//tbody)[2]//tr//td[1]")
    public List<WebElement> transactionDates;

    @FindBy(xpath = "//select")
    public WebElement dropDown;

    @FindBy(css="#aa_description")
    public WebElement descripInput;
    @FindBy(xpath  ="//*[@id='filtered_transactions_for_account']/table/tbody/tr/td[2]")
    List<WebElement> trnscTableRows;
    public List<String> descrpRowsText = BrowserUtils.getElementsText(trnscTableRows);

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']/table/tbody/tr/td[3]")
    public List<WebElement> depositColumn;
    public List<String> depClmnTxt = BrowserUtils.getElementsText(depositColumn);

    @FindBy(xpath = "(//tbody)[2]/tr/td[4]")
    public List<WebElement> withDrawalClmn;
    public List<String> withdrClmnTxt = BrowserUtils.getElementsText(withDrawalClmn);






    //get the texts of dates
     public List<String> datesText = BrowserUtils.getElementsText(transactionDates);

    @FindBy(xpath = "//thead/tr/th")
    List<WebElement> trnscTableHead;

    public List<String> trnscTableHeadTxt = BrowserUtils.getElementsText(trnscTableHead);
    //public List<String> dDownTxt = BrowserUtils.getElementsText(dropDown);
    List<WebElement> AccountDropDown = Driver.get().findElements(By.tagName("select"));

    public List<String> getTextOfDdown(List<WebElement> downs) {
        List<String> originalList = new ArrayList<>();
        for (WebElement webelement : downs) {
            originalList.add(webelement.getText());
        }

        return originalList;
    }

    public void clickOnCertainTab(String tabName) {

        BrowserUtils.waitFor(3);
        Driver.get().findElement(By.xpath("//a[.='" + tabName + "']")).click();


    }

    public void setDateAndFind(String from, String to) {

        BrowserUtils.waitForVisibility(findDate, 5);
        fromDate.sendKeys(from);
        toDate.sendKeys(to);
        BrowserUtils.waitFor(3);
        findDate.click();

    }

    public Date convertDate(String date) {

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

        Date dateFormat = null;
        try {
            dateFormat = fmt.parse(date);

        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return dateFormat;
    }


}
