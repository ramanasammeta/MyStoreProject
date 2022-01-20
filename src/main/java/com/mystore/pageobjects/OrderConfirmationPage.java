package com.mystore.pageobjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends BaseClass {

    @FindBy(xpath="//strong[normalize-space()='Your order on My Store is complete.']")
    private WebElement confirmMsg;

    public OrderConfirmationPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public String validateConfirmMessage(){
        String cnfMsg=confirmMsg.getText();
        return cnfMsg;

    }
}
