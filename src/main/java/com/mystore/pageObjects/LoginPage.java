package com.mystore.pageObjects;

import java.util.Scanner;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BasClass;

public class LoginPage extends BasClass {
	
	//Action action= new Action();
	
	@FindBy(id="email")
	public WebElement userName;
	
	@FindBy(id="passwd")
	public WebElement password1;

	@FindBy(id="SubmitLogin")
	public WebElement signInBtn;
	
	@FindBy(name="email_create")
	public WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	public WebElement createNewAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
//	public void login(String username, String password) throws InterruptedException {
//		userName.sendKeys(username);
//		password1.sendKeys(password);
//	}
	
	public HomePage login2(String userName1,String passWord1) throws Throwable {
		userName.sendKeys(userName1);
		password1.sendKeys("Irfan");
		signInBtn.click();
		return new HomePage();
	}
	
	public AddressPage login1() throws Throwable {
		userName.sendKeys("mdirfaan26305@gmail.com");
		password1.sendKeys("Irfan");
		signInBtn.click();
		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount() throws Throwable {
		System.out.println("Enter Email Address");
		Scanner myObj = new Scanner(System.in); // Create a Scanner object
	    String email; 
	    email = myObj.nextLine();
		emailForNewAccount.sendKeys(email);
		createNewAccountBtn.click();
		return new AccountCreationPage();
	}


	
}


