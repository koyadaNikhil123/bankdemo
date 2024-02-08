package com.bankdemo.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bankdemo.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	

	
	@Test
	public void loginTest()
	{
	
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(uname);
		lp.setPassword(pwd);
		lp.submitButton();
		
	if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
	{
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertFalse(false);
	}
	
	
	

}
}
