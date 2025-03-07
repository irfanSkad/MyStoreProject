package com.mystore.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BasClass;
import com.mystore.pageObjects.AccountCreationPage;
import com.mystore.pageObjects.HomePage;
import com.mystore.pageObjects.Index;
import com.mystore.pageObjects.LoginPage;

public class AccountCreationTest extends BasClass{
	private LoginPage loginPage;
	private AccountCreationPage accountcreate;
	private Index indexPage;

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
	@Test(groups = "Sanity")
	public void accountCreationTest() throws Throwable {
		indexPage= new Index();
		loginPage=indexPage.clickOnSignIn();
		Thread.sleep(2000);
		accountcreate = loginPage.createNewAccount();
		
		boolean result = accountcreate.validateAcountCreatePage();
		Assert.assertTrue(result);
		accountcreate.createAccount();
		accountcreate.validateRegistration();
	}
	
}
