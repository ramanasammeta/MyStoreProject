package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchResultsPage extends BaseClass{

    @FindBy(xpath="//a[@title='View']")
    WebElement productResults;

    @FindBy(xpath="//*[@id=\"center_column\"]//img")
    private WebElement productResult;

    public SearchResultsPage(){
        PageFactory.initElements(getDriver(),this);
    }
    public boolean isProductAvailable(){
        return Action.isDisplayed(getDriver(),productResult);
    }
    public AddToCartPage clickOnProduct() throws Throwable{
        Action.fluentWait(getDriver(), productResults, 10);
        Action.JSClick(getDriver(),productResults);
        return new AddToCartPage();

    }

}
