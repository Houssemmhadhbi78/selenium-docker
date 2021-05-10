package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {

	public WebDriver driver;
	public WebDriverWait wait;

	@FindBy(name = "passCount")
	private WebElement passengers;

	@FindBy(name = "findFlights")
	private WebElement ContinueBtn;

	public FlightDetailsPage(WebDriver driver) {
		this.driver = driver;
		// Instance to define some wait (30 seconds) for charching of pages Web.
		this.wait = new WebDriverWait(driver, 30);
		// Instruction to use when I use @FindBy to initiliase driver
		PageFactory.initElements(driver, this);
	}

	public void selectPassengers(String NoOfPassengers) {
		this.wait.until(ExpectedConditions.elementToBeClickable(passengers));
		Select selectNumberPass = new Select(passengers);
		selectNumberPass.selectByValue(NoOfPassengers);
	}
	
	public void goToFindFlightPage() {
		this.ContinueBtn.click();
	}
}
