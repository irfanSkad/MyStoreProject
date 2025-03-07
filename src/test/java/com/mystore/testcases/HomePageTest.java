package com.mystore.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BasClass;
import com.mystore.pageObjects.HomePage;
import com.mystore.pageObjects.Index;
import com.mystore.pageObjects.LoginPage;

public class HomePageTest extends BasClass{
	private Index indexPage;
	private LoginPage loginPage;
	private HomePage homePage;
	
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
	public void myAddressTest() throws Throwable {
		indexPage= new Index();
		loginPage=indexPage.clickOnSignIn();
		Thread.sleep(2000);
		homePage= loginPage.login2("mdirfaan26305@gmail.com","Irfan");
		boolean result = homePage.validateMyAddress();
		Assert.assertTrue(result);
		System.out.println("Validate My Address");
	}
	@Test(groups = "Smoke")
	public void orderHistoryTest() throws Throwable {
		indexPage= new Index();
		loginPage=indexPage.clickOnSignIn();
		Thread.sleep(2000);
		homePage=loginPage.login2("mdirfaan26305@gmail.com","Irfan");
		boolean result = homePage.validateOrderHistory();
		Assert.assertTrue(result);
		System.out.println("Validate Order History");
	}
}
