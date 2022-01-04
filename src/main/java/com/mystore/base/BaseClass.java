package com.mystore.base;
import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.OperatingSystem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static Properties prop;
    //public static WebDriver driver;
    public static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<>();
    @BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
    public void readConfig() {
        ExtentManager.setExtent();
        prop=new Properties();
        try {
            FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+ "/Configuration/Config.properties");
            prop.load(fs);
            System.out.println("driver:" + driver);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    @Parameters("browser")
    public static void launchApp(String browserName)
    {
        System.out.println("You have selected " + browserName);
        //String browserName=prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("Chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        }
        else if(browserName.equalsIgnoreCase("FireFox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        }
        else if(browserName.equalsIgnoreCase("IE"))
        {
            WebDriverManager.edgedriver().operatingSystem(OperatingSystem.WIN).setup();
            driver.set(new EdgeDriver());
        }

        //Maximize the screen
        getDriver().manage().window().maximize();
        //Delete all the cookies
        getDriver().manage().deleteAllCookies();
        //Implicit TimeOuts
        getDriver().manage().timeouts().implicitlyWait
                (Integer.parseInt(prop.getProperty("implicitWait")), TimeUnit.SECONDS);
        //PageLoad TimeOuts
        getDriver().manage().timeouts().pageLoadTimeout
                (Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
        //Launching the URL
        getDriver().get(prop.getProperty("url"));

    }
    @AfterSuite(groups = { "Smoke", "Regression","Sanity" })
    public void afterSuite() {
        ExtentManager.endReport();
    }
}
