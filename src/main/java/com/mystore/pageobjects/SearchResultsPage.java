package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;

public class SearchResultsPage extends BaseClass{

    @FindBy(xpath="//*[@id=\"center_column\"]/ul/li")
    WebElement productResults;

    public SearchResultsPage(){
        PageFactory.initElements(getDriver(),this);
    }
    public boolean isProductAvailable(){
        return Action.isDisplayed(getDriver(),productResults);
    }
    public AddToCartPage clickOnProduct() throws Throwable{
        Action.click(getDriver(),productResults);
        return new AddToCartPage();

    }

}
