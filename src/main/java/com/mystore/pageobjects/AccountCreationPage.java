package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage extends BaseClass {
    Action action= new Action();
    @FindBy(xpath = "//h1[normalize-space()='Create an account']")
    private WebElement formTitle;

    @FindBy(id="id_gender1")
    private WebElement mr;

    @FindBy(id="id_gender2")
    private WebElement mrs;

    @FindBy(name="customer_firstname")
    private WebElement firstName;

    @FindBy(name="customer_lastname")
    private WebElement lastName;

    @FindBy(name="passwd")
    private WebElement passWord;

    @FindBy(name="days")
    private WebElement days;


    @FindBy(name="months")
    private WebElement months;

    @FindBy(name="years")
    private WebElement years;

    @FindBy(name="firstname")
    private WebElement customerFirstName;

    @FindBy(name="lastname")
    private WebElement customerLastName;

    @FindBy(name="company")
    private WebElement companyName;

    @FindBy(name="address1")
    private WebElement address;

    @FindBy(name="city")
    private WebElement city;

    @FindBy(name="id_state")
    private WebElement state;

    @FindBy(name="postcode")
    private WebElement postcode;

    @FindBy(name="id_country")
    private WebElement country;

    @FindBy(name="phone_mobile")
    private WebElement mobile;

    @FindBy(name="alias")
    private WebElement ref;

    @FindBy(name="submitAccount")
    private WebElement registerBtn;



    public AccountCreationPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public void CreateAccount(String gender,String fName,String lName,String pwd, String day, String month,
                              String year,String company,String addr,String cityName,String stateName,
                              String zip,String countryName,String mobilePhone) throws Throwable
    {
        if(gender.equalsIgnoreCase("Mr")){
            action.click(getDriver(),mr);
        }
        else{
            action.click(getDriver(),mrs);
        }
        action.type(firstName,fName);
        action.type(lastName,lName);
        action.type(passWord,pwd);
        action.selectByValue(days,day);
        action.selectByValue(months,month);
        action.selectByValue(years,year);
        action.type(companyName,company);
        action.type(address,addr);
        action.type(city,cityName);
        action.selectByVisibleText(stateName,state);
        action.type(postcode,zip);
        action.selectByVisibleText(countryName,country);
        action.type(mobile,mobilePhone);

    }
    public HomePage validateRegistration() throws Throwable{
        action.click(getDriver(),registerBtn);
        return new HomePage();
    }

    public boolean validateAccountCreatePage(){
        return action.isDisplayed(getDriver(),formTitle);
    }
}
