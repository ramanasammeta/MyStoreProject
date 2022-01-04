package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPageTest extends BaseClass {
    IndexPage indexPg;
    LoginPage loginPg;
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

    @Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = {"Smoke","Sanity"})
    public void LoginTest(String uname,String pwd) throws Throwable{
        Log.startTestCase("loginTest");
        indexPg=new IndexPage();
        Log.info("user is going to click on SignIn");
        loginPg=indexPg.clickOnSignIn();
        Log.info("Enter Username and Password");
      //  homePage=loginPg.login(prop.getProperty("username"),prop.getProperty("password"));
        homePage=loginPg.login(uname,pwd);
        String actURL=homePage.getCurrUrl();
        String expectURL="http://automationpractice.com/index.php?controller=my-account";
        Log.info("Verify if user is able to login");
        Assert.assertEquals(actURL,expectURL);
        Log.info("Login is success");
        Log.endTestCase("loginTest");
    }
}
