package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage  {

	public WebDriver driver;
	public WebDriverWait wait;

	@FindBy(name = "reserveFlights")
	private WebElement firstSubmitBtn;

	@FindBy(name = "buyFlights")
	private WebElement secondSubmitBtn;

	public FindFlightPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		// Instruction to use when I use @FindBy to initiliase driver
		PageFactory.initElements(driver, this);
	}

	public void submitFindFlightPage() {
		this.wait.until(ExpectedConditions.elementToBeClickable(firstSubmitBtn));
		this.firstSubmitBtn.click();
	}
	
	public void goToFlightConfirmationPage() {
		this.wait.until(ExpectedConditions.elementToBeClickable(secondSubmitBtn));
		this.secondSubmitBtn.click();
	}
}
