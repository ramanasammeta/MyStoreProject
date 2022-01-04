package com.mystore.testcases;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.*;
import com.mystore.base.BaseClass;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseClass {
    IndexPage indexPg;
    LoginPage loginPg;
    HomePage homePage;
    SearchResultsPage SearchrsltPg;
    AddToCartPage addToCartPg;
    OrderPage orderPg;
    AddressPage addPg;
    ShippingPage shipPg;
    PaymentPage paymentPg;
    OrderSummaryPage ordSummaryPg;
    OrderConfirmationPage ordConfirmPg;

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
    public void endToEndTest(String productName, String qty, String size) throws Throwable {
    Log.startTestCase("endToEndTest");

    indexPg=new IndexPage();
    SearchrsltPg=indexPg.searchProduct(productName);
    addToCartPg=SearchrsltPg.clickOnProduct();
    addToCartPg.enterQuantity(qty);
    addToCartPg.selectSize(size);
    addToCartPg.clickOnAddToCart();
    orderPg= addToCartPg.clickOnCheckOut();
    loginPg=orderPg.clickOnCheckOut();
    addPg=loginPg.login1(prop.getProperty("username"),prop.getProperty("password"));
    shipPg=addPg.clickOnCheckOut();
    shipPg.checkTheTerms();
    paymentPg= shipPg.clickOnProceedToCheckOut();
    ordSummaryPg= paymentPg.clickOnPaymentMethod();
    ordConfirmPg= ordSummaryPg.clickOnConfirmOrder();
    String actMessage=ordConfirmPg.validateConfirmMessage();
    String expectMessage="Your order on My Store is complete.";
    Assert.assertEquals(actMessage,expectMessage);

        Log.endTestCase("endToEndTest");
}
}
