package com.BookFlightApp.tests;

import com.demoApp.pages.*;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {

    private String numOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"numOfPassengers", "expectedPrice"})
    public void setupParameters(String numOfPassengers, String expectedPrice){
        this.numOfPassengers = numOfPassengers;
        this.expectedPrice = expectedPrice;
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

        flightDetailsPage.selectNumberOfPassengers(numOfPassengers);
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

        String actualPrice = flightItineraryPage.getPrice();
        Assert.assertEquals(actualPrice, expectedPrice);
    }

}
