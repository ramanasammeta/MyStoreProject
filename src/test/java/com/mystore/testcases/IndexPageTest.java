package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class IndexPageTest extends BaseClass {
    IndexPage indexPg;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(String browser){
        launchApp(browser);
    }
    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown(){
        getDriver().quit();
    }

    @Test(groups="Smoke")
    public void verifyLogo() throws Throwable{
        Log.startTestCase("verifyLogo");
        indexPg=new IndexPage();
        boolean result=indexPg.validateLogo();
        Assert.assertTrue(result);
        Log.endTestCase("verifyLogo");
    }
    @Test(groups="Smoke")
    public void verifyTitle() throws Throwable{
        Log.startTestCase("verifyTitle");
        String actTitle=indexPg.geMyStoreTitle();
        Assert.assertEquals(actTitle,"My Store");
        Log.endTestCase("verifyTitle");
    }
}
