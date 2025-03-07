package com.mystore.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.base.BasClass;

public class AddToCartPage extends BasClass {
	
	//Action action= new Action();
	
	@FindBy(id="quantity_wanted")
	private WebElement quantity;
	
	@FindBy(name="group_1")
	private WebElement size;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	private WebElement addToCartMessage;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutBtn;
	
	@FindBy(id = "color_11")
	private WebElement colour;
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterQuantity() throws Throwable {
		quantity.sendKeys("1");	
		
		}
	
	public void selectSize() throws Throwable {
		
		Select s = new Select(size);
		s.selectByVisibleText("S");
		
		Select s1 = new Select(size);
		s.selectByVisibleText("M");
		
		if(s.equals(s)|| s.equals(s1)) {
		s.selectByVisibleText("L");
		}
		
	}

	
	public void chooseColour() {
		colour.click();
	}
	
	public void clickOnAddToCart() throws Throwable {
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("window.scrollBy(0,250)"," ");
		addToCartBtn.click();
	}
	
	public boolean validateAddtoCart() throws Throwable {
		
		return addToCartMessage.isDisplayed();
	}
	
	public OrderPage clickOnCheckOut() throws Throwable {
	
		proceedToCheckOutBtn.click();
		return new OrderPage();
	}
	
}
