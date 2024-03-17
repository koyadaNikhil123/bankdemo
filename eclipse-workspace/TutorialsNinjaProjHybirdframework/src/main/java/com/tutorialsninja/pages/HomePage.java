package com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(name="search")
	private WebElement searchproduct;

	@FindBy(xpath="//button[contains(@class,'btn-default')]")
	private WebElement searchButton;
	
	@FindBy(linkText="HP LP3065")
	private WebElement productmsg;
	
	@FindBy(xpath="//div[@id='content']//descendant::h2/following-sibling::p")
	private WebElement invalidprodmsg;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//action methods
	
	public void searchingProduct(String prod) {
		
		searchproduct.sendKeys(prod);
	}
	
	public void clickOnSearchButton() {
		searchButton.click();
	}
	
	public String getProdMessage() {
		String promsg=productmsg.getText();
		return promsg;
	}
	
	public String getInvalidProdMessage() {
		String invalidms=invalidprodmsg.getText();
		return invalidms;
	}
	
	
}
