package com.newtours.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newtours.pages.FindFlightPage;
import com.newtours.pages.FlightConfirmationPage;
import com.newtours.pages.FlightDetailsPage;
import com.newtours.pages.RegistrationConfirmationPage;
import com.newtours.pages.RegistrationPage;

import resources.BasesTest;

//import com.newtours.pages.*;

public class BookFlightTest extends BasesTest {

	// Create 2 privates variables for assertion ( comparaison)
	protected String NoOfPassengers;
	protected String ExpectedPrice;

	@BeforeTest
	@Parameters({ "NoOfPassengers", "ExpectedPrice" })
	public void setupParameters(String NoOfPassengers, String ExpectedPrice) {
		this.NoOfPassengers = NoOfPassengers;
		this.ExpectedPrice = ExpectedPrice;
	}

	@Test
	public void registrationPageTest() {
		RegistrationPage RPage = new RegistrationPage(driver);
		// 1
		RPage.goTo();
		// 2
		RPage.enterUserDetails("selenium", "Docker");
		// 3
		RPage.enterMailingInformation("14 rue arletty", "Montigny le Bretonneux", "yvelinnes", "78210");
		// 4
		RPage.enterUserCredentials("selenium", "1234", "1234");
		// 5
		RPage.submit();
	}

	@Test(dependsOnMethods = "registrationPageTest")
	public void registrationConfirmation() {
		RegistrationConfirmationPage RCPage = new RegistrationConfirmationPage(driver);
		RCPage.goToFlightDetailsPage();
	}

	@Test(dependsOnMethods = "registrationConfirmation")
	public void flightDetailsPage() {
		FlightDetailsPage FDPage = new FlightDetailsPage(driver);
		FDPage.selectPassengers(NoOfPassengers);
		FDPage.goToFindFlightPage();
	}

	@Test(dependsOnMethods = "flightDetailsPage")
	public void findFlightPage() {
		FindFlightPage FFPage = new FindFlightPage(driver);
		FFPage.submitFindFlightPage();
		FFPage.goToFlightConfirmationPage();
	}

	@Test(dependsOnMethods = "findFlightPage")
	public void flightConfirmationPage() {
		FlightConfirmationPage FCPage = new FlightConfirmationPage(driver);
		String ActualPrice = FCPage.GetPrice();
		FCPage.signOffLink();

		Assert.assertEquals(ActualPrice, ExpectedPrice);
	}

}
