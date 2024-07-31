package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BasClass;

public class LoginPage extends BasClass {
	
	//Action action= new Action();
	
	@FindBy(id="email")
	private WebElement userName;
	
	@FindBy(id="passwd")
	private WebElement password;

	@FindBy(id="SubmitLogin")
	private WebElement signInBtn;
	
	@FindBy(name="email_create")
	private WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	private WebElement createNewAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login() throws Throwable {
		userName.sendKeys("mdirfaan26305@gmail.com");
		password.sendKeys("Irfan");
		signInBtn.click();
		return new HomePage();
	}
	
	public AddressPage login1() throws Throwable {
		userName.sendKeys("mdirfaan26305@gmail.com");
		password.sendKeys("Irfan");
		signInBtn.click();
		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount() throws Throwable {
		emailForNewAccount.sendKeys("abcdd7@gmail.com");
		createNewAccountBtn.click();
		return new AccountCreationPage();
	}
	
}


