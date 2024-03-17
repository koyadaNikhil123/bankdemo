package com.tutorialsninja.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.base.Base;
import com.tutorialsninja.pages.AccountPage;
import com.tutorialsninja.pages.AccountSuccesspage;
import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.utils.Utilities;




public class LoginTest extends Base {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws IOException {
		 loadPropertiesFile();
		 driver=initBrowserAndAppUrl(prop.getProperty("browser"));
		
		 AccountPage accountpage=new AccountPage(driver);
		 accountpage.myAccountDropDown();
		 accountpage.loginOptionClickable();
		
	}
	
	@Test(priority=1,dataProvider="ValidCredentialssupplier")
	public void verifyLoginWithvalidCred(String email,String password) throws InterruptedException {
         
		LoginPage loginpage=new LoginPage(driver);
		loginpage.provideInputEmailAddress(email);
		loginpage.provideInputPassword(password);
		System.out.println(email);
		System.out.println(password);
		loginpage.clickOnLoginButton();
        AccountSuccesspage accountsuccesspage=new AccountSuccesspage(driver);
		Assert.assertTrue(accountsuccesspage.getAccountSuccessMsg());
	
	}
	
	@DataProvider(name="ValidCredentialssupplier")
	public Object[][] supplyTestData() throws IOException {
		Object[][] data=Utilities.getTestDataFromExcel("Login");
		
		return data;
		
	}
	
	@Test(priority=2)
	public void  verifyLoginWithInvalidCred() {
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.provideInputEmailAddress(Utilities.generatedateStamp());
		loginpage.provideInputPassword(prop.getProperty("validPassword"));
		loginpage.clickOnLoginButton();
		
		String expectedmessage="Warning: No match for E-Mail Address and/or Password.";
		String actualmessage=loginpage.getWarningMessageText();
		Assert.assertTrue(actualmessage.contains(expectedmessage),"error expected message is not displayed");
		
				

	}
	@Test(priority=3)
	public void verifyLoginWithValidEmailAndInvalidPass() {
		

		LoginPage loginpage=new LoginPage(driver);
		loginpage.provideInputEmailAddress(Utilities.generatedateStamp());
		loginpage.provideInputPassword(prop.getProperty("validPassword"));
		loginpage.clickOnLoginButton();

		String expectedmessage="Warning: No match for E-Mail Address and/or Password.";
		String actualmessage=loginpage.getWarningMessageText();

		Assert.assertTrue(actualmessage.contains(expectedmessage),"error expected message is not displayed");
	
				

	}
	
	@Test(priority=4)
	public void verifyLoginWithValidpassAndInvalidEmail()
	{
		 

		LoginPage loginpage=new LoginPage(driver);
		loginpage.provideInputEmailAddress(Utilities.generatedateStamp());
		loginpage.provideInputPassword(prop.getProperty("validPassword"));
		loginpage.clickOnLoginButton();
		String expectedmessage="Warning: No match for E-Mail Address and/or Password.";
		String actualmessage=loginpage.getWarningMessageText();
         Assert.assertTrue(actualmessage.contains(expectedmessage),"error expected message is not displayed");
		
	}
	
	@Test(priority=5)
	public void verifyLoginWithNoCred() {
		 
		LoginPage loginpage=new LoginPage(driver);
		loginpage.clickOnLoginButton();
		String expectedmessage="Warning: No match for E-Mail Address and/or .";
		String actualmessage=loginpage.getWarningMessageText();
        Assert.assertTrue(actualmessage.contains(expectedmessage),"error expected message is not displayed");
	
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

}
