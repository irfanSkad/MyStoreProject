/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BasClass;
import com.mystore.pageObjects.AddToCartPage;
import com.mystore.pageObjects.AddressPage;
import com.mystore.pageObjects.Index;
import com.mystore.pageObjects.LoginPage;
import com.mystore.pageObjects.OrderConfirmationPage;
import com.mystore.pageObjects.OrderPage;
import com.mystore.pageObjects.OrderSummaryPage;
import com.mystore.pageObjects.PaymentPage;
import com.mystore.pageObjects.SearchResultPage;
import com.mystore.pageObjects.ShippingPage;

/**
 * 
 */
public class EndToEndTest extends BasClass{
	private Index index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCart;
	private OrderPage orderPage;
	private LoginPage loginPage;
	private AddressPage addressPage;
	private ShippingPage shipping; 
	private PaymentPage payment;
	private OrderSummaryPage orderSummary;
	private OrderConfirmationPage orderConform;
	
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
	@Test(groups = "Regression")
	public void verifyTotalPrice() throws Throwable {
		
		addToCart.selectSize();
		Thread.sleep(2000);
		System.out.println("Size Selected Successfully");
		addToCart.enterQuantity();
		addToCart.chooseColour();
		addToCart.clickOnAddToCart();
		System.out.println("Successfully Added Cart");
		Thread.sleep(2000);		
		boolean result = addToCart.validateAddtoCart();
		Assert.assertTrue(result);
		orderPage = addToCart.clickOnCheckOut();
		
		int unitPrice=orderPage.getUnitPrice();
		int totalPrice=orderPage.getTotalPrice();
		System.out.println("Unit Price:"+unitPrice);
		System.out.println("Total Price:"+totalPrice);
		int totalExpectedPrice=(unitPrice * 11)+7;
		System.out.println(totalExpectedPrice);
		Assert.assertEquals(totalPrice, totalExpectedPrice);
		
		loginPage = orderPage.clickOnCheckOut();
		addressPage = loginPage.login1();
		shipping = addressPage.clickOnCheckOut();
		shipping.checkTheTerms();
		payment = shipping.clickOnProceedToCheckOut();
		orderSummary = payment.clickOnPaymentMethod();
		orderConform = orderSummary.clickOnconfirmOrderBtn();
		orderConform.validateConfirmMessage();
	}
}	
