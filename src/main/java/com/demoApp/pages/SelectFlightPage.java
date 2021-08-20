package com.demoApp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SelectFlightPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "#input_50_0_0")
    private WebElement departureFlightRadioBtn;

    @FindBy(css = "#cid_37 > table:nth-child(4) > tbody > tr:nth-child(2) > td:nth-child(2)")
    private WebElement arrivalFlightRadioBtn;

    @FindBy(css = "#reserveFlights")
    private WebElement continueBtn;

    public SelectFlightPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void selectFlightDeparture(String airline){
       departureFlightRadioBtn.click();
    }

    public void selectFlightReturn(String airline){
        arrivalFlightRadioBtn.click();
    }

    public void goToBillingPage(){
        continueBtn.click();
    }


}
