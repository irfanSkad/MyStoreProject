/**
 * 
 */
package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BasClass;
import com.mystore.pageObjects.Index;

/**
 * 
 */
public class IndexPageText extends BasClass {
	private Index indexPage;
    
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups = "Smoke",priority = 1)
	public void verifyLogo() throws Throwable {
		
		indexPage= new Index();
		boolean result=indexPage.validateLogo();
		System.out.println("Successfully verify Logo");
		Assert.assertTrue(result);
	}
	
	@Test(groups = "Smoke",priority = 2)
	public void verifyTitle(){ 
		String actTitle=indexPage.getMyStoreTitle();
		System.out.println("Successfully verify Title");
		Assert.assertEquals(actTitle, "My Shop");
	}

	
}
