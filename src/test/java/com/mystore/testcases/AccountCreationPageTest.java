package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AccountCreationPageTest extends BaseClass {
    IndexPage indexPg;
    LoginPage loginPg;
    AccountCreationPage AccCreatePg;
    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(String browser){
        launchApp(browser);
    }

    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown(){
        getDriver().quit();
    }
    @Test(groups = "Sanity",dataProvider = "email", dataProviderClass = DataProviders.class)
    public void creteAccountTest(String email) throws Throwable {
        Log.startTestCase("createAccountTest");
        indexPg=new IndexPage();
        loginPg=indexPg.clickOnSignIn();
        AccCreatePg=loginPg.createNewAccount(email);
        boolean result=AccCreatePg.validateAccountCreatePage();
        Assert.assertTrue(result);
        Log.endTestCase("createAccountTest");
    }

}
