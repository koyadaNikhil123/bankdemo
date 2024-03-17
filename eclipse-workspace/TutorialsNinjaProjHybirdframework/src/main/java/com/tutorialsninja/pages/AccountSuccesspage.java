package com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccesspage {
	
	WebDriver driver;
	
	@FindBy(linkText="Edit your account information")
	WebElement accountsuccess;
	
	
	public AccountSuccesspage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//action methods
	
    public boolean getAccountSuccessMsg() {
    	
    	boolean successmsg=accountsuccess.isDisplayed();
    	return successmsg;
    }

}
