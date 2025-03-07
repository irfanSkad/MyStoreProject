package com.mystore.testcases;

import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BasClass;
import com.mystore.pageObjects.AddToCartPage;
import com.mystore.pageObjects.Index;
import com.mystore.pageObjects.OrderPage;
import com.mystore.pageObjects.SearchResultPage;

public class AddToCartTest extends BasClass{
	private Index index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCart;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws Throwable {
		launchApp(browser); 
	 
		index= new Index();
		searchResultPage = index.searchProduct();
		boolean result= searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
		addToCart = searchResultPage.clickOnProduct();
	}
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups = {"Regression","Sanity"})
	public void addToCart() throws Throwable {
		addToCart.selectSize();
		Thread.sleep(2000);
		System.out.println("Size Selected Successfully");	
		addToCart.chooseColour();
		addToCart.clickOnAddToCart();
		System.out.println("Successfully Added Cart");
		Thread.sleep(2000);		
		boolean result = addToCart.validateAddtoCart();
		Assert.assertTrue(result);
	}
}
