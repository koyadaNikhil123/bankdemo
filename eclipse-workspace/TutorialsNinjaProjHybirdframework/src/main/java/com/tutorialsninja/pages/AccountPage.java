package com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	//objects
	WebDriver driver;
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myaccount;
	
	@FindBy(linkText="Login")
	private WebElement loginoption;
	
	
	@FindBy(linkText="Register")
	WebElement registerOptionClickable;
	

	
	
	public AccountPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
}
	//actions
	
	public void myAccountDropDown() {
		myaccount.click();
	}
	
	public void loginOptionClickable() {
		loginoption.click();
	}
	
	
	public void registerOptionClick() {
		registerOptionClickable.click();
	}
	
	
}
