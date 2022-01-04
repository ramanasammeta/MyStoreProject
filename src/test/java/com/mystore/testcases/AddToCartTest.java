package com.mystore.testcases;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultsPage;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseClass {
    IndexPage indexPg;
    SearchResultsPage SearchrsltPg;
    AddToCartPage addToCartPg;
    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(String browser){
        launchApp(browser);
    }
    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown(){
        getDriver().quit();
    }

    @Test(groups = {"Regression","Sanity"}, dataProvider = "getProduct", dataProviderClass = DataProviders.class)
    public void addToCartTest(String productName, String qty, String size) throws Throwable {
        Log.startTestCase("addToCartTest");
        indexPg=new IndexPage();
        SearchrsltPg=indexPg.searchProduct(productName);
      addToCartPg=SearchrsltPg.clickOnProduct();
        addToCartPg.enterQuantity(qty);
        addToCartPg.selectSize(size);
        addToCartPg.clickOnAddToCart();
        boolean result=addToCartPg.validateAddToCart();
        Assert.assertTrue(result);
        Log.endTestCase("addToCartTest");
    }
}
