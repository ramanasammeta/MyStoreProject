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

import java.util.HashMap;

public class AccountCreationPageTest extends BaseClass {
    IndexPage indexPg;
    LoginPage loginPg;
    AccountCreationPage AccCreatePg;
    HomePage homePage;
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
    public void verifyCreateAccountPageTest(String email) throws Throwable {
        Log.startTestCase("verifyCreateAccountPageTest");
        indexPg=new IndexPage();
        loginPg=indexPg.clickOnSignIn();
        AccCreatePg=loginPg.createNewAccount(email);
        boolean result=AccCreatePg.validateAccountCreatePage();
        Assert.assertTrue(result);
        Log.endTestCase("verifyCreateAccountPageTest");
    }
    @Test(groups = "Regression",dataProvider = "AccountCreationData", dataProviderClass = DataProviders.class)
    public void createAccountTest(HashMap<String,String> hashMapValue) throws Throwable{

        Log.startTestCase("CreateAccountTest");
        indexPg=new IndexPage();
        loginPg=indexPg.clickOnSignIn();
        AccCreatePg=loginPg.createNewAccount(hashMapValue.get("Email"));
        AccCreatePg.CreateAccount(hashMapValue.get("Gender"),
                hashMapValue.get("FirstName"),
                hashMapValue.get("LastName"),
                hashMapValue.get("SetPassword"),
                hashMapValue.get("Day"),
                hashMapValue.get("Month"),
                hashMapValue.get("Year"),
                hashMapValue.get("Company"),
                hashMapValue.get("Address"),
                hashMapValue.get("City"),
                hashMapValue.get("State"),
                hashMapValue.get("Zipcode"),
                hashMapValue.get("Country"),
                hashMapValue.get("MobilePhone"));
        homePage= AccCreatePg.validateRegistration();
        Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", homePage.getCurrUrl());
        Log.endTestCase("createAccountTest");

    }
}
