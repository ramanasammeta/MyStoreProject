package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends BaseClass {
    @FindBy(xpath="//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckOut;

    public AddressPage(){
        PageFactory.initElements(getDriver(),this);
    }
    public ShippingPage clickOnCheckOut() throws Throwable{

        Action.click(getDriver(),proceedToCheckOut);
        return new ShippingPage();
    }
}
