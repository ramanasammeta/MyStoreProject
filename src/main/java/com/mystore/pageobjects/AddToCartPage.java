package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends BaseClass {
    Action action= new Action();
    @FindBy(id="quantity_wanted")
    private WebElement quantity;

    @FindBy(id="group_1")
    private WebElement size;

    @FindBy(xpath="//span[text()='Add to cart']")
    private WebElement addToCartBtn;

    @FindBy(xpath="//h2[normalize-space()='Product successfully added to your shopping cart']")
    private WebElement addToCartMsg;

    @FindBy(xpath="//span[normalize-space()='Proceed to checkout']")
    private WebElement proceedToCheckOutBtn;


    public AddToCartPage(){
        PageFactory.initElements(getDriver(),this);
    }
    public void enterQuantity(String qty) throws Throwable{
        action.type(quantity,qty);
    }
    public void selectSize(String sizeVal) throws Throwable {
        action.selectByVisibleText(sizeVal,size);
    }
    public void clickOnAddToCart() throws Throwable{

        action.click(getDriver(),addToCartBtn);
    }
    public boolean validateAddToCart(){
        action.fluentWait(getDriver(),addToCartMsg,10);
        return action.isDisplayed(getDriver(),addToCartMsg);
    }
    public OrderPage clickOnCheckOut() {
        action.fluentWait(getDriver(),proceedToCheckOutBtn,10);
        action.JSClick(getDriver(), proceedToCheckOutBtn);
        return new OrderPage();
    }
}
