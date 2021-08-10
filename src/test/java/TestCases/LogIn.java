package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LogInPage;
import resources.Helper;

//in order to get methods from helper/base class, should use "extends" in class , or create object of it
public class LogIn extends Helper {
	
	//u should write this code in every test, if want use log and print output
	private static Logger Log = LogManager.getLogger(Helper.class.getName());


	@BeforeTest

	public void initializebrowser() throws IOException {
		driver = this.initializeDriver();
		
		Log.info("Driver is initialized");

		// Parameterize url too
		driver.get(prop.getProperty("URL"));
		Log.info("Navigate to home page");

	}

	@Test

	public void LogInPage() throws IOException {

		LogInPage lp = new LogInPage(driver);
		lp.logIn().click();
		lp.userName().sendKeys("Tako");
		lp.password().sendKeys("Pass123");
		lp.logInButton().click();
		lp.InvalidEmailText().getText();

		// in case wrong credentials validate error text with assertion

		Assert.assertEquals(lp.InvalidEmailText().getText(), "Invalid email or password.");
		Log.info("Text successfuly validated");

		// if u want to validate any field is desplayed or not use:
		Assert.assertTrue(lp.logInButton().isDisplayed());

	}

	@AfterTest

	public void testEnd() {
		driver.quit();
	}

}
