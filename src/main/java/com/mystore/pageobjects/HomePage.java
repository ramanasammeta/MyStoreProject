package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
    @FindBy(xpath="//span[normalize-space()='My wishlists']")
    WebElement myWishList;

    @FindBy(xpath="//span[normalize-space()='Order history and details']")
    WebElement orderHistory;

    public HomePage(){
        PageFactory.initElements(getDriver(), this);

    }
    public boolean validateMyWishList() throws Throwable{
        return Action.isDisplayed(getDriver(),myWishList);
    }
    public boolean validateOrderHistory() throws Throwable{
        return Action.isDisplayed(getDriver(), orderHistory);
    }
    public String getCurrUrl(){
        String homePagURL=getDriver().getCurrentUrl();
        return homePagURL;
    }

}
