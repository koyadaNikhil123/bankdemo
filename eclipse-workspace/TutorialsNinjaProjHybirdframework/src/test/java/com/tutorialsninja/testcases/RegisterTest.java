package com.tutorialsninja.testcases;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.base.Base;
import com.tutorialsninja.pages.AccountPage;
import com.tutorialsninja.pages.RegisterPage;
import com.tutorialsninja.utils.Utilities;

public class RegisterTest extends Base {
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		loadPropertiesFile();
		driver=initBrowserAndAppUrl(prop.getProperty("browser"));
		AccountPage accountpage=new AccountPage(driver);
		accountpage.myAccountDropDown();
		accountpage.registerOptionClick();
		
		
	}
	
	
	@Test(priority=1)
	public void verifyRegisterWithMandatFields() {
		 
		RegisterPage registerpage=new RegisterPage(driver);
		registerpage.inputToFirstName(dataProp.getProperty("firstname"));
		registerpage.inputToLastName(dataProp.getProperty("lastname"));
		registerpage.inputToEmailAddress(Utilities.generatedateStamp());
		registerpage.inputToTelephone(dataProp.getProperty("invalidtelephone"));
		registerpage.inputToProvidepassword(prop.getProperty("validPassword"));
		registerpage.inputToConfirPassword(prop.getProperty("validPassword"));
		registerpage.clickOnAgreepolicy();
		registerpage.clickOnContinueButton();
		String actualmessg=registerpage.getAccountSuccesspage();
		Assert.assertEquals(actualmessg, "Your Account Has Been Created!","registration is not successful");
		driver.quit();		
	}
	@Test(priority=2)
	public void verifyRegisterprovidingAllFields() {
		
		RegisterPage registerpage=new RegisterPage(driver);
		registerpage.inputToFirstName(dataProp.getProperty("firstname"));
		registerpage.inputToLastName(dataProp.getProperty("lastname"));
		registerpage.inputToEmailAddress(Utilities.generatedateStamp());
		registerpage.inputToTelephone(dataProp.getProperty("invalidtelephone"));
		registerpage.inputToProvidepassword(prop.getProperty("validPassword"));
		registerpage.inputToConfirPassword(prop.getProperty("validPassword"));
		registerpage.newsLetterSubscription();
		registerpage.clickOnAgreepolicy();
		registerpage.clickOnContinueButton();
		String actualmessg=registerpage.getAccountSuccesspage();
		System.out.println(actualmessg);
		Assert.assertEquals(actualmessg, "Your Account Has Been Created!","registration is not successful");
		driver.quit();	
		
	}
	@Test(priority=3)
	public void verifyRegisterProvidingExistingEmailId() throws InterruptedException {
		
		
		RegisterPage registerpage=new RegisterPage(driver);
		registerpage.inputToFirstName(dataProp.getProperty("firstname"));
		registerpage.inputToLastName(dataProp.getProperty("lastname"));
		registerpage.inputToEmailAddress(prop.getProperty("validEmail"));
		registerpage.inputToTelephone(dataProp.getProperty("invalidtelephone"));
		registerpage.inputToProvidepassword(prop.getProperty("validPassword"));
		registerpage.inputToConfirPassword(prop.getProperty("validPassword"));
		registerpage.clickOnAgreepolicy();
		registerpage.clickOnContinueButton();
		Thread.sleep(3000);
		String actualmesg=registerpage.getwarningALreadyEmailExistsMsg();
		System.out.println(actualmesg);
		Assert.assertEquals(actualmesg, "Warning: E-Mail Address is already registered!","registration is not successful");
		driver.quit();	
		
		
		 	
	}
	
	@AfterMethod
    public void tearDown() { 
    	driver.quit();

    }
}
