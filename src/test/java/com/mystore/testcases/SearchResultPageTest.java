package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BasClass;
import com.mystore.pageObjects.AddToCartPage;
import com.mystore.pageObjects.Index;
import com.mystore.pageObjects.SearchResultPage;

public class SearchResultPageTest extends BasClass {
	private Index index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCart;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups = "Smoke")
	public void productAvailabilityTest() throws Throwable {
		index= new Index();
		searchResultPage = index.searchProduct();
		boolean result= searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
		addToCart = searchResultPage.clickOnProduct();
	}

}
