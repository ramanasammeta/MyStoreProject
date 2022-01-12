package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.*;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {
    IndexPage indexPg;
    LoginPage loginPg;
    HomePage homePg;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(String browser){
        launchApp(browser);
    }

    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown(){
        getDriver().quit();
    }

    @Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
    public void wishListTest(String uname, String pswd) throws Throwable {
        Log.startTestCase("wishListTest");
        indexPg=new IndexPage();
        loginPg=indexPg.clickOnSignIn();
        homePg= loginPg.login(uname,pswd);
        boolean result= homePg.validateMyWishList();
        Assert.assertTrue(result);
        Log.endTestCase("wishListTest");
    }
    @Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
    public void orderHistoryandDetailsTest(String uname, String pswd) throws Throwable {
        Log.startTestCase("orderHistoryandDetailsTest");
        indexPg=new IndexPage();
        loginPg=indexPg.clickOnSignIn();
        homePg= loginPg.login(uname,pswd);
        boolean result= homePg.validateOrderHistory();
        Assert.assertTrue(result);
        Log.endTestCase("orderHistoryandDetailsTest");
    }
}
