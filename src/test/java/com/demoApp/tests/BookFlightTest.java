package com.demoApp.tests;

import com.demoApp.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BookFlightTest {

    private WebDriver driver;

    @BeforeTest
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    @AfterTest
    public void tearDownDriver(){
        driver.quit();
    }

    @Test
    public void registrationPage(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterUserDetails("Bob", "Jones", "555-555-5555", "bob@jones.com"   );
        registrationPage.enterUserCredentials("bob_user", "bob_password");
        registrationPage.submitRegistration();
    }

    @Test (dependsOnMethods = "registrationPage")
    public void registrationConfirmationPage(){
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.goToFlightDetailsPage();
    }

    @Test (dependsOnMethods = "registrationConfirmationPage")
    public void flightDetailsPage(){
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.selectNumberOfPassengers("1");
        flightDetailsPage.selectDepartureCity("New York");
        flightDetailsPage.selectArrivalCity("San Francisco");
        flightDetailsPage.selectAirline("Unified Airlines");
        flightDetailsPage.goToSelectFlightsPage();
    }

    @Test (dependsOnMethods = "flightDetailsPage")
    public void selectFlightPage(){
        SelectFlightPage selectFlightPage = new SelectFlightPage(driver);
        selectFlightPage.selectFlightDeparture("Emirates");
        selectFlightPage.selectFlightReturn("Emirates");
        selectFlightPage.goToBillingPage();
    }

    @Test (dependsOnMethods = "selectFlightPage")
    public void billingPage(){
        BillingPage billingPage = new BillingPage(driver);
        billingPage.goToFlightItineraryPage();
    }

    @Test (dependsOnMethods = "billingPage")
    public void flightItineraryPage(){
        FlightItineraryPage flightItineraryPage = new FlightItineraryPage(driver);
        flightItineraryPage.printConfirmation("$584 USD");
    }

}
