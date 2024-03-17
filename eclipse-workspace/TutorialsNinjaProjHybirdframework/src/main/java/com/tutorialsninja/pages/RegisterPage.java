package com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	@FindBy(id="input-firstname")
	 private WebElement firstname;
	
	@FindBy(id="input-lastname")
	 private WebElement lastname;
	
	@FindBy(id="input-email")
	 private WebElement emailinputadress ;
	
	@FindBy(name="telephone")
	 private WebElement telephonenum ;
	
	@FindBy(name="password")
	 private WebElement inputpassword ;
	
	
	@FindBy(name="confirm")
	 private WebElement confirmpassword;
	
	@FindBy(name="agree")
	 private WebElement agreepolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	 private WebElement continuebutton;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	 private WebElement newsletter;
    
	
	@FindBy(xpath="//div[@id='content']/h1")
	 private WebElement accountsuccessmsg;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	 private WebElement warningmsg;
	
	
	public RegisterPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//action methods
	public void inputToFirstName(String fname) {
		firstname.sendKeys(fname);
	}
	
	public void inputToLastName(String lname) {
		lastname.sendKeys(lname);
	}
	
	public void inputToEmailAddress(String email) {
		emailinputadress.sendKeys(email);
	}

	public void inputToTelephone(String tphone) {
		telephonenum.sendKeys(tphone);
	}
	
	public void inputToProvidepassword(String pass) {
		inputpassword.sendKeys(pass);
	}
	
	public void inputToConfirPassword(String confpass) {
		confirmpassword.sendKeys(confpass);
	}
	
	public void clickOnAgreepolicy() {
		agreepolicy.click();
	}
	
    public void clickOnContinueButton() {
    	continuebutton.click();
    }
    
    public String getAccountSuccesspage() {
    	String accsuccmsg=accountsuccessmsg.getText();
    	return accsuccmsg;
    }
    
    public void newsLetterSubscription() {
    	newsletter.click();
    }
    public String getwarningALreadyEmailExistsMsg() {
    	String emailexists=warningmsg.getText();
    	return emailexists;
    }
}
