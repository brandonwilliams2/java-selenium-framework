package com.demoApp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "firstName")
    private WebElement firstNameField;

    @FindBy(name = "lastName")
    private WebElement lastNameField;

    @FindBy(name = "phone")
    private WebElement phoneField;

    @FindBy(name = "userName")
    private WebElement emailField;

    @FindBy(name = "email")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(name = "register")
    private WebElement submitButton;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void goToApp(){
        driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html#");
        this.wait.until(ExpectedConditions.visibilityOf(firstNameField));
    }

    public void enterUserDetails(String firstname, String lastname, String phoneNumber, String email) {
        firstNameField.sendKeys(firstname);
        lastNameField.sendKeys(lastname);
        phoneField.sendKeys(phoneNumber);
        emailField.sendKeys(email);
    }

    public void enterUserCredentials(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);
    }

    public void submitRegistration(){
        submitButton.click();
    }
}
