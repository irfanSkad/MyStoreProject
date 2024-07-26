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
import com.mystore.pageObjects.HomePage;
import com.mystore.pageObjects.Index;
import com.mystore.pageObjects.LoginPage;

/**
 * 
 */
public class LoginPageTest extends BasClass {
	private Index indexPage;
	private LoginPage loginPage;
	private HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(@Optional("http://www.automationpractice.pl/index.php")String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups = {"Smoke","Sanity"})
	public void loginTest() throws Throwable {
		indexPage= new Index();
		loginPage=indexPage.clickOnSignIn();
		Thread.sleep(2000);
		homePage=loginPage.login();
		   //homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    String actualURL=homePage.getCurrURL1();
	    String expectedURL="http://www.automationpractice.pl/index.php?controller=my-account";
	    Assert.assertEquals(actualURL, expectedURL);
	    System.out.println("Successfully Logged In");
	}

}
