package com.mystore.pageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BasClass;

public class Index extends BasClass {
	
	//Action action= new Action();
	
	@FindBy(xpath = "//a[@class='login']") 
	private WebElement signInBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	private WebElement myStoreLogo;
	
	@FindBy(id="search_query_top")
	private WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	private WebElement searchButton;
	
	public Index() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateLogo() throws Throwable {
		return myStoreLogo.isDisplayed();
	}
	
	public String getMyStoreTitle() {
		String title = driver.getTitle();
		System.out.println(title);
		return title;
	}
	
	public SearchResultPage searchProduct() throws Throwable {
		searchProductBox.sendKeys("Blouse");
		Thread.sleep(3000);
		searchButton.click();
		return new SearchResultPage();
		
	}
	
	public LoginPage clickOnSignIn() throws Throwable {
		signInBtn.click();
		return new LoginPage();
	}

}
