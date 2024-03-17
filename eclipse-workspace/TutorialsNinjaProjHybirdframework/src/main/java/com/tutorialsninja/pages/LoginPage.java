package com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id="input-email")
	private WebElement inputemailaddress;
	
	@FindBy(id="input-password")
	private WebElement inputpasswordaddress;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginbutton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningmessage;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void provideInputEmailAddress(String emailaddress) {
		inputemailaddress.sendKeys(emailaddress);
	}
	

	public void provideInputPassword(String passwordinput) {
		inputpasswordaddress.sendKeys(passwordinput);
	}
	
	public void clickOnLoginButton() {
		loginbutton.click();
	}
	
	public String getWarningMessageText() {
		String warnmsg=warningmessage.getText();
		return warnmsg;
	}
	

}
