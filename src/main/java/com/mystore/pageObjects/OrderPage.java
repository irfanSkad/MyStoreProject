package com.mystore.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BasClass;

public class OrderPage extends BasClass {
	
	//Action action= new Action();
	
	@FindBy(xpath="//td[@class='cart_unit']/ul/li")
	private WebElement unitPrice;
	
	@FindBy(id="total_price")
	private WebElement totalPrice;
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	private WebElement proceedToCheckOut;
		
	public OrderPage() {
		PageFactory.initElements(driver,this);
	}

	public int getUnitPrice() {
		String unitPrice1=unitPrice.getText();
		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]","");
		int finalUnitPrice= Integer.parseInt(unit);
		System.out.println(finalUnitPrice);
		return finalUnitPrice;
	}
	
	public int getTotalPrice() throws InterruptedException{
		String totalPrice1=totalPrice.getText();
		String tot=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
		int finalTotalPrice= Integer.parseInt(tot);
		System.out.println(finalTotalPrice);
		Thread.sleep(2000);
		return finalTotalPrice;
	}
	
	public LoginPage clickOnCheckOut() throws Throwable{
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("window.scrollBy(0,250)"," ");
	
		proceedToCheckOut.click();
		return new LoginPage();
	}
	
}