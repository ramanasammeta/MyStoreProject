package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    Action action= new Action();
    @FindBy(id="email")
    private WebElement userName;

    @FindBy(id="passwd")
    private WebElement password;

    @FindBy(id="SubmitLogin")
    private WebElement signInBtn;

    @FindBy(id="email_create")
    private WebElement emailForNewAccount;

    @FindBy(name="SubmitCreate")
    private WebElement createNewAccountBtn;

    public LoginPage(){
        PageFactory.initElements(getDriver(),this);
    }
    public HomePage login(String uName, String pwd) throws Throwable{
        action.type(userName,uName);
        action.type(password,pwd);
        action.click(getDriver(),signInBtn);
        return new HomePage();
    }

    public AddressPage login1(String uName, String pwd) throws Throwable{
        action.type(userName,uName);
        action.type(password,pwd);
        action.click(getDriver(),signInBtn);
        return new AddressPage();
    }
    public AccountCreationPage createNewAccount (String newEmail) throws Throwable{
        action.type(emailForNewAccount,newEmail);
        action.click(getDriver(),createNewAccountBtn);
        return new AccountCreationPage();

    }
}
