package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BaseClass {
    @FindBy(xpath="//a[@title='Pay by bank wire']")
    WebElement bankWireMethod;

    @FindBy(xpath="//a[@title='Pay by check.']")
    WebElement payByCheckMethod;

    public PaymentPage(){
        PageFactory.initElements(getDriver(),this);
    }
    public OrderSummaryPage clickOnPaymentMethod() throws Throwable{
        Action.click(getDriver(),bankWireMethod);
        return new OrderSummaryPage();
    }

}
