package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SearchResultsPage;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchResultPageTest extends BaseClass {
    IndexPage indexPg;
    SearchResultsPage SearchrsltPg;
    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(String browser){
        launchApp(browser);
    }
    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown(){
        getDriver().quit();
    }
    @Test(groups = "Smoke",dataProvider = "searchProduct", dataProviderClass = DataProviders.class)
    public void productAvailabilityTest(String productName){
        Log.startTestCase("productAvailabilityTest");
        indexPg=new IndexPage();
        SearchrsltPg=indexPg.searchProduct(productName);
        boolean result=SearchrsltPg.isProductAvailable();
        Assert.assertTrue(result);
        Log.endTestCase("productAvailabilityTest");
    }
}
