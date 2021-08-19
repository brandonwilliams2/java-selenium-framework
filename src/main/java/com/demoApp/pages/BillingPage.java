package com.demoApp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BillingPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "#input_53_addr_line1")
    private WebElement streetAddressField;

    @FindBy(css = "#reserveFlights")
    private WebElement continueBtn;

    public BillingPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void goToFlightItineraryPage(){
        continueBtn.click();
    }

}
