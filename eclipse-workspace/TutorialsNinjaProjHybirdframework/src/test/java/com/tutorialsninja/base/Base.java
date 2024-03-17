package com.tutorialsninja.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public static WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	
	
	public void loadPropertiesFile()  {
		 prop=new Properties();
		File file=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\config\\config.properties");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dataProp=new Properties();
		File file2=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\testdata\\testdata.properties");
		FileInputStream fis2 = null;
		try {
			fis2 = new FileInputStream(file2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dataProp.load(fis2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public WebDriver initBrowserAndAppUrl(String browsername) {

		
		if(browsername.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browsername.equals("firefox")){
			driver=new FirefoxDriver();
		}
		else if(browsername.equals("edge")) {
			driver=new EdgeDriver();
		}
				
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.get(prop.getProperty("url"));
			driver.findElement(By.xpath("//span[text()='My Account']")).click();
			driver.findElement(By.linkText("Login")).click();
			
			return driver;
		
	}

}
