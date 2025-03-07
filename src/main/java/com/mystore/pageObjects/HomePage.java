package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BasClass;

public class HomePage extends BasClass {
	
	//Action action= new Action();
	
	@FindBy(xpath="//span[text() = 'My addresses']")
	private WebElement myAddresses;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	private WebElement orderHistory;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	
	public boolean validateMyAddress() throws Throwable {
		System.out.println(myAddresses.getText());
		return myAddresses.isDisplayed();
	}
	
	public boolean validateOrderHistory() throws Throwable {
		System.out.println(orderHistory.getText());
		return orderHistory.isDisplayed();
	}
	
	public String getCurrURL1() throws Throwable {
		String homePageURL= driver.getCurrentUrl();
		System.out.println(homePageURL);
		return homePageURL;
	}
}


