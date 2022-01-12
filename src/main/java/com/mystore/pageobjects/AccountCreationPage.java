package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage extends BaseClass {
    @FindBy(xpath = "//h1[normalize-space()='Create an account']")
    WebElement formTitle;

    @FindBy(id="id_gender1")
    WebElement mr;

    @FindBy(id="id_gender2")
    WebElement mrs;

    @FindBy(name="customer_firstname")
    WebElement firstName;

    @FindBy(name="customer_lastname")
    WebElement lastName;

    @FindBy(name="passwd")
    WebElement passWord;

    @FindBy(name="days")
    WebElement days;


    @FindBy(name="months")
    WebElement months;

    @FindBy(name="years")
    WebElement years;

    @FindBy(name="firstname")
    WebElement customerFirstName;

    @FindBy(name="lastname")
    WebElement customerLastName;

    @FindBy(name="company")
    WebElement companyName;

    @FindBy(name="address1")
    WebElement address;

    @FindBy(name="city")
    WebElement city;

    @FindBy(name="id_state")
    WebElement state;

    @FindBy(name="postcode")
    WebElement postcode;

    @FindBy(name="id_country")
    WebElement country;

    @FindBy(name="phone_mobile")
    WebElement mobile;

    @FindBy(name="alias")
    WebElement ref;

    @FindBy(name="submitAccount")
    WebElement registerBtn;



    public AccountCreationPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public void CreateAccount(String gender,String fName,String lName,String pwd, String day, String month,
                              String year,String company,String addr,String cityName,String stateName,
                              String zip,String countryName,String mobilePhone) throws Throwable
    {
        if(gender.equalsIgnoreCase("Mr")){
            Action.click(getDriver(),mr);
        }
        else{
            Action.click(getDriver(),mrs);
        }
        Action.type(firstName,fName);
        Action.type(lastName,lName);
        Action.type(passWord,pwd);
        Action.selectByValue(days,day);
        Action.selectByValue(months,month);
        Action.selectByValue(years,year);
        Action.type(companyName,company);
        Action.type(address,addr);
        Action.type(city,cityName);
        Action.selectByVisibleText(stateName,state);
        Action.type(postcode,zip);
        Action.selectByVisibleText(countryName,country);
        Action.type(mobile,mobilePhone);

    }
    public HomePage validateRegistration() throws Throwable{
        Action.click(getDriver(),registerBtn);
        return new HomePage();
    }

    public boolean validateAccountCreatePage(){
        return Action.isDisplayed(getDriver(),formTitle);
    }
}
