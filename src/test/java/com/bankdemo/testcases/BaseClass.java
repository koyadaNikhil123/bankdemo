package com.bankdemo.testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.bankdemo.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfg=new ReadConfig();
	
	public String baseUrl=readconfg.getApplicationUrl();
	public String uname=readconfg.getUsername();
	public String pwd=readconfg.getPassword();
	public static WebDriver driver;

	
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) throws InterruptedException
	{
	
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", readconfg.getChromePath());
		driver=new ChromeDriver();
		
		Thread.sleep(4000);	
		driver.get(baseUrl);
		
		}
		
		
		else if(br.equals("firefox"))
		{
			System.out.println("selected firefox driver");
		}
		 
			
				
	}

	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}
	
}
