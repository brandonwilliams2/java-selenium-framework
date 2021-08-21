package com.demoApp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BillingPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "#input_53_addr_line1")
    private WebElement streetAddressField;

    @FindBy(css = "#buyFlights")
    private WebElement continueBtn;


    public BillingPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    /**
     * Wait for the continue button to load then click it
     */
    public void goToFlightItineraryPage(){
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        continueBtn.click();
    }

}
