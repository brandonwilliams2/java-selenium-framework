package com.searchApp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement searchField;

    @FindBy(id = "search_button_homepage")
    private WebElement searchBth;

    @FindBy(linkText = "Videos")
    private WebElement videosLink;

    @FindBy(css = "div[class*='tile--vid'")
    private List<WebElement> videoTiles;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        driver.get("https://duckduckgo.com/");
    }

    public void search(String keyword){
        wait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.sendKeys(keyword);
        searchBth.click();
    }

    public void goToVideos(){
        wait.until(ExpectedConditions.elementToBeClickable(videosLink));
        videosLink.click();
    }

    public int getVideos(){
        wait.until(ExpectedConditions.visibilityOfAllElements(videoTiles));
        return videoTiles.size();
    }
}
