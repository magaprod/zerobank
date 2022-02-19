package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//made some rows from LoginPage
public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement userName;

    @FindBy(id="signin_button")
    public WebElement signIn;

    @FindBy(xpath="//input[@id='user_password']")
    public WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submit;

    @FindBy(xpath = "//div/button[.='Back to safety']")
    public  WebElement backToSafety;

    @FindBy(xpath = "//a[.='More Services']")
    public WebElement moreservices;

    @FindBy(xpath = "(//*[contains(text(),'Login')])[1]")
    public WebElement errorMsgWrngPass;




    public LoginPage() {PageFactory.initElements(Driver.get(), this);
    }
    public void login(String userNameStr, String passwordStr) {
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        submit.click();
        // verification that we logged
    }

//    public String actlErrorMsgTxt=errorMsgWrngPass.getText();

}
