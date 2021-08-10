package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LogInPage;
import resources.Helper;

//in order to get methods from helper/base class, should use "extends" in class , or create object of it
public class LogInParametizedDataProvider extends Helper {

	@BeforeTest
	public void initializebrowser() throws IOException {
		driver = initializeDriver();

	}

	@Test(dataProvider = "getData")
	public void LogInPageParametize(String Username, String Password) throws IOException {

		// should write here too, because we are running url more than one
		driver.get(prop.getProperty("URL"));

		LogInPage lp = new LogInPage(driver);
		lp.logIn().click();
		lp.userName().sendKeys(Username);
		lp.password().sendKeys(Password);
		lp.logInButton().click();
		lp.InvalidEmailText().getText();

		// in case wrong credintials validate error text with assertion

		Assert.assertEquals(lp.InvalidEmailText().getText(), "Invalid email or password.");
		// if u want to validate any field is desplayed or not use:
		Assert.assertTrue(lp.logInButton().isDisplayed());

	}

	@AfterTest

	public void testEnd() {
		driver.quit();
	}

	@DataProvider
	public Object[][] getData() {

		// row stands for how many different data types test should run
		// column stands for how many values per each test

		// index size is 2, because 2 option, but index is starting from 0, so 0, 1
		// index size is 2, because fields are 2, but index is starting from 0, so 0, 1
		Object[][] data = new Object[2][2];
		// 0-th row
		data[0][0] = "tako";
		data[0][1] = "pass";

		// 1-th row
		data[1][0] = "tako1";
		data[1][1] = "pass";

		return data;

	}

}
