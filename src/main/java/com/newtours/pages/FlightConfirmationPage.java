package com.newtours.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightConfirmationPage {

	public WebDriver driver;
	public WebDriverWait wait;

	@FindBy(xpath = "//font[contains(text(),'Flight Confirmation')]")
	private WebElement flightConfirmationHeader;

	@FindBy(xpath = "//font[contains(text(),'USD')]")
	private List<WebElement> prices;
	
	
	@FindBy(linkText = "SIGN-OFF")
	private WebElement signOffLink;
	
	@FindBy(xpath = "//h1[normalize-space()='Docker Flight Booking Application']")
	private WebElement signOnLink;

	public FlightConfirmationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);

		PageFactory.initElements(driver, this);
	}

	public String GetPrice() {
		this.wait.until(ExpectedConditions.elementToBeClickable(flightConfirmationHeader));
//		System.out.println(this.flightConfirmationHeader.getText());
//		System.out.println(this.prices.get(1).getText());
		String price = this.prices.get(1).getText();
		return price;
		
	}

	public void signOffLink() {
		this.signOffLink.click();
//		this.wait.until(ExpectedConditions.elementToBeClickable(signOnLink));
//		System.out.println("Expected sentence is : "+this.signOnLink.getText());
	}
}
