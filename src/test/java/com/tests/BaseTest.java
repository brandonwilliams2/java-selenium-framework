package com.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUpDriver(ITestContext ctx) throws MalformedURLException {
        String host = "localhost";
        ChromeOptions chromeOptions = new ChromeOptions();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        String seleniumHubURL;

        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }
        seleniumHubURL = "http://" + host + ":4444/wd/hub";

        String testName = ctx.getCurrentXmlTest().getName();

        if(System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            firefoxOptions.setCapability("name", testName);
            this.driver = new RemoteWebDriver(new URL(seleniumHubURL), firefoxOptions);
        }
        else if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("chrome")){
            chromeOptions.setCapability("name", testName);
            this.driver = new RemoteWebDriver(new URL(seleniumHubURL), chromeOptions);
        }
        else if (System.getProperty("BROWSER") == null){
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
        }
    }

    @AfterTest
    public void tearDownDriver(){
        driver.quit();
    }
}
