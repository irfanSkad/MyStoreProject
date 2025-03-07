package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.base.BasClass;

public class AccountCreationPage extends BasClass {
	String gender;
	//Action action= new Action();
	
	@FindBy(id = "uniform-id_gender1")
	private WebElement mr;
	
	@FindBy(id = "id_gender2")
	private WebElement mrs;

	@FindBy(name = "customer_firstname")
	private WebElement firstName;

	@FindBy(name = "customer_lastname")
	private WebElement lastName;

	@FindBy(name = "passwd")
	private WebElement passWord;

	@FindBy(name = "days")
	private WebElement days;

	@FindBy(name = "months")
	private WebElement months;

	@FindBy(name = "years")
	private WebElement years;

	@FindBy(name = "submitAccount")
	private WebElement registerBtn;
	
	@FindBy(xpath = "//h1[text() = 'Create an account']")
	private WebElement formTitle;
	
	public AccountCreationPage() {
		PageFactory.initElements(driver, this);
	}
	public String currentUrl() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
		return url;
	}
	public boolean validateAcountCreatePage() throws Throwable {
		System.out.println(formTitle.getText());
		return formTitle.isDisplayed();
	}
	public void createAccount() throws Throwable {
		
		//if(gender.equalsIgnoreCase("Mr")) {
			mr.click();;
		//} else {
			//mrs.click();
		//}
		firstName.sendKeys("fanme");
		lastName.sendKeys("lName");
		passWord.sendKeys("pwd12");
		Select s = new Select(days);
		Select s1 = new Select(months);
		Select s2 = new Select(years);
		s.selectByValue("3");
		s1.selectByValue("5");
		s2.selectByValue("1999");
	}
	
	public HomePage validateRegistration() throws Throwable {
		registerBtn.click();
		return new HomePage();
	}
	
	
	
}


