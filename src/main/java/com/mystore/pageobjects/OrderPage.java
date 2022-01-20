package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends BaseClass {
    Action action= new Action();
    @FindBy(xpath="//td[@class='cart_unit']/span/span")
    private WebElement unitPrice;

    @FindBy(id="total_price")
    private WebElement totalPrice;

   // @FindBy(xpath="//span[text(),'Proceed to checkout']")
   @FindBy(xpath="//*[@id=\"center_column\"]/p[2]/a[1]")
   private WebElement proceedToCheckoutBtn;

    public OrderPage(){
        PageFactory.initElements(getDriver(),this);
    }
    public double getUnitPrice(){
        String unitPrc=unitPrice.getText();
       String unit= unitPrc.replace("$","");
       double finalUnitPrice=Double.parseDouble(unit);
       return finalUnitPrice;

    }
    public double getTotalPrice(){
        String totPrc=totalPrice.getText();
        String totPrice= totPrc.replace("$","");
        double finalTotalPrice=Double.parseDouble(totPrice);
        return finalTotalPrice;
    }
    public LoginPage clickOnCheckOut() throws Throwable{
        action.click(getDriver(),proceedToCheckoutBtn);
        return new LoginPage();
    }
}
