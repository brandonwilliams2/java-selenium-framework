package com.demoApp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.jvm.hotspot.utilities.Assert;

public class RegistrationConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "register-confirm > div > table > tbody > tr > td > h1 ")
    private WebElement registrationConfirmationPageHeader;

    @FindBy(linkText = "sign-in")
    private WebElement signInLink;

    @FindBy(id = "flight-link")
    private WebElement flightsLink;

    public RegistrationConfirmationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void goToFlightDetailsPage(){
        wait.until(ExpectedConditions.visibilityOf(signInLink));
        flightsLink.click();
    }

}
