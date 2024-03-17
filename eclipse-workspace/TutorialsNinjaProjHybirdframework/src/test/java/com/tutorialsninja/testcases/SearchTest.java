package com.tutorialsninja.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.base.Base;
import com.tutorialsninja.pages.HomePage;

public class SearchTest extends Base {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws IOException {
		
		loadPropertiesFile();
		
		driver=initBrowserAndAppUrl(prop.getProperty("browser"));
	}
	
	@AfterMethod
  public void tearDown() {
	  driver.quit();
	  
  }
	
	@Test(priority=2)
	public void verifySearchWithValid() {
		
		HomePage homepage=new HomePage(driver);
		homepage.searchingProduct(dataProp.getProperty("validproduct"));
		homepage.clickOnSearchButton();
		String actualmessage=homepage.getProdMessage();
		Assert.assertEquals(actualmessage,"HP LP3065","searched product is not available or exists");
		
	}
	
	@Test(priority=1)
	public void verifySearchWithInvalid() {
		
		HomePage homepage=new HomePage(driver);
		homepage.searchingProduct(dataProp.getProperty("invalidproduct"));
		homepage.clickOnSearchButton();
		String actmsg=homepage.getInvalidProdMessage();
		Assert.assertEquals(actmsg,"There is no product that matches the search criteria.");
				
		
	}
	@Test(priority=3)
	public void verifySearchWithNoInput() {
		HomePage homepage=new HomePage(driver);
		homepage.searchingProduct("");
		homepage.clickOnSearchButton();
		String actmsg=homepage.getInvalidProdMessage();
		Assert.assertEquals(actmsg,"There is no product that matches the search criteria.");
						
	}
}
