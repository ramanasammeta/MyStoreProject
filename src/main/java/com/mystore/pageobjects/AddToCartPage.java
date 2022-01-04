package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends BaseClass {
    @FindBy(id="quantity_wanted")
    WebElement quantity;

    @FindBy(id="group_1")
    WebElement size;

    @FindBy(xpath="//span[text()='Add to cart']")
    WebElement addToCartBtn;

    @FindBy(xpath="//h2[normalize-space()='Product successfully added to your shopping cart']")
    WebElement addToCartMsg;

    @FindBy(xpath="//span[normalize-space()='Proceed to checkout']")
    WebElement proceedToCheckOutBtn;


    public AddToCartPage(){
        PageFactory.initElements(getDriver(),this);
    }
    public void enterQuantity(String qty) throws Throwable{
        Action.type(quantity,qty);
    }
    public void selectSize(String sizeVal) throws Throwable {
        Action.selectByVisibleText(sizeVal,size);
    }
    public void clickOnAddToCart() throws Throwable{

        Action.click(getDriver(),addToCartBtn);
    }
    public boolean validateAddToCart(){
        Action.fluentWait(getDriver(),addToCartMsg,10);
        return Action.isDisplayed(getDriver(),addToCartMsg);
    }
    public OrderPage clickOnCheckOut() {
        Action.fluentWait(getDriver(),proceedToCheckOutBtn,10);
        Action.JSClick(getDriver(), proceedToCheckOutBtn);
        return new OrderPage();
    }
}
