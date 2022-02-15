package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PayBillsPage extends BasePage {

    @FindBy(css = "#sp_amount")
    public WebElement amountInpBox;

    @FindBy(css = "#sp_payee")
    public WebElement payeeBox;

    @FindBy(css = "#sp_date")
    public WebElement dateBox;

    @FindBy(css = "#sp_description")
    public WebElement discription;

    @FindBy(css = "#pay_saved_payees")
    public WebElement payBtn;

    @FindBy(xpath = "//div[@id='alert_content']")
    public WebElement greenTxt;
//  public String textGreen=greenTxt.getText();

    @FindBy(xpath = "//li[.='Add New Payee']")
    public WebElement addNewPayee;


    @FindBy(css = "#np_new_payee_name")
    public WebElement payeeName;

    @FindBy(css = "#np_new_payee_address")
    public WebElement payeeAddress;

    @FindBy(css = "#np_new_payee_account")
    public WebElement payeeAccount;

    @FindBy(css = "#np_new_payee_details")
    public WebElement payeeDetails;

    @FindBy(css = "#add_new_payee")
    public WebElement addNPayeeBtn;

    @FindBy(css = "#alert_content")
    public WebElement succesfullBtn;

    @FindBy(xpath = "//a[.='Purchase Foreign Currency']")
    public WebElement purchase;

    @FindBy(name = "currency")
    public List<WebElement> selectCurr;
    public List<String> currencyTxt = BrowserUtils.getElementsText(selectCurr);

    @FindBy(css = "#purchase_cash")
    public WebElement purchaseBtn;

    @FindBy(css = "#pc_calculate_costs")
    public WebElement calcCost;



}