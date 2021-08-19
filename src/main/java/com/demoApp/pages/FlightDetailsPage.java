package com.demoApp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "passCount")
    WebElement passengersCmbBx;

    @FindBy(name = "fromPort")
    WebElement departingFromCmbBx;

    @FindBy(name = "toPort")
    WebElement arrivingInCmbBx;

    @FindBy(name = "airline")
    WebElement airlineCmbBx;

    @FindBy(id = "findFlights")
    WebElement continueBtn;


    public FlightDetailsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void selectNumberOfPassengers(String numOfPassengers){
        wait.until(ExpectedConditions.elementToBeClickable(passengersCmbBx));
        Select select = new Select(passengersCmbBx);
        select.selectByValue(numOfPassengers);
    }

    public void selectDepartureCity(String departureCity){
        Select select = new Select(departingFromCmbBx);
        select.selectByValue(departureCity);
    }

    public void selectArrivalCity(String arrivalCity){
        Select select = new Select(arrivingInCmbBx);
        select.selectByValue(arrivalCity);
    }

    public void selectAirline(String airline){
        Select select = new Select(airlineCmbBx);
        select.selectByValue(airline);
    }

    public void goToSelectFlightsPage(){
        continueBtn.click();
    }


}
