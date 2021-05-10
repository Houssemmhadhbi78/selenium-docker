package com.searchmodule.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.searchmodule.pages.SearchPage;

import resources.BasesTest;

public class SearchTest extends BasesTest {
	@Test
    @Parameters({"keyword"})
    public void search(String keyword){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goTo();
        searchPage.doSearch(keyword);
        searchPage.goToVideos();
        int size = searchPage.getResult();

        Assert.assertTrue(size > 0);
    }

}
