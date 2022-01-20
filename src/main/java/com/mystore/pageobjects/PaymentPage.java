package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BaseClass {
    Action action= new Action();
    @FindBy(xpath="//a[@title='Pay by bank wire']")
    private WebElement bankWireMethod;

    @FindBy(xpath="//a[@title='Pay by check.']")
    private WebElement payByCheckMethod;

    public PaymentPage(){
        PageFactory.initElements(getDriver(),this);
    }
    public OrderSummaryPage clickOnPaymentMethod() throws Throwable{
        action.click(getDriver(),bankWireMethod);
        return new OrderSummaryPage();
    }

}
