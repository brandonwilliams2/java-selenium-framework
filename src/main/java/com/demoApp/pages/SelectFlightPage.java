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

    @FindBy(css = "th > label")
    private List<WebElement> tableRows;

    @FindBy(css = "#reserveFlights")
    private WebElement continueBtn;

    public SelectFlightPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void selectFlightDeparture(String airline){
        for(WebElement row : tableRows){
            if (row.getText().contains(airline)){
                row.findElement(By.cssSelector(".. + td > input")).click();
                break;
            }
        }
    }

    public void selectFlightReturn(String airline){
        for(WebElement row : tableRows){
            if (row.getText().contains(airline)){
                row.findElement(By.cssSelector(".. + td > input")).click();
                break;
            }
        }
    }

    public void goToBillingPage(String airline){
        continueBtn.click();
    }


}
