package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	// 2 locals Instances variables "driver" and "wait"

	public WebDriver driver;
	public WebDriverWait wait;

	@FindBy(name = "firstName")
	private WebElement firstNameText;

	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement lastNameText;

	@FindBy(css = "input[name='phone']")
	private WebElement PhoneText;

	@FindBy(css = "#userName")
	private WebElement EmailText;

	@FindBy(xpath = "//input[@name='address1']")
	private WebElement AddressText;

	@FindBy(xpath = "//input[@name='city']")
	private WebElement CityText;

	@FindBy(xpath = "//input[@name='state']")
	private WebElement StateText;

	@FindBy(xpath = "//input[@name='postalCode']")
	private WebElement PostalCodeText;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement UserNameText;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement PasswordText;

	@FindBy(xpath = "//input[@name='confirmPassword']")
	private WebElement ConfirmPasswordText;

	@FindBy(xpath = "//input[@id='register-btn']")
	private WebElement SubmitBtn;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		// Instance to define some wait (50 seconds) for charching of pages Web.
		this.wait = new WebDriverWait(driver, 50);
		// Instruction to use when I use @FindBy to initiliase driver
		PageFactory.initElements(driver, this);
	}

	public void goTo() {
		this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
		this.wait.until(ExpectedConditions.visibilityOf(this.firstNameText));
	}

	public void enterUserDetails(String firstName, String lastName) {
		this.firstNameText.sendKeys(firstName);
		this.lastNameText.sendKeys(lastName);
	}

	public void enterMailingInformation(String Address, String City, String State, String PostalCode) {
		this.AddressText.sendKeys(Address);
		this.CityText.sendKeys(City);
		this.StateText.sendKeys(State);
		this.PostalCodeText.sendKeys(PostalCode);
	}

	public void enterUserCredentials(String UserName,String Password,String ConfirmPwd) {
		this.UserNameText.sendKeys(UserName);
		this.PasswordText.sendKeys(Password);
		this.ConfirmPasswordText.sendKeys(ConfirmPwd);
	}
	
	public void submit() {
		this.SubmitBtn.click();
	}
}
