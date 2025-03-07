package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.base.BasClass;

public class SearchResultPage extends BasClass {
	
	//Action action= new Action();
	
	@FindBy(xpath="//a[@class = 'product_img_link']//img[@class = 'replace-2x img-responsive']")
	private WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductAvailable() throws Throwable {
		return productResult.isDisplayed();
	}
	
	public AddToCartPage clickOnProduct() throws Throwable {
		productResult.click();
		return new AddToCartPage();
	}
	
}
