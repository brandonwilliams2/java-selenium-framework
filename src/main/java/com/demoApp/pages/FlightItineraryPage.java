package com.demoApp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.jvm.hotspot.utilities.Assert;

import java.util.List;

public class FlightItineraryPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "#confirm-table > tbody > tr:nth-child(3) > td:nth-child(2) > font")
    private WebElement totalPrice;

    @FindBy(xpath = "//font[contains(text(), 'Flight Confirmation')]")
    private WebElement flightConfirmationNumber;

    @FindBy(xpath = "//font[contains(text(), 'USD')]")
    private List<WebElement> prices;

    @FindBy(css = "#reserveFlights")
    private WebElement continueBtn;

    @FindBy(linkText = "SIGN-OFF")
    private WebElement signOffLink;

    public FlightItineraryPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    /**
     * Wait for the flight confirmation number to load, then print it and the actual price displayed to the console
     * @return the price displayed
     */
    public String getPrice(){
        wait.until(ExpectedConditions.visibilityOf(flightConfirmationNumber));
        System.out.println(flightConfirmationNumber.getText());
        System.out.println(prices.get(1).getText());
        String actualPrice = prices.get(1).getText();
        signOffLink.click();

        return actualPrice;
    }
}
