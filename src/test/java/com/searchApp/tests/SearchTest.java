package com.searchApp.tests;

import com.searchApp.pages.SearchPage;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    @Parameters({"searchKeyword"})
    public void search(String searchKeyword){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goTo();
        searchPage.search(searchKeyword);
        searchPage.goToVideos();

        Assert.assertTrue(searchPage.getVideos() > 0);

    }
}
