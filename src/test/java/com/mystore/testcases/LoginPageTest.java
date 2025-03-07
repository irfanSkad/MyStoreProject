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
	public Index indexPage;
	public LoginPage loginPage;
	public HomePage homePage;
	//public String userName = "mdirfaan26305@gmail.com";
	//public String passWord = "Irfan";
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
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
		homePage=loginPage.login2("mdirfaan26305@gmail.com","Irfan");
		   //homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    String actualURL=homePage.getCurrURL1();
	    String expectedURL="http://www.automationpractice.pl/index.php?controller=my-account";
	    Assert.assertEquals(actualURL, expectedURL);
	    System.out.println("Successfully Logged In");
		
		//loginPage.login2("mdirfaan26305@gmail.com","Irfan");
	}

}
