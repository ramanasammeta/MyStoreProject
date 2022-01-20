package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
    Action action= new Action();
    @FindBy(xpath="//span[normalize-space()='My wishlists']")
    private WebElement myWishList;

    @FindBy(xpath="//span[normalize-space()='Order history and details']")
    private WebElement orderHistory;

    public HomePage(){
        PageFactory.initElements(getDriver(), this);

    }
    public boolean validateMyWishList() throws Throwable{
        return action.isDisplayed(getDriver(),myWishList);
    }
    public boolean validateOrderHistory() throws Throwable{
        return action.isDisplayed(getDriver(), orderHistory);
    }
    public String getCurrUrl(){
        String homePagURL=getDriver().getCurrentUrl();
        return homePagURL;
    }

}
