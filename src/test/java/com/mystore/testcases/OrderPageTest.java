package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultsPage;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrderPageTest extends BaseClass {
    IndexPage indexPg;
    SearchResultsPage SearchrsltPg;
    AddToCartPage addToCartPg;
    OrderPage orderPg;
    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(String browser){
        launchApp(browser);
    }
    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown(){
        getDriver().quit();
    }

    @Test(groups = "Regression",dataProvider = "getProduct", dataProviderClass = DataProviders.class)
    public void verifyTotalPrice(String productName, String qty, String size) throws Throwable {
        Log.startTestCase("verifyTotalPrice");
        indexPg=new IndexPage();
        SearchrsltPg=indexPg.searchProduct(productName);
        addToCartPg=SearchrsltPg.clickOnProduct();
        addToCartPg.enterQuantity(qty);
        addToCartPg.selectSize(size);
        addToCartPg.clickOnAddToCart();
        orderPg= addToCartPg.clickOnCheckOut();
        Double unitPrice=orderPg.getUnitPrice();
        Double totalPrice=orderPg.getTotalPrice();
        Double totalExpectPrice=(unitPrice*(Double.parseDouble(qty))) +2;
        Assert.assertEquals(totalPrice,totalExpectPrice);
        Log.endTestCase("verifyTotalPrice");
    }
}
